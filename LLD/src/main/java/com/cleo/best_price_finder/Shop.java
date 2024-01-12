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

    public String getPrice(String product){
        //to be implemented
       double price = calculatePrice(product);
       Discount.Code code = Discount.Code
               .values()[random.nextInt(Discount.Code.values().length)];

       return String.format("%2s:%.2f:%s",getName(),price,code);
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


    public String getName() {
        return shop;
    }

}
