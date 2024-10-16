package com.cleo.design_patterns.structural_design.behaviour_parametrization;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples_First {


    interface ApplePredicate{
        boolean test(Apple apple);
    }

  static   class GreenApples implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.color().equalsIgnoreCase("Green");
        }
    }
   static class HeavyApples implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.weight()>150;
        }
    }

    private static final List<Apple> apples = new AppleInventory().getApples();

    public static void main(String[] args) {
        List<Apple> heavyApples = filter(new HeavyApples());

        List<Apple> greenApples = filter(new GreenApples());

        System.out.println("Heavy Apples are:"+ heavyApples);

        System.out.println("Green Apples are:"+ greenApples);
    }
    public static List<Apple> filter(ApplePredicate p){
        List<Apple> output = new ArrayList<>();
        for(Apple apple:apples){
            if(p.test(apple))
                output.add(apple);
        }
        return output;
    }
}
