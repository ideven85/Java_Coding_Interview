package com.cleo.skillTest2;

import java.util.Scanner;

public class WaterNJugs {

    private static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    private static String canJugBeFilled(int a, int b, int c){
        if(a+b<c)
            return "No";
        if(c%(gcd(a,b))==0)
            return "Yes";
        return "No";
    }
    public static void main(String[] args) {
        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0){
            int john= in.nextInt();
            int zeus = in.nextInt();
            int peter= in.nextInt();
            System.out.println(canJugBeFilled(john,zeus,peter));

        }

    }
}
