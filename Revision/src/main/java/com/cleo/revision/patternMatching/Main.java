package com.cleo.revision.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("deven",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Deven Kalra");
        System.out.println(matcher.find());
    }
}
