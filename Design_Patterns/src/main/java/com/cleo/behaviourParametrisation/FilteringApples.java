package com.cleo.behaviourParametrisation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    private static final List<Apple> inventory = Arrays.asList(
            new Apple("GREEN",160),
            new Apple("BLUE",80),
            new Apple("RED", 70),
            new Apple("RED", 180)


            );

    //Too Specialised
    public static List<Apple> filterGreenApples(List<Apple> apples){
        return apples.stream()
                .filter((apple -> apple.getColor().equals("GREEN")))
                .toList();
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }
    //Now What if we want to test both color and weight?

    public static void main(String[] args) {
        System.out.println("Green Apples are: "+filterApples(inventory,(Apple a)->a.getColor().equals("GREEN")));
        System.out.println("Apples with weight more than 150 are "+filterApples(inventory,(Apple a)->a.getWeight()>=150));
        System.out.println("Green Apples are " + filterGreenApples(inventory));

        List<Apple> redAndLight = filterApples(inventory,(Apple a)->a.getWeight()<150&&a.getColor().equals("RED"));
        System.out.println(redAndLight);


        //Using Streams
        List<Apple> heavyApples = inventory
                .stream()
                .filter((Apple a)->a.getWeight()>150)
                .toList();
        System.out.println(heavyApples);


        //Comparators

        Comparator<Apple> byWeight = (Apple a1, Apple a2)-> a1.getWeight()-a2.getWeight();
        System.out.println(inventory);
        inventory.sort(byWeight);
        System.out.println(inventory);
    }
}
