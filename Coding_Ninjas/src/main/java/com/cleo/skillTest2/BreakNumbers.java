package com.cleo.skillTest2;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BreakNumbers {

    private static void generateCombinationsSumN(int[] arr, int[] output,int start,int end,int index,int N){
        if(index==N){
            for (int i = 0; i < N; i++)
                System.out.print(output[i]+" ");
            System.out.println("");
            return;


        }
        for (int i=start; i<=end && end-i+1 >= N-index; i++) {
            output[index] = arr[i];
            generateCombinationsSumN(arr, output, i+1, end, index+1, N);
        }
    }
    public static void printCombination(int[] arr,int n, int N){
        //Write your code here
        int[] output = new int[N];

        generateCombinationsSumN(arr, output, 0, n-1, 0, N);
    }
    static void cobination(int arr[], int data[], int start, int end, int indices, int N) {
        if (indices == N) {
            for (int j=0; j<N; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= N-indices; i++) {
            data[indices] = arr[i];
            cobination(arr, data, i+1, end, indices+1, N);
        }
    }

    static void PossibleComb(int arr[], int n, int N) {

        int data[]=new int[N];
        cobination(arr, data, 0, n-1, 0, N);
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num= in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]= in.nextInt();
        }
        //printCombination(arr,arr.length,arr.length);
        int r=num-1;
        PossibleComb(arr,arr.length,r);
    }
}
