package com.cleo.revision.old.modernJava.ch03;

import java.util.List;
import java.util.stream.Collectors;

public class HighCalorieNames {

    public static void main(String[] args) {
        List<String> names = Dish.dishes.stream()
                .filter(dish -> {
                    System.out.print("filtering " + dish.getName());
                    return dish.getCalories() > 400;
                })
                .map(dish -> {
                    System.out.println("Mapping name");
                    return dish.getName();
                })
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(names);

    }
}
