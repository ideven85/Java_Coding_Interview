package com.cleo.dummy;


import java.util.Stack;

/**
 * LeetCode Hard
 * <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 */
public class BasicCalculator {


    //Example 1:
    //
    //Input: s = "1 + 1"
    //Output: 2
    //Example 2:
    //
    //Input: s = " 2-1 + 2 "
    //Output: 3
    //Example 3:
    //
    //Input: s = "(1+(4+5+2)-3)+(6+8)"
    //Output: 23

    /**
     *
     * @param s consists of digits, '+', '-', '(', ')', and ' '.
     * @return  implement a basic calculator to evaluate it, and return the result of the evaluation.
     */
    public int calculate(String s) {
        char[] operands = {'(','+','-',')',' '};
        Stack<Integer> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)&&stack.isEmpty())
                stack.add(Integer.parseInt(String.valueOf(c)));
            else{
                switch (c){

                }
            }
        }
        return 0;

    }
}
