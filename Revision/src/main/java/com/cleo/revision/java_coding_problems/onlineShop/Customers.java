package com.cleo.revision.java_coding_problems.onlineShop;

import java.util.List;
import java.util.stream.Collectors;

public class Customers {

    private String name;
    private boolean is_active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Customers(String name, boolean is_active) {
        this.name = name;
        this.is_active = is_active;
    }

    public static void main(String[] args) {
        List<Customers> customers = List.of(
                new Customers("Deven",false),
                new Customers("Anchit",true),
                new Customers("John",true));
        var x = customers.stream()
                .filter(customer-> customer.is_active)
                .map(Customers::getName)
                .map(String::toUpperCase)
                .peek(n-> System.out.print(n + " "))
                .collect(Collectors.toList());
        System.out.println(x);
    }
}
