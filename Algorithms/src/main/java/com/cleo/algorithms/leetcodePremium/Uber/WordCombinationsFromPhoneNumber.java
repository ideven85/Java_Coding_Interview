package com.cleo.algorithms.leetcodePremium.Uber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
//time complexity 4^n
public class WordCombinationsFromPhoneNumber {

    public static ArrayList<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        ArrayList<String> answer = new ArrayList<>();

        if (digits.isEmpty()) return answer;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        answer.addAll(ans);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
