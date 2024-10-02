package com.cleo.design_patterns.best_price_finder;

import java.util.Random;
import static com.cleo.design_patterns.best_price_finder.Util.delay;
import static com.cleo.design_patterns.best_price_finder.Util.format;
public class Shop {

    private final String shop;
    private final Random random;



    public Shop(String shop) {
        this.shop = shop;
        random=new Random((long) shop.charAt(0) *shop.charAt(1)+shop.charAt(2));
    }


    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return shop + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }


    public String getName() {
        return shop;
    }

}
