package com.cleo.fullTest2;

import java.util.Scanner;

public class BinomialExpansion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt(),X= in.nextInt(),n= in.nextInt();
        int count=0;
       // double term1=A,term2=X;
        int term = (int)Math.pow(A, n);
        System.out.print(term + " ");
        for (int i = 1; i <= n; i++) {
            term = term * X * (n - i + 1)
                    / (i * A);
            System.out.print(term + " ");
        }
    }
}
