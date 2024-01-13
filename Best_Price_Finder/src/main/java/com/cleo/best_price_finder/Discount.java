package com.cleo.best_price_finder;


import static com.cleo.best_price_finder.Util.delay;
import static com.cleo.best_price_finder.Util.format;

/**
 * Application of discounts offered by different shops in the mall
 */
public class Discount {

    public enum Code{
        NONE(0),SILVER(6),GOLD(10),
        PLATINUM(15),DIAMOND(20)
        ;

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    //Applying Discount and displaying it user friendly

    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is: " + quote.getPrice()+
                Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        delay();
        return format(price * (100 - code.percentage) / 100);
    }

}
