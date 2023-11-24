package com.cleo.amazon;

import java.util.*;

public class MinStack {

    private final Map<Integer,Integer> tracker;
    private final Stack<Integer> stack;
    private int length;
    public MinStack() {
      tracker   = new TreeMap<>();
        stack = new Stack<>();
    }
    private int size(){
        return length;
    }

    public void push(int val) {
        stack.push(val);
        tracker.put(length++,val);


    }

    public void pop() {
        if(size()>=0){
           stack.pop();
            tracker.remove(length-1);

            length--;
        }
        return;

    }

    public int top() {
        System.out.println(stack);
        return size()>=0?stack.peek():-1;

    }

    public int getMin() {
        if(size()>=0){
            //System.out.println(tracker.get(-2));
            //tracker.remove(0);
           // stack.removeElement(answer);
            return tracker.get(length-1);


           // length--;

        }else
            return -1;
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(100);
        minStack.push(-3);
        minStack.push(-2);
       /* System.out.println(minStack.tracker.keySet().toArray().length);*/
        for(var m:minStack.tracker.entrySet())
            System.out.println(m.getKey()+":"+m.getValue());
        System.out.println(minStack.getMin()); // return -3
       // minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }
}
