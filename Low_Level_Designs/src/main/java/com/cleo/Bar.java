package com.cleo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

class Foo {
    int a, b, c;

    void methodX(int a) {
        a = setA(a);
        setBC(a, a);
    }

    void methodY(int a, int b) {
        b = setBC(a, b);
        setA(b);

    }
    static String name = "Foo";

    void print() {
        System.out.println(this.name); // Line 1
    }

    private int setA(int a) {
        return a = a;
    }

    private int setBC(int a, int b) {
        c = b = a;
        return b;
    }
}
public class Bar extends Foo {
    String name = "Bar";


    String myMethod(String argument) {
        // a valid body
        return argument;
    }

    /* Method 2 */
    String myMethod(Object argument) {
        // a valid body
       return null;
    }

    public static void main(String[] args) {
        Foo f = new Foo();
        f.methodY(10, 20);
        System.out.println(f.a);
        System.out.println(f.b);
        System.out.println(f.c);
        int x = 1, y = 2;
        x += x < y ? y : x;
        y = x < y ? y - x : y + x;
        System.out.println(x + " " + y);
        LocalTime localTime = LocalTime.of(1, 15, 30);

        localTime.withHour(2); // Line 1

        localTime.with(ChronoField.MINUTE_OF_HOUR, 30); // Line 2

        localTime.plusSeconds(15); // Line 3

        System.out.println(localTime);
    }

    /* Method 3 */

}

class Test {
    static boolean x;
    static boolean y;

    public static void main(String[] args) {
        x = x || y && !x;
        y = y && x || y;
        System.out.println(x);
        System.out.println(y);
    }
}