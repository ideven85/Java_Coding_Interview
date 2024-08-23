package com.cleo;

import java.util.HashMap;
import java.util.Map;

public class Test {


    private static int reverse(int num){
        if(num/10==0)
            return num;
        int reversed=0;
        while(num!=0){
            reversed=reversed*10+num%10;
            num/=10;
        }
        return reversed;

    }
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        if(x/10==0)
            return true;

        return x==reverse(x);





    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        System.out.println("Hi my is Deven Kalra");
        System.out.println("Welcome back to macbook");
        System.out.println(isPalindrome(121));

    }
}
