package com.cleo.revision;


import javax.annotation.PostConstruct;

public class Hi {

    @PostConstruct
    public static void hello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hi"));
        t.start();

        System.out.println("Hi");
        hello();
        t.join();
    }
}
