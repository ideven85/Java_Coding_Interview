package com.cleo.skillTest2;

import java.util.Arrays;
import java.util.Scanner;

public class Combinations {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int number = s.nextInt();
        printCombination(number);
    }
    public static void printCombination(int num){
        //Write your code here
        printAllUniqueParts(num);

    }

    static void printArray(int p[], int n)
    {
       //Arrays.sort(p);
        for (int i = n-1; i >=0; i--) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    static void printAllUniqueParts(int n) {
        int[] p = new int[n];
        int k = 0;
        p[k] = n;


        while (true) {
            //Arrays.sort(p);
            printArray(p, k + 1);

            int rem_val = 0;
            while (k >= 0 && p[k] == 1) {
                rem_val += p[k];
                k--;
            }
            if (k < 0) return;

            p[k]--;
            rem_val++;
            while (rem_val > p[k]) {
                p[k + 1] = p[k];
                rem_val = rem_val - p[k];
                k++;
            }

            p[k + 1] = rem_val;
            k++;
        }
    }


}
