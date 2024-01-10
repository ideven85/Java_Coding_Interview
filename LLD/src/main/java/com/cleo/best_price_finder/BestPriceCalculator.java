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
            new Shop("mnop"),
            new Shop("my_favorite_shop"),
            new Shop("my_favorite_shop"),
            new Shop("my_favorite_shop"),
            new Shop("my_favorite_shop"),
            new Shop("my_favorite_shop")
    );

    private final Executor executor = Executors.newFixedThreadPool
            (Math.min(shopsInMall.size(),100),(Runnable r)->{
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });


    public List<String> findPricesSequential(String product){
        return shopsInMall.stream()
                .map(shop -> String.format("%s price is: %s",
                        shop.getName(),shop.getPrice(product)))
                .collect(toList());
    }
    public List<String> findPricesParallel(String product){
        return shopsInMall.parallelStream()
                .map(shop -> String.format("%s price is: %s",
                        shop.getName(),shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findPricesAsync(String product){
        List<CompletableFuture<String>> futurePrices=shopsInMall
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        ()->(
                        shop.getName() + " price is " + shop.getPrice(product)
                        ),executor))
                .toList();
        //Now to get list of prices from CompletableFuture prices..

        return futurePrices.stream()
                .map(CompletableFuture::join)
                .toList();



    }
}
