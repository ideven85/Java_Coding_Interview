package com.cleo.amazon;

import java.util.*;

public class GroupAnagrams {
    public String sortWord(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s=new String(chars);
        return s;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();

        Map<String,List<String>> anagramMap=new TreeMap<>();
        for(String word:strs){
            String sortedWord=sortWord(word);
            anagramMap.putIfAbsent(sortedWord,new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        for(var map:anagramMap.entrySet()){
            List<String> temp=map.getValue();
            output.add(temp);

        }
        return output;


    }
}
