package com.cleo.revision.old.practice;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringFormatting {
    /**
     * Returns a {@code Collector} that concatenates the input elements into a
     * {@code String}, in encounter order.
     *
     * @return a {@code Collector} that concatenates the input elements into a
     * {@code String}, in encounter order

    public static Collector<CharSequence, ?, String> joining() {
        return new Collectors.CollectorImpl<CharSequence, StringBuilder, String>(
                StringBuilder::new, StringBuilder::append,
                (r1, r2) -> { r1.append(r2); return r1; },
                StringBuilder::toString, CH_NOID);
    } */

    public static String reversed(String original){
        return new StringBuilder(original)
                .reverse()
                .chars()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }
    public static void main (String[] args) {
        String name = "John";
        String name2 = new String("Jphn").intern();
        assert name==name2;

        int age = 30; // Using String.format() for formatting
         String formattedString = String.format("My name is %s and I am %d years old.", name, age);
         System.out.println(formattedString);
    }
}