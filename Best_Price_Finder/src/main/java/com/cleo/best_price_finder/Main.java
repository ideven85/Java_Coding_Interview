package com.cleo.best_price_finder;

import java.util.List;
import java.util.function.Supplier;

public class Main {

    private static final String PRODUCT = "iPhone 15 Plus";
    private static final BestPriceCalculator calculator = new BestPriceCalculator();

    public static void main(String[] args) {
        execute("Sequential: " ,  ()->calculator.findPricesSequential(PRODUCT));
        execute("Parallel: " ,  ()->calculator.findPricesParallel(PRODUCT));
        execute("Asynchronous Implementation: " ,  ()->calculator.findPricesAsync(PRODUCT));


    }

    private static void execute(String msg, Supplier<List<String>> s){
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
