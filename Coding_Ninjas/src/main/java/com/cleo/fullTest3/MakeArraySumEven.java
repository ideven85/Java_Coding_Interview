package com.cleo.fullTest3;

import java.util.Scanner;

public class MakeArraySumEven {
    public static void main (String[] args) {
        // Write your code here
        // Take input and print desired output
        Scanner in = new Scanner(System.in);
        int count = 0;
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int num= in.nextInt();
            if(num%2!=0)
                count++;
        }
        if(count%2==0)
            System.out.println(N-count);
        else
            System.out.println(count);



    }
}
