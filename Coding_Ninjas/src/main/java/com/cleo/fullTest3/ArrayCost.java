package com.cleo.fullTest3;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCost {

    private static int calcuateCost(int[] input,int N){
        int i=N-3;
        int cost=input[N]+input[N-1];
        while(i-1>=0){
            cost+=input[i]+input[i-1];
            i-=3;
        }
        if(i>=0)
            while(i>=0){
                cost+=input[i];
                i--;
            }
        return cost;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=in.nextInt();
        }
        Arrays.sort(input);
        if(N==1)
            System.out.println(input[0]);
        else if(N==2)
            System.out.println(Arrays.stream(input).sum());
        else{
            System.out.println(calcuateCost(input,N-1));
        }
    }
}
