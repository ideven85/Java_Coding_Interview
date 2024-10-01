package com.cleo.revision;
import java.util.Arrays;

import static com.cleo.revision.Range.range;

public class TestRange {
    public static void show(int[] range){
        System.out.println(Arrays.toString(range));
    }

    public static void main(String[] args) {
        show(range(0,10,2));
        show(range(10));
        show(range(20,10,-1));
    }
}
