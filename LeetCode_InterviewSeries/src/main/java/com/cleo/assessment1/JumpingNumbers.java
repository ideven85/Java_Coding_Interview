package com.cleo.assessment1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class JumpingNumbers {
//  private static final   List<Integer> output = new ArrayList<>();

    private static void generateList(int n,int digits){
       /* for (int i = n; i >=0 ; i--) {
            StringBuffer sb = new StringBuffer();
            String s = String.valueOf(i);
            int num=s.length();

        }*/
        //

    }

    // TODO: 01/12/23
    public static List<Integer> findJumpingNumbers(int n) {
        //n=3459
        //3456,3454
        //1
        //10,             12                    21,23,      32,34,,43,45
        //101,            121,123=>"12+1","12+3"
        //1010,1012,      1210,1213,1231,
        //10101,10121,10123
        //Trying Brute Force
        List<Integer> output = new ArrayList<>();
        int[] arr = IntStream.rangeClosed(0,n).toArray();
        for(int num:arr){
            boolean flag=true;
            String temp=String.valueOf(num);
            for (int i = 0; i < temp.length()-1; i++) {
                int first=Integer.parseInt(String.valueOf(temp.charAt(i)));
                int second=Integer.parseInt(String.valueOf(temp.charAt(i+1)));
                if(Math.abs(first-second)!=1){
                    flag=false;
                    break;
                }

            }
            if(flag)
                output.add(num);
        }
        /*String s = String.valueOf(n);
        int digits = s.length();
        generateList(n,digits);
        */
        return output;
    }

    public static int sumOfMaxMin(int[] arr, int n) {
        // Write your code here.
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int num:arr){
            if(max<num)
                max=num;
            if(min>num)
                min=num;
        }
        return max+min;
    }

    public static void main(String[] args) {
        System.out.println(findJumpingNumbers(9999999));
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(sumOfMaxMin(arr,arr.length));
    }

}