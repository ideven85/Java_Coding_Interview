package com.cleo.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfString {
    private static List<String> permutations;
    public static String[] permutationOfString(String input){
        // Write your code here
        if(input==null||input.isEmpty()){
            String[] output = new String[1];
            output[0]="";
            return output;
        }
        permutations=new ArrayList<>();
        permutations.add("");
        permute(input,0,input.length()-1);
        String[] answer = new String[permutations.size()];
        for (int i = 0; i < permutations.size(); i++) {
            answer[i]=permutations.get(i);
        }
        return answer;

    }
    private static void permute(String input, int low, int high){
        if(low==high){
            if(!permutations.contains(input))
                permutations.add(input);
        }else{
            for (int i = low; i <=high ; i++) {
                input=swap(input,i,low);
                permute(input,low+1,high);
                input=swap(input,i,low);
            }
        }
    }
    private static String swap(String input, int left, int right){
        StringBuilder sb = new StringBuilder(input);
        char temp=input.charAt(left);
        sb.setCharAt(left,input.charAt(right));
        sb.setCharAt(right,temp);
        input= sb.toString();
        return input;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutationOfString("abc")));
    }

}
