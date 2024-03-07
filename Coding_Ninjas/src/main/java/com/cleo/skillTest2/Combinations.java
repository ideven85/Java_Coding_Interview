package com.cleo.skillTest2;

import java.util.Arrays;
import java.util.Scanner;

public class Combinations {
    private static void generateCombinationsSumN(int[] arr, int[] output,int start,int end,int index,int N){
        if(index==N){
            for (int i = 0; i < N; i++)
                System.out.print(output[i]+" ");
            System.out.println();
            return;


        }
        for (int i=start; i<=end && end-i+1 >= N-index; i++) {
            output[index] = arr[i];
            generateCombinationsSumN(arr, output, i+1, end, index+1, N);
        }
    }
    public static void printCombination(int[] arr){
        //Write your code here
        int[] output = new int[arr.length];
        int num=arr.length;
        generateCombinationsSumN(arr,output,0,num-1,0,12);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num= in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]= in.nextInt();
        }
        printCombination(arr);
    }

}
