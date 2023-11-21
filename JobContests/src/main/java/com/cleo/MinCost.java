package com.cleo;

import java.util.ArrayList;
import java.util.Arrays;

public class MinCost {
    public static int minCostToBuyN(int n, int a, int b) {

        //    Write your code here.
        if(n==0)
            return 0;
        int items=1;
        int[] costItems = new int[n];
        costItems[0]=a;
        int i=1;
        for (i = 1; i < n; i++) {
            System.out.println("Items: " + items);

            if(costItems[i-1]+a<costItems[i-1]+b){
                items+=1;
                costItems[i]=costItems[i-1]+a;
            }else{
                costItems[i]=costItems[i-1]+b;
                items*=2;
            }
            if(items>=n)
                break;








        }
        System.out.println(Arrays.toString(costItems));
        return costItems[i-1];

    }
    public static void rotate(ArrayList<Integer> arr, int n) {
        // Write your code here.
        if(n<=1)
            return;
        int last=arr.get(n-1);
        for (int i = n-1; i >0 ; i--) {
            arr.set(i,arr.get(i-1));

        }
        arr.set(0,last);
    }

    public static void main(String[] args) {
        System.out.println(minCostToBuyN(5,2,3));
        ArrayList<Integer> arr =new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        rotate(arr,5);
        System.out.println(arr);
    }
}
