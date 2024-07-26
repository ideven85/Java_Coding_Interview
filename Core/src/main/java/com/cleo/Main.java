package com.cleo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    int[] a = new int[100];  // <==== DANGER WILL ROBINSON
int i = 0;
int n = 3;
while (n != 1) {
    a[i] = n;
    i++;  // very common shorthand for i=i+1
    if (n % 2 == 0) {
        n = n / 2;
    } else {
        n = 3 * n + 1;
    }
}
a[i] = n;
i++;
        System.out.println(Arrays.toString(a));
        System.out.println("Hello world!");
    }
}