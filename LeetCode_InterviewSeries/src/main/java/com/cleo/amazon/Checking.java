package com.cleo.amazon;

import java.util.*;

public class Checking {
    public static void main(String[] args) {
        Map<Integer,Integer> tracker = new TreeMap<>();
        tracker.put(1,2);
        tracker.put(2,300);
        tracker.put(0,100);
        System.out.println(tracker.get(0));


        for(var m:tracker.entrySet())
            System.out.println(m.getKey()+ " " + m.getValue());
        tracker.remove(0);

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(-2);

    }
}
