package com.cleo.best_price_finder;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncShopClient {

    private static long fib(int n){
        if(n<2)
            return n;
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        Shop shop = new Shop("Myb");

        var futurePrice = shop.getPriceAsync("Macbook_Pro");

        System.out.println(fib(30));
        try{
            double price = futurePrice.get(1,TimeUnit.SECONDS);
            System.out.printf("Price is %.2f%n", price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

            BestPriceCalculator bestPriceCalculatorV1 = new BestPriceCalculator();
            long start = System.nanoTime();
            System.out.println(bestPriceCalculatorV1.findPricesSequential("myPhone27S"));
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Sequential Done in " + duration + " msecs");
            start = System.nanoTime();
            System.out.println(bestPriceCalculatorV1.findPricesParallel("myPhone27S"));
            duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Parallel Done in " + duration + " msecs");
        start = System.nanoTime();
        System.out.println(bestPriceCalculatorV1.findPricesAsync("myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Async Done in " + duration + " msecs");


    }
}
