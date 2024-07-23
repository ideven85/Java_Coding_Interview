package com.cleo.revision.old.modernJava;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionAPI {
    public static void main(String[] args) {
        Set<String> friends = Stream.of("Rachael","Olivia","Deven").collect(Collectors.toSet());
        System.out.println(friends);
    }
}
