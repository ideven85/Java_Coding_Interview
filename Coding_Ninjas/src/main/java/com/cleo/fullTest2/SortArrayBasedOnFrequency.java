package com.cleo.fullTest2;

import java.util.*;

public class SortArrayBasedOnFrequency {

    private static int[] sortArray(int[] arr, int N){
        Arrays.sort(arr);
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Objects.equals(frequencyMap.get(a), frequencyMap.get(b))
                ? b - a: frequencyMap.get(a) - frequencyMap.get(b));

        for(int element:arr)
            frequencyMap.compute(element,(k,v)->v==null?1:++v);


        for (int j : arr) {
            pq.offer(j);
        }
        int n = arr.length;
        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = pq.poll();
        }
        return result;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]= in.nextInt();
        }
        int[] result=sortArray(arr,N);
        for (int i = N-1; i >=0; i--) {
            System.out.print(result[i]+" ");
        }

    }
}
