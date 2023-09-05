package com.cleo.algorithms.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSumToZero {
    public static int PairSum(int[] arr, int size) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count =0;
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
            }
            else hashMap.put(arr[i],1);
            if(k==0) count+=hashMap.get(arr[i])-1;
        }
        if (k==0) return count;
        for(int i=0;i<arr.length;i++){
            if(k!=0 && hashMap.containsKey(arr[i]-k)){
                count+=hashMap.get(arr[i]-k);
                hashMap.remove(arr[i]);
            }
            else if(k!=0 && hashMap.containsKey(arr[i]+k)){
                count+=hashMap.get(arr[i]+k);
                hashMap.remove(arr[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,1};
        System.out.println(PairSum(arr,arr.length));
      //  System.out.println(subarraySum(arr,2));
    }
}