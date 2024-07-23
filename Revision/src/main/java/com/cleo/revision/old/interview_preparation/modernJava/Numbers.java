package com.cleo.revision.old.interview_preparation.modernJava;

import java.util.List;

public class Numbers {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        var sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        int product = numbers.stream().reduce(1,(a,b)->a*b);
        System.out.println(product);

        int evenProductWithoutFive = numbers.stream()
                .filter(n ->n%2==0&&n%5!=0)


                .reduce(1,(a,b)->a*b);
        int oddProductWithFive = numbers
                .stream()
                        .filter(n ->n%2!=0||n%5==0)

                                .reduce(1,(a,b)->a*b);
        System.out.println(evenProductWithoutFive);
        System.out.println(oddProductWithFive);

    }
}
