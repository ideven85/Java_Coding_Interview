package com.cleo.cleo_mall;

import com.cleo.best_price_finder.Discount;
import com.cleo.best_price_finder.ExchangeService;
import com.cleo.best_price_finder.Quote;
import com.cleo.best_price_finder.ExchangeService.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {

    //private final String SHOPS = BestPriceFinder.class.getResource('./shops.txt').getFile();
    private final List<Shop> shops = List.of(
            new Shop("Kalra_Electronics"),
            new Shop("Cleo_Portal"),
            new Shop("Icrest")
    );



    //todo Implement sequential,parallel and async methods to get price of a
    // product offered by these shops


    private final Executor executor = Executors.newFixedThreadPool(shops.size(),
            (Runnable r)->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public List<String> gettingPricesSequentially(String product){

        return shops.stream()
                .map(shop -> shop.getName()+" price is " + shop.calculatePrice(product))

                .toList();

    }
    public List<String> gettingPricesParallel(String product){

        return shops.parallelStream()
                .map(shop -> shop.getName()+" price is " + shop.calculatePrice(product))
                .toList();

    }

    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                                + shop.getPrice(product), executor))
                        .toList();

       return  priceFutures.stream()
                .map(CompletableFuture::join)
               .toList();


    }

    public List<String> findPricesInUSD(String product) {
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            // Start of Listing 10.20.
            // Only the type of futurePriceInUSD has been changed to
            // CompletableFuture so that it is compatible with the
            // CompletableFuture::join operation below.
            CompletableFuture<Double> futurePriceInUSD =
                    CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                            .thenCombine(
                                    CompletableFuture.supplyAsync(
                                                    () ->  ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD))
                                            // Timeout management added in Java 9
                                            .completeOnTimeout(ExchangeService.DEFAULT_RATE, 1, TimeUnit.SECONDS),
                                    (price, rate) -> price * rate
                            )
                            // Timeout management added in Java 9
                            .orTimeout(3, TimeUnit.SECONDS);
            priceFutures.add(futurePriceInUSD);
        }
        // Drawback: The shop is not accessible anymore outside the loop,
        // so the getName() call below has been commented out.
        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .map(price -> /*shop.getName() +*/ " price is " + price)
                .collect(Collectors.toList());
        return prices;
    }

    public List<String> findPricesInUSDJava7(String product) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            final Future<Double> futureRate = executor.submit(new Callable<Double>() {
                @Override
                public Double call() {
                    return ExchangeService.getRate(Money.EUR, Money.USD);
                }
            });
            Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {
                @Override
                public Double call() {
                    try {
                        double priceInEUR = shop.getPrice(product);
                        return priceInEUR * futureRate.get();
                    }
                    catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            });
            priceFutures.add(futurePriceInUSD);
        }
        List<String> prices = new ArrayList<>();
        for (Future<Double> priceFuture : priceFutures) {
            try {
                prices.add(/*shop.getName() +*/ " price is " + priceFuture.get());
            }
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }

    public List<String> findPricesInUSD2(String product) {
        List<CompletableFuture<String>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            // Here, an extra operation has been added so that the shop name
            // is retrieved within the loop. As a result, we now deal with
            // CompletableFuture<String> instances.
            CompletableFuture<String> futurePriceInUSD =
                    CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                            .thenCombine(
                                    CompletableFuture.supplyAsync(
                                            () -> ExchangeService.getRate(Money.EUR, Money.USD)),
                                    (price, rate) -> price * rate
                            ).thenApply(price -> shop.getName() + " price is " + price);
            priceFutures.add(futurePriceInUSD);
        }
        List<String> prices = priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }

    //Fastest
    public List<String> findPricesInUSD3(String product) {
        // Here, the for loop has been replaced by a mapping function...
        Stream<CompletableFuture<String>> priceFuturesStream = shops.stream()
                .map(shop -> CompletableFuture
                        .supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(
                                CompletableFuture.supplyAsync(() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
                                (price, rate) -> price * rate)
                        .thenApply(price -> shop.getName() + " price is " + price));
        // However, we should gather the CompletableFutures into a List so that the asynchronous
        // operations are triggered before being "joined."
        List<CompletableFuture<String>> priceFutures = priceFuturesStream.collect(Collectors.toList());
        List<String> prices = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return prices;
    }


}
