package com.cleo.revision.practice;

import java.util.StringTokenizer;

public class Stings {
    public static void main(String[] args) {
        String name = "My name is Khan";
        StringTokenizer st = new StringTokenizer(name," ");
        while(st.hasMoreTokens())
            System.out.print(st.nextToken()+ " ");
    }
}
