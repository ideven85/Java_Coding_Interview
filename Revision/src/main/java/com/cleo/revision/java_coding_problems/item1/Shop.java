package com.cleo.revision.java_coding_problems.item1;

import java.util.List;

public class Shop {
    static RecursiveCall<Long> sum(Long total, long pre){
        if(pre==1L)
            return RecursiveCall.done(total);
        return ()->sum(total,pre-total);

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        var a = System.nanoTime();
        for (long i = 1L; i < 100; i++) {
            System.out.print(sum(1L,i).run()+"\t");
        }
        var b = System.nanoTime();
        System.out.println();
        System.out.println(b -a);
        //System.out.println(result.run());

        Order order = Order.getInstance();
        order.setItems(List.of("Laptop","Macbook","Ipad"));
        order.setAmount(3000);
        System.out.println(order);
    }
}
