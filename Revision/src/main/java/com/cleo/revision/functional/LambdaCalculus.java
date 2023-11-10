package com.cleo.revision.functional;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaCalculus {

    void capture(){
        var theAnswer = 42;

        Runnable printTheAnswer = () -> System.out.println(theAnswer);

        run(printTheAnswer);
    }
    void run(Runnable r){
        r.run();
    }

    /**
     * Lambda Calculus
     * @param n Input
     * @return A function
     */
    Predicate<Integer> isGreaterThan(final int n){
        return compareValue->compareValue > n;
    }

    public static void main(String[] args) {
        LambdaCalculus calculus = new LambdaCalculus();
        calculus.capture();
        ModifyTwiceSample modifier = (x)->x*2;
        int y = modifier.modifyTwice(5);
        System.out.println(y);
        Predicate<String> isNull = Objects::nonNull;
        var five = calculus.isGreaterThan(5);
        var six = calculus.isGreaterThan(6);
        System.out.println(five.test(5));
        System.out.println(five.test(13));
        BiFunction<Integer,Integer,List<Integer>> range =
                ( start, end)->IntStream.rangeClosed(start,end).boxed().toList();
    }
}
