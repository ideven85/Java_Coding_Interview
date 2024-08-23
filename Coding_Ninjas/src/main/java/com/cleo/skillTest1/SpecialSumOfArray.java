package com.cleo.skillTest1;

public class SpecialSumOfArray {

    public static int sum(int[] arr)
    {
        //Write code here
        int sum=0;
        for(int num:arr){
            sum=sum+num;
            sum=sum/10+sum%10;





        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        System.out.println(sum(arr));
    }
}
