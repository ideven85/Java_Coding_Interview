package com.cleo.revision;


public class Hi {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hi"));
        t.start();

        System.out.println("Hi");
        t.join();
    }
}
