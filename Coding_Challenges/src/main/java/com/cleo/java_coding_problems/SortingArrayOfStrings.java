package com.cleo.java_coding_problems;

import java.util.Arrays;
import java.util.Comparator;

public class SortingArrayOfStrings {


        public static void main(String[] args) {
            String s1 = "deven";
            String s2 = "anchit";
            String s3 = "aanchal";
            String s4 = "aashvi";
            String s5 = "mom";
            String[] strs = {s1,s2,s3,s4,s5};

            /**
             * Too hard to remember
             */
            Arrays.sort(strs,
                    (String t1, String t2)
                            ->Integer.compare(t1.length(),t2.length()));
            System.out.println(Arrays.toString(strs));
            //Using Reference
            /**
             * Comparator.comparing(String::length)
             */
            Arrays.sort(strs,
                    Comparator.comparing(String::length)
                            .reversed());
            System.out.println(Arrays.toString(strs));

            //Lastly
            /**
             This is rememberable better than above two
             */
            strs=Arrays.
                    stream(strs)
                    .sorted(Comparator.comparing(String::length))
                    .toArray(String[]::new);
            System.out.println(Arrays.toString(strs));

            /**
             * Sorted lexicographically
             */
            var sortedStrings = Arrays
                    .stream(strs)
                    .sorted(Comparator.naturalOrder())
                    .toArray();
            System.out.println(Arrays.toString(sortedStrings));
        }


}
