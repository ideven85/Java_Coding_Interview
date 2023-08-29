package com.cleo.revision.java_coding_problems.onlineShop;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Gadgets> gadgets = List.of(
                new Gadgets("Macbook Pro 2021", 1450,"Laptop"),
                new Gadgets("iPad Pro 2021", 1250,"Tablet"),
                new Gadgets("iPhone 12", 145,"Phone"));

        var laptops = gadgets.stream()
                .filter(c -> c.getType().equals("Laptop")).collect(Collectors.toList());
        System.out.println(laptops);


        gadgets.stream()
                .filter(c->c.getWeight()>=1000)
                .forEach(n -> System.out.print(n + "\t"));

    }
}
