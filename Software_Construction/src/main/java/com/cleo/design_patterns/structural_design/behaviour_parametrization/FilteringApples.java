package com.cleo.design_patterns.structural_design.behaviour_parametrization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;




public class FilteringApples {


    private static final List<Apple> inventory =  new AppleInventory().getApples();

    //Too Specialised
    public static List<Apple> filterGreenApples(List<Apple> apples){
        return apples.stream()
                .filter((apple -> apple.color().equals("GREEN")))
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
        System.out.println("Green Apples are: "+filterApples(inventory,(Apple a)->a.color().equals("GREEN")));
        System.out.println("Apples with weight more than 150 are "+filterApples(inventory,(Apple a)->a.weight()>=150));
        System.out.println("Green Apples are " + filterGreenApples(inventory));

        List<Apple> redAndLight = filterApples(inventory,(Apple a)->a.weight()<150&&a.color().equals("RED"));
        System.out.println(redAndLight);


        //Using Streams
        List<Apple> heavyApples = inventory
                .stream()
                .filter((Apple a)->a.weight()>150)
                .toList();
        System.out.println(heavyApples);


        //Comparators

        Comparator<Apple> byWeight = (Apple a1, Apple a2)-> -a1.weight()+a2.weight();
        System.out.println(inventory);
        inventory.sort(byWeight);
        System.out.println(inventory);
    }
}
