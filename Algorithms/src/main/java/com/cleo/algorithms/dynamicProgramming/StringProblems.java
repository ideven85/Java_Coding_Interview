package com.cleo.algorithms.dynamicProgramming;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringProblems {

    // TODO: 10/08/23 MUST DO 
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,String> map = new LinkedHashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(i,wordDict.get(i));
        }
        int index=0;
        for (int i = 0; i < s.length(); i++) {

        }
        return false;

    }
}
