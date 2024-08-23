package com.cleo.fullTest3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintSuperPrimes {

    private static final Map<Integer,Integer> primeMap = new HashMap<>();

    private static boolean checkPrime(int num){
        if(num<=1)
            return false;
        if(num%2==0&&num!=2)
            return false;
        if(num==2)
            return true;
        for (int i = 3; i <=(int)Math.sqrt(num) ; i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }
    private static void superPrimes(int N){
        int prime=1;
        int i=1;
       while(i<=N){
            if(checkPrime(i))
                primeMap.put(prime++,i);
            i++;



        }
        for ( i = 1; i <=N ; i++) {
            if(primeMap.get(i)!=null&&checkPrime(i))
                System.out.print(primeMap.get(i)+ " ");

        }




    }
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        superPrimes(N);

    }
}
