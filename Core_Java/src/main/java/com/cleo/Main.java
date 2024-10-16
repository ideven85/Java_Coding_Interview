package com.cleo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> grid;
        Map<String,Integer> map = new HashMap<>();
        map.put("beach",1);
        int result = map.putIfAbsent("beach",2);
        System.out.println(result);
        System.out.println(System.getProperty("user.dir"));
        var prop = System.getProperties();
        for(var item:prop.entrySet())
            System.out.println(item.getKey() + "\t" + item.getValue());
  }
}