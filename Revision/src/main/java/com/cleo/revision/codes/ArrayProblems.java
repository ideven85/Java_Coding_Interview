package com.cleo.revision.codes;


import java.util.ArrayList;
import java.util.List;

public class ArrayProblems {
    public static int findPeakElement(int[] nums) {
        int u=nums.length-1;
        int l=0;
        int mid;
        while(l<u)
        {
            mid=l+(u-l)/2;
            if(nums[mid]<nums[mid+1]) l=mid+1;
            else u=mid;
        }
        return l;

    }
    public  int findPeakElement(int[] nums, int low,int high){
        for (int i = low; i <=high ; i++) {
            if(nums[i+1]<nums[i])
                return i;
        }

        return high;



    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> output = new ArrayList<>();
        while(lower<=upper)
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i]==lower)
                    lower++;
                else {
                    output.add(String.valueOf(lower));
                    while(lower!=nums[i+1])
                        lower++;
                    if(!output.contains(String.valueOf(lower)))
                        output.add("->"+(lower-1));


                }
            }




         return output;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,50,75};
        System.out.println(findPeakElement(nums));
    }
}
