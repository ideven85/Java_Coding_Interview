package com.cleo.shop;

import com.cleo.shop.config.ShopConfig;
import com.cleo.shop.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);

        Product duracell = context.getBean("duracell",Product.class);
        Product mercedes = context.getBean("mercedes",Product.class);
        System.out.println(duracell);
        System.out.println(mercedes);

    }
}
