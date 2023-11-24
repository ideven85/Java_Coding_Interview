package com.cleo.amazon;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {
    public boolean isValid(String brackets) {
        Deque<Character> stack = new LinkedList<Character>();

        for(Character ch : brackets.toCharArray()){
            char checkChar = getOpeningCharacter(ch);
            if(checkChar == 0){
                stack.addFirst(ch);
            }else{
                if(stack.isEmpty() || stack.peek() != checkChar){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    private Character getOpeningCharacter(char ch){
        switch(ch){
            case ')' : return '(';
            case ']' : return '[';
            case '}' : return '{';
            default : return 0;
        }

    }


}
