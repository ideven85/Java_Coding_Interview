package com.cleo.revision.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {

    public static long f(int x){
        if(x<=1)
            return 1;
        return x*f(x-1);
    }
    public static int g(int x){
        return x*2;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        int x=35;
        try {
            var list = IntStream.rangeClosed(1,1000).toArray();
            CompletableFuture<Long> cf = new CompletableFuture();
            for(var element:list)
                executorService.submit(() -> cf.complete(f(element)));
            int df = g(x);
            var d = cf.get();
            System.out.println(d);
            System.out.println(d + df);
            executorService.shutdown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException ie){
                ie.printStackTrace();
        }
    }
}
