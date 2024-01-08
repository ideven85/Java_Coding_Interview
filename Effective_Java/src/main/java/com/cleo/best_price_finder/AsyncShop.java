package com.cleo.best_price_finder;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        //Seed
        this.random=new Random((long) name.charAt(0) *name.charAt(1)+name.charAt(2));
    }

    public Future<Double> getPriceAsyncFactory(String product){
        delay();
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }

    public static void delay(){
        try{
            Thread.sleep(1000L);
        }catch (InterruptedException ie){
            throw new RuntimeException(ie);
        }
    }
    private double calculatePrice(String product){
        delay();
        return random.nextDouble()*product.charAt(0)+product.charAt(1);

    }
}
