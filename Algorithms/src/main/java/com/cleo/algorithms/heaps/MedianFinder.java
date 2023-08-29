package com.cleo.algorithms.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// TODO: 15/08/23 Re do the whole question 
class MedianFinder {

    Queue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

    Queue<Integer> minPQ = new PriorityQueue<>();
    int totalNum = 0;
    boolean isNumLessThanZero = false;

    public MedianFinder() {

    }

    public void addNum(int num) {
        totalNum += 1;

        if (maxPQ.isEmpty()) {
            maxPQ.offer(num);
            return;
        }

        if (minPQ.isEmpty() && num >= maxPQ.peek()) {
            minPQ.offer(num);
            return;
        }

        if (num < maxPQ.peek()) {
            //can i put in maxPQ
            if (maxPQ.size() - minPQ.size() > 0)
                minPQ.offer(maxPQ.poll());
            maxPQ.offer(num);

        } else if (num > minPQ.peek()) {
            //can i put in min
            if (!(minPQ.size() < maxPQ.size()))
                maxPQ.offer(minPQ.poll());
            minPQ.offer(num);

        } else {
            if (minPQ.size() == maxPQ.size()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
        }


    }

    public double findMedian () {

        double val = 0;
        if (totalNum % 2 == 0) {
            val = (double) (maxPQ.peek() + minPQ.peek()) / 2;

        } else {

            val = maxPQ.peek();
        }

        return val;

    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(2);
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());

    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */