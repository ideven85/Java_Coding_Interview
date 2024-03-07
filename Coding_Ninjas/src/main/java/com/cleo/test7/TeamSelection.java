package com.cleo.test7;

import java.util.Scanner;

public class TeamSelection {

    private static void generateCombinations(int[] arr, int N, int current, String result){
        if(N==0){
            System.out.println(result);
            return;
        }
        if(current==arr.length)
            return;
        generateCombinations(arr,N-1,current+1,result+arr[current]+" ");
        generateCombinations(arr,N,current+1,result);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int [] arr = new int [s.nextInt()];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        generateCombinations(arr, 12, 0, "");
    }
}
