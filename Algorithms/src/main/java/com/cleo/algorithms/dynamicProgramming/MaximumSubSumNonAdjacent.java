package com.cleo.algorithms.dynamicProgramming;

public class MaximumSubSumNonAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length==0)
            return 0;
        else if(array.length==1)
            return array[0];
        // Write your code here.
        int first=Math.max(array[0],array[1]),second=array[0],current=0;
        for (int element = 2; element < array.length; element++) {


            current=Math.max(first,second+array[element]);
            second=first;
            first=current;




        }
        return first;
    }

    public static void main(String[] args) {
        int[] arr = {75,105,120,75,90,135};
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }
}
