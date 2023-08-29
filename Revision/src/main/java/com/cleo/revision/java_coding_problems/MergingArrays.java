package com.cleo.revision.java_coding_problems;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergingArrays {

    public static void main(String[] args) {
        int[] arr1 = IntStream.rangeClosed(1,10).toArray();
        int[] arr2 = IntStream.rangeClosed(11,20).toArray();
        int[] arr3 = IntStream.rangeClosed(21,30).toArray();
        Stream<int[]> stream1 = Stream.of(arr1);
        Stream<int[]> stream2 = Stream.of(arr2);
        Stream<int[]> stream3 = Stream.of(arr3);

        var cleoConcatenatedArray = Stream.
                concat(stream1,
                        Stream.concat(stream2,stream3))
                .parallel()
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println("Merged Arrays: " + Arrays.toString(cleoConcatenatedArray));




    }
}
