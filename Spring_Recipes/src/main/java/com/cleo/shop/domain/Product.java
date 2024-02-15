package com.cleo.shop.domain;


import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    private int id;
    private String name;

    private double price;


    public abstract boolean equals(Object o);


    public  int hashCode(){
        return 31 * id +  (int)name.charAt(0) + (int) price;

    }

    @Override
    public String toString() {
        return this.name + " has price " + this.price;
    }
}
