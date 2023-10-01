package com.cleo.algorithms.graphs;

import java.util.*;

/**
 * There is a new alien language that uses the English alphabet.
 * However, the order of the letters is unknown to you.
 * You are given a list of strings words from the alien language's dictionary.
 * Now it is claimed that the strings in words are sorted lexicographically by the rules of
 * this new language.
 * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters,
 * return "".
 * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order
 * by the new language's rules. If there are multiple solutions, return any of them.
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 */
// TODO: 01/10/23  
public class AlienDictionary {

    String[] words;


    public String alienOrder(String[] words) {
        this.words = words;
        //String s="wrt";//r is dependent on w and t is dependent r and w
        Map<Character,Set<Character>> dictionary = new LinkedHashMap<>();
        return "";
    }
    public static void main(String[] args) {
        String[] words = {"z","x","z"};
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(words));
    }
}
