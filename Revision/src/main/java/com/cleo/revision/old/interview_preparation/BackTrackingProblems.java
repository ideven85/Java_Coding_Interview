package com.cleo.revision.old.interview_preparation;

import java.util.*;

class AllPossiblePermutations {

    List<List<Integer>> answer = new ArrayList<>();
    private int count;

    public void permute(int[] nums, int left, int right) {
        if (left == right) {

            List<Integer> temp = new ArrayList<>();
            for (int c : nums) {
                temp.add(c);
            }
            if (!answer.contains(temp))
                answer.add(temp);


        } else {
            for (int i = left; i <= right; i++) {
                nums = swap(nums, i, left);
                permute(nums, left + 1, right);
                nums = swap(nums, i, left);
            }
        }
    }

    public int[] swap(int[] nums, int left, int right) {
        int temp = nums[ left ];
        nums[ left ] = nums[ right ];
        nums[ right ] = temp;
        return nums;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[ 0 ]);
            answer.add(temp);
            return answer;
        }

        permute(nums, 0, nums.length - 1);
        return answer;
    }
}
public class BackTrackingProblems {

    public static void generateBinaryStrings(int n){
        int[] A = new int[n];
        binary(A,n);
    }
    public static void binary(int[] A, int n){
        if(n<=0) {
            System.out.print(Arrays.toString(A)+ " ");
            return;
        }
        A[n-1]=0;
        binary(A,n-1);
        A[n-1]=1;
        binary(A,n-1);

    }
    static int majorityElement(int a[], int size)
    {
        // your code here
        int max = 0,el=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int c:a){
            if(map.get(c)==null){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
                if(max<map.get(c)){
                    max=map.get(c);
                    el=c;
                }

            }

        }
        return max>1?el:-1;

    }




    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        AllPossiblePermutations possiblePermutations = new AllPossiblePermutations();
        possiblePermutations.permute(nums);

        for(var c: possiblePermutations.answer){
            System.out.print(c+ " ");
        }
        System.out.println();
        generateBinaryStrings(4);
        System.out.println();
        System.out.println(majorityElement(nums,nums.length));
    }
}
