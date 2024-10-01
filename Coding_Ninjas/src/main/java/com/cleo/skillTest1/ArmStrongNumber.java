package com.cleo.skillTest1;

import java.util.Scanner;

public class ArmStrongNumber {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        String s = String.valueOf(N);
        int digits = s.length();
        double sum=0;
        int temp=N;
        while(temp!=0){
            sum+=Math.pow(temp%10,digits);
            temp/=10;
        }
        if((int)(sum)==N)
            System.out.println("true");
        else
            System.out.println("false");

    }
}
