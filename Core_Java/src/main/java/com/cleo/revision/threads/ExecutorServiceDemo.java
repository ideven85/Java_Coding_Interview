package com.cleo.revision.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ExecutorServiceDemo {

    public static long f(long x){
        if(x<=1)
            return 1;
        return x*f(x-1);
    }
    public static int g(int x){
        return x*2;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x=35;
        try {
            var list = LongStream.rangeClosed(1,1000).toArray();
         //   System.out.println(Arrays.toString(list));
            var list1 = new ArrayList<Long>();
            for(var el:list){
                list1.add(f(el));
            }
          //  System.out.println(list1);
            CompletableFuture<Long> completableFuture = new CompletableFuture<>();
            for(var element:list1)
                executorService.submit(()->{
                    try {
                        System.out.print(completableFuture.supplyAsync(() ->f(element)).get()+" ");
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });
            System.out.println("Completable Future: "+completableFuture.complete(f(10)));
            System.out.println();
            int df = g(x);
            System.out.println("Waiting");


            //boolean b =d;
            System.out.println(list1);
            System.out.println(" "+ df);
            executorService.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
