package com.cleo.nov10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestBeautifulSubsequence {
    public long factorial(int n){
        return n<=1?1:n*factorial(n-1);
    }
    public int longestSubsequenceLength(int n,int[] arr)
    {
        // Code here
        long curr=1,max=1,curr_max=0;
        int length=0,max_length=0;
       Arrays.sort(arr);
        //int n = arr.length;
        for (int i = n-1; i >=0 ; i--) {
            length++;
            System.out.print(curr*arr[i]+ " ");
            curr=(curr*arr[i])/factorial(length);

            //curr=curr/factorial(length);

          //  System.out.print(curr+ " ");
            if(max<=curr){
                max=curr;
                max_length=length;

            }else{
                length=1;
                curr=arr[i];

            }
        }
        System.out.println();

         //System.out.println(max);
        //System.out.println(max_length);
        return max_length;
    }

    public static void main(String[] args) {
       // System.out.println((10*9*8)/6);
        //System.out.println(90/2);

int[] arr={68,13,61,40,32,60,51,45,61,34,16,51,5,27,15,23,55,54,18,37,40,22,3,11,64,36,40,52,22,52,59,69,69,38,40,43,61,41,17,50,3,51,47,42,39,32,23,28,58,20,30,37,16,41,45,38,42,17,64,39,1,52,67,59,2,17,33,28,30,19};
        int n=arr.length;
        LongestBeautifulSubsequence longestBeautifulSubsequence = new LongestBeautifulSubsequence();
        System.out.println(longestBeautifulSubsequence.factorial(30));
        System.out.println(longestBeautifulSubsequence.longestSubsequenceLength(3,new int[]{1,3,2}));
        System.out.println(longestBeautifulSubsequence
                .longestSubsequenceLength(
                        12,new int[]{17, 13, 16, 7, 2, 8, 3, 15, 13, 18, 15, 13
        }));
        System.out.println(longestBeautifulSubsequence.longestSubsequenceLength(n,arr));


    }
}
