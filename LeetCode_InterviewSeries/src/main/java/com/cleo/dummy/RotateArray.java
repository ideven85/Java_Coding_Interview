package com.cleo.dummy;


import java.util.Arrays;
import java.util.stream.IntStream;


public class RotateArray {
    public  void reverse(int[] array, int fromIndex, int toIndex) {
       int i = fromIndex;

        for(int j = toIndex - 1; i < j; --j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            ++i;
        }

    }
    public void rotate(int[] nums, int k) {
       int n=nums.length;
       k=k%n;
       int first=0,last=n-1;
       reverse(nums,first,n);
       reverse(nums,first,k);
       reverse(nums,k,n);

    }

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1,2).toArray();
        new RotateArray().rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
