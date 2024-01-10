package com.cleo.best_price_finder;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String shop;
    private final Random random;



    public Shop(String shop) {
        this.shop = shop;
        random=new Random((long) shop.charAt(0) *shop.charAt(1)+shop.charAt(2));
    }

    //todo
    public double getPrice(){
        //We want our client to supply his own product... Something is wrong with this code
        return 0;
    }

    public double getPrice(String product){
        //to be implemented
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() ->{
//            try {
//                double price = calculatePrice(product);
//                //Complete is non blocking
//                futurePrice.complete(price);
//            }catch (Exception ex){
//                futurePrice.completeExceptionally(ex);
//            }
//        }).start();
        //Return the future price without waiting for the result to be computed
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

    @Override
    public String toString() {
        return "Shop " + getName() + " has product available with price: " + getPrice();
    }

    public String getName() {
        return shop;
    }

/*
    public static void main(String[] args) {
        Shop shop = new Shop("Cleo Electronics");
        long start = System.nanoTime();
        //Why we are changing the product name
        Future<Double> futurePrice = shop.getPriceAsync("MacBook_Pro_2022");
        long invocation_time = ((System.nanoTime() -start)/1_000_000);
        System.out.println("Price to calculate: " + invocation_time + " milliseconds");
        System.out.println(factorial(20));

        try{
            //Getting Price in a blocking call
            double price = futurePrice.get();

            System.out.printf("Price is %.2f%n", price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        long total_time=((System.nanoTime() -start)/1_000_000);
        System.out.println("Price to retrieve " + total_time  + " milli seconds");



    }
*/
    private static double factorial(int n){
        return n<2?1:n*factorial(n-1);
    }

}
