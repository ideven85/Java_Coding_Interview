package com.cleo.revision.mit;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecursiveCalls {
    //subsequences("abc") might return "abc,ab,bc,ac,a,b,c,".
    // Note the trailing comma preceding the empty subsequence, which is also a valid subsequence.
    public static String subsequences(String word) {
        if(word.isEmpty())
            return "";
        else {
            var first = word.charAt(0);
            var restSequencences = word.substring(1);
            String subsequencesOfRest = subsequences(restSequencences);
            StringBuilder result = new StringBuilder();
            for (var subsequence : subsequencesOfRest.split(",", -1)) {
                result.append(",").append(subsequence);
                result.append(",").append(first).append(subsequence);
            }
            return result.substring(1);
        }

    }
    private static Map<String,String> memo;
    public static String subsequencesAlternative(String word){
        return subsequencesHelper("",word);
    }
    public static String partial;

    private static String subsequencesHelper(String partial,String word){
        if(word.isEmpty())
            return partial;
        /*if(memo.containsKey(partial))
            return ;*/
       // System.out.println(memo);
        memo.put(partial,subsequencesHelper(partial , word.substring(1))+","+subsequencesHelper(partial + word.charAt(0),word.substring(1)));
        return memo.get(partial);
    }

    /**
     * @param n integer to convert to string
     * @param base base for the representation. Requires 2<=base<=10.
     * @return n represented as a string of digits in the specified base, with
     *           a minus sign if n<0.  No unnecessary leading zeros are included.
     */
    public static String stringValue(int n, int base) {
        if (n < 0) {
            return "-" + stringValue(-n, base);

        } else if (n<base) {
            //return "0123456789".substring(n,n+1);
            return ""+n;

        } else {
            return stringValue(n/base, base) + "0123456789".charAt(n%base);
        }
    }

    public static String getFullPath(File file){
        if(!file.exists())
            return "File Does Not exist";
        else {
            if (file.getParentFile() == null)
                return file.getName();
            else
                return getFullPath(file.getParentFile()) + "/" + file.getName();
        }
    }

    public static void main(String[] args) {
        memo = new LinkedHashMap<>();
        memo.put("",",");
        System.out.println(subsequences("123"));
        System.out.println(subsequencesAlternative("123"));
        System.out.println(memo);
        System.out.println(stringValue(-829,9));
        System.out.println(getFullPath(new File(System.getProperty("user.home")+"/hello.py")));
        System.out.println(Path.of(System.getProperty("user.dir")));
        System.out.println(System.getProperty("user.dir"));
    }
}
