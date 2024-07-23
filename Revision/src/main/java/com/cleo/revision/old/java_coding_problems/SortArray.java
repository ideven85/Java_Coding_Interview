package com.cleo.revision.old.java_coding_problems;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    // write code here

    private static void reverse(int[] arr){
        System.out.print("Array = "+Arrays.toString(arr));
        System.out.println();
        int n = arr.length;
        if(n==1)
            return;
        for(int i=0;i<n/2;i++){
            int temp = arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        System.out.println("Reversed array = " + Arrays.toString(arr));

    }



    public static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.println("Element " +i + " contents" + arr[i]);
        }
    }
    public static void getIntegers(int n) throws Exception{
        int[] arr = new int[n];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        printArray(arr,n);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        reverse(arr);
    }
}