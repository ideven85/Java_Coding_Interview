package com.cleo.design_patterns.structural_design.behaviour_parametrization;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class AppleInventory {
    private final List<Apple> apples ;
    public AppleInventory(){
        apples = Arrays.asList(new Apple("GREEN",160),
                new Apple("BLUE",80),
                new Apple("RED", 70),
                new Apple("RED", 180),
                new Apple("GREEN",140)
        );
    }

}
