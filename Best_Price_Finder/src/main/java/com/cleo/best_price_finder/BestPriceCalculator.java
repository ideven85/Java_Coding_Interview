package com.cleo.best_price_finder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toList;

public class BestPriceCalculator {

    private final List<Shop> shopsInMall = List.of(
            new Shop("abc"),
            new Shop("def"),
            new Shop("ghi"),
            new Shop("jkl"),
            new Shop("mnop")
    );

    private final Executor executor = Executors.newFixedThreadPool
            (Math.max(shopsInMall.size(),100),(Runnable r)->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });


    /*
    Applying Discount sequentially
     */
    public List<String> findPricesSequential(String product){

        return shopsInMall.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .toList();
    }
    /**
     * Party time now, we do parallel
     */
    public List<String> findPricesParallel(String product){

        return shopsInMall.parallelStream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .toList();
    }
    /**
     * Hardest Part, Doing it async,
     * We want to refactor this to be able to combine the parsing quote, which is a blocking operation
     * and querying for discount service from the server... into one operation
     */

    public List<String> findPricesAsync(String product){
        List<CompletableFuture<String>> futurePrices = shopsInMall.parallelStream()
                .map(shop ->
                        CompletableFuture.supplyAsync(()->
                        shop.getPrice(product),executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                ()->
                                Discount.applyDiscount(quote),executor
                                ))
                )
                .toList();
        return futurePrices.parallelStream()
                .map(CompletableFuture::join)
                .toList();

    }
}

