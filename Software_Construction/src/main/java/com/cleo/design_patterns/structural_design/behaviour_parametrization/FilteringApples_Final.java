package com.cleo.design_patterns.structural_design.behaviour_parametrization;

import java.util.List;

public class FilteringApples_Final {

    private static final List<Apple> apples = new AppleInventory().getApples();



    public static void main(String[] args) {
        List<Apple> greenApples = apples.stream().filter(apple -> apple.color().equalsIgnoreCase("Green")).toList();
        System.out.println("Green Apples: " + greenApples);
        List<Apple> heavyApples = apples.stream().filter(apple -> apple.weight()>150).toList();
        System.out.println("Heavy Apples: " + heavyApples);
        List<Apple> greenAndHeavyApples = apples.stream().filter(apple -> heavyApples.contains(apple) && greenApples.contains(apple)).toList();
        System.out.println("Green And Heavy Apples: " + greenAndHeavyApples);



    }
}
