package com.cleo.design_patterns.structural_design.behaviour_parametrization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record Apple(String color, int weight) {


    @Override
    public String toString() {
        return "Apple has color: " + color() + " with weight: "  + weight();

    }
}
