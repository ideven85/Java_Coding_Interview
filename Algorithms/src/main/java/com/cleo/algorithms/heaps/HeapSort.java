package com.cleo.algorithms.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public static void inplaceHeapSort(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    private static void buildHeap(int[] arr, int n) {
        if (n == 0)
            return;


        int parent = (n - 1) / 2, childIndex = (n - 1);
        while (childIndex >= 0) {
            if (arr[parent] > arr[childIndex]) {
                int temp = arr[parent];
                arr[parent] = arr[childIndex];
                arr[childIndex] = temp;
                childIndex = parent;
                parent = (childIndex - 1) / 2;
            } else
                return;
        }

    }

    private static void heapifyDown(int[] arr, int low, int high) {


    }




   /* public static void InplaceHeapSort()

    {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        whlie(leftChildIndex < n) {
        int minIndex = parentIndex;
        if (arr[leftChildIndex] < arr[minIndex]) {
            minIndex = leftChildIndex;
        }

        if (rightChild < n && arr[rightChildIndex] < arr[minIndex]) {
            minIndex = rightChlidIndex;
        }
        if (minIndex == parentIndex) {
            return;
        }
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[minIndex];
        arr[minIndex] = temp;
        parentIndex = minIndex;
        leftChildIndex = 2 * parentIndex + 1;
        rightChildIndex = 2 * parentIndex + 2;

    }
    }


   public static void heapSort(int[] arr) {
        //Build the heap
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeapify(arr, i, n);
        }
        //Remove elemts from starting one by one, and put them at respective last position
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0, i);
        }
    }

   */


    public static void main (String[]args){
        int[] arr = {4, 7, 3, 2, 8, 9, 6, 1};
        //heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    }

class KLargest{
    public static void printKLargest(int[] arr, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ();

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

            System.out.println(pq.poll());

    }
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ((a,b)->b-a);

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length;i++){
            if(pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()){
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;


    }
    public static void main(String[] args){
        int[] arr={2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        int k= 4;
        printKLargest(arr,k);
    }
}