package com.cleo.algorithms.hashing;

import java.util.Arrays;

public class MissingPositive {

    public static int missingNumber(int[] nums) {
       int missing;
       boolean zero=false;
       int n =nums.length;
        for (int i = 0; i <n ; i++) {

                if(nums[i]==0)
                    zero=true;
                while (nums[i] != i+1 && nums[i] > 0) {
                    missing = nums[i];
                    nums[i] = nums[missing - 1];
                    nums[missing - 1] = missing;
                }
            if(nums[i]==0)
                zero=true;
            }


        System.out.println(Arrays.toString(nums));
        System.out.println(zero);
        if(!zero)
            return 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return -1;


    }
    void swap(int[] arr,int i,int correct) {
        int temp=arr[i];
        arr[i]= arr[correct];
        arr[correct]= temp;
    }
    public int missingNumberV2(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        // case 2
        return arr.length;
    }


    public static void main(String[] args) {
        int[] nums= {0,2,1,4};
        System.out.println(missingNumber(nums));
    }
}
