package com.cleo.revision;


import java.util.logging.Logger;


public class Hi {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hi"));
        t.start();

        System.out.println("Hi");
        t.join();
    }
}
