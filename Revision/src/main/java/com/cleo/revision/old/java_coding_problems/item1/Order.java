package com.cleo.revision.old.java_coding_problems.item1;

import java.util.Arrays;
import java.util.List;

public class Order {

    private static final Order INSTANCE = new Order();

    private List<String> items;

    private long amount;



    private Order() {
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public static Order getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }

    @Override
    public String toString() {
        return Arrays.toString(items.toArray());
    }
}
