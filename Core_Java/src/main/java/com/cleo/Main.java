package com.cleo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        var prop = System.getProperties();
        for(var item:prop.entrySet())
            System.out.println(item.getKey() + "\t" + item.getValue());
  }
}