package com.cleo.assessment1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


// TODO: 01/12/23
public class MaxStack {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> max = new Stack<Integer>();
    /** initialize your data structure here. */
    public MaxStack() {

    }
    //O(1);
    public void push(int x) {
        data.push(x);
        if (max.isEmpty()) {
            max.push(x);
        }
        else {
            max.push(Math.max(x, max.peek()));
        }
    }
    //O(1);
    public int pop() {
        max.pop();
        return data.pop();
    }
    //O(1);
    public int top() {
        return data.peek();
    }
    //O(1);
    public int peekMax() {
        return max.peek();
    }
    //O(n);
    public int popMax() {
        int res = max.peek();
        Stack<Integer> tmp = new Stack<Integer>();
        while (data.peek() != res) {
            tmp.push(data.pop());
            max.pop();
        }
        data.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return res;
    }
    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
  /*obj.push(1);
        System.out.println(obj.pop());

  int param_3 = obj.top();*/
  obj.push(5);
  obj.push(1);
 // obj.push(5);
  //["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
        //[[],[5],[1],[5],[],[],[],[],[],[]]
  /*int param_4 = obj.peekMax();
  int param_5 = obj.popMax();
        System.out.println(param_3);
        System.out.println(param_4);
      //  System.out.println(param_5);
        System.out.println(obj.top());*/
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        obj.push(2);
        System.out.println(obj.top());
       /* System.out.println(obj.pop());*/
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
