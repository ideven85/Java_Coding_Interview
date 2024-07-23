package com.cleo.revision.old.java_coding_problems.item4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class DishComparator implements Comparator<Dish>{
        @Override
        public int compare(Dish o1, Dish o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static void main(String[] args) {
        System.out.println("List of vegetarian dishes");
        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .forEach(x-> System.out.print(x.getName()+ " "));

        List<String> lowCalorieDishes =
                        Dish.menu.parallelStream()
                                .filter(d->d.getCalories()<400)
                                .sorted(Comparator.comparing(Dish::getCalories))
                                .map(Dish::getName)
                                        .collect(Collectors.toList());
        System.out.println("\nLow calorie dishes are");
        System.out.println(lowCalorieDishes);

        System.out.println("Dish types sorted by name are");


                Dish.menu.stream()
                        .map(Dish::getType)
                        .sorted()
                                .forEach(c-> System.out.print(c.name()+" "));

                List<String> movies = List.of("Coda","SEE","Matrix","That 70s show");
        System.out.println();
        movies.stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(c-> System.out.print(c+ " "));
        System.out.println();
        List<Dish> specialMenu = Dish.menu.stream()
                .takeWhile(c->c.getCalories()>320)
                        .collect(Collectors.toList());
        specialMenu.forEach(c-> System.out.println(c.getName()+ " " + c.getType()));

    }
}
