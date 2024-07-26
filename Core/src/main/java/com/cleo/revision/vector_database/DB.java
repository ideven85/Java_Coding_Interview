package com.cleo.revision.vector_database;

import java.util.ArrayList;
import java.util.List;

/**
 * Let’s represent the vector database using a 2D grid
 * where one axis represents the color of the animal (brown, black, white)
 * and the other axis represents the size (small, medium, large).
 */
class Animal{
    private final List<String> colors;
    private final List<String> sizes;

    public Animal() {
        colors = List.of("brown","black","white");
        sizes = List.of("small","medium","large");

    }

}
public class DB {

    private final List<Animal> animals;

    public DB() {
        animals = new ArrayList<>();


    }
}
