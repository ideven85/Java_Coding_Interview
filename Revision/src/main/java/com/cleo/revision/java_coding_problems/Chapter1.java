package com.cleo.revision.java_coding_problems;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;

public class Chapter1 {

    public static void generatePermutations(String str){
        var a= System.nanoTime();
        permuteAndPrintFunctionally("", str);
        var b = System.nanoTime();
        System.out.println();
        System.out.println(b-a);


        permuteAndPrint("",str);
        var c= System.nanoTime();
        System.out.println();
        System.out.println(c-b);
    }

    public static void permuteAndPrint(String prefix, String s){
        int n = s.length();
        if(n==0)
            System.out.print(prefix + " ");
        else{
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix+s.charAt(i),s.substring(i+1,n)+s.substring(0,i));
            }
        }
    }

    //Functional Style
    private static void permuteAndPrintFunctionally(String prefix,String str){
        int n = str.length();
        if(n==0)
            System.out.print(prefix+ " ");
        else{
            IntStream.range(0,n)
                    .parallel()
                    .forEach(i->permuteAndPrintFunctionally(prefix+str.charAt(i),str.substring(i+1,n)+str.substring(0,i)));
        }
    }


    //Functional Style
    public static boolean isPalindrome(String s){

        return IntStream.range(0,s.length()/2)
                .noneMatch(p->s.charAt(p)!=s.charAt(s.length()-p-1));
    }

    //Functional Style

    public static String removeDuplicates(String s){
        return Arrays.stream(s.split(""))
                .distinct()
                .collect(Collectors.joining());
    }


    public static String removeCharacter(String s, char ch){

        /**
         * First Approach
         */
        System.out.println(s.replaceAll(Pattern.quote(String.valueOf(ch)),""));


        /**
         * Normal Approach
         */

        StringBuilder sb = new StringBuilder();
       for(char c:s.toCharArray()){
            if(c!=ch)
                sb.append(c);
        }
        System.out.println(sb.toString());

        /**
         * Functionally
         */

        return s.chars()
                .filter(c->c!=ch)
                .mapToObj(c->String.valueOf((char)(c)))
                .collect(Collectors.joining());



    }

    public static void main(String[] args) {
        generatePermutations("12345");
        System.out.println(isPalindrome("nittin"));
        String s = "nitttin";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates("deven"));
        System.out.println(removeCharacter(s,'i'));
        }



}
