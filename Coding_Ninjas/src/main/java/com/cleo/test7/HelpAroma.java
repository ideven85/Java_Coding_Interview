package com.cleo.test7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelpAroma {

    private static boolean areAnagrams(String s1, String s2){
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        for(char c:s2.toCharArray()){
            if(map.get(c)!=null&&map.get(c)!=0)
                map.put(c,map.get(c)-1);
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s= in.nextLine();
        int N = in.nextInt();
        while(N-->0) {
            String s1 = (s.substring(in.nextInt() - 1, in.nextInt()));
            String s2 = (s.substring(in.nextInt() - 1, in.nextInt()));
            if (s1.length() != s2.length()) {
                System.out.println(false);
            } else

                System.out.println(areAnagrams(s1, s2));
        }

    }
}
