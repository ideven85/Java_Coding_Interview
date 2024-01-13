package com.cleo.cleo_mall;

import com.cleo.best_price_finder.Discount;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.cleo.best_price_finder.Util.delay;
import static com.cleo.best_price_finder.Util.format;


public class Shop{
    private final String name;

    //Why do we want random in the final code?
    private final Random random;

    public Shop(String name) {
        this.name=name;
        random = new Random((long) name.charAt(0)*name.charAt(1)+name.charAt(2));
    }
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public String getName() {
        return name;
    }


}
