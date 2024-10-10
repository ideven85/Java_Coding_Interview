package com.cleo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[5];

        Arrays.fill(array, "Hello");

        System.out.println(array[2]);
        System.out.println("Hello world!");
    }
}
