package com.cleo.fileReaderAsync;

import java.util.concurrent.Callable;

public class Test {

    public void process(Runnable r){
        r.run();
    }

    public void log(){
        process(()-> System.out.println("This is stupid " + Thread.currentThread().getName()));
    }

    public Callable<String> fetch(){
        return ()->"In Fetch Very Tricky";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Test().log();

        }

        Thread old_way = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        Thread t = new Thread(()-> System.out.println("Hello World"));
    }

}

class MeaningOfThis{

    private final int value=4;

    public void random_method(){
        int value=6;
        Runnable r = new Runnable() {
            public final int value=5;
            @Override
            public void run() {
                int value=6;
                System.out.println(this.value);


            }
        };
        r.run();
    }

    public static void main(String[] args) {
        new MeaningOfThis().random_method();
    }
}
