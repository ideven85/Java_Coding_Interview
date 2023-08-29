package com.cleo.revision.java_coding_problems.onlineShop;

interface GadgetPredicate{
    boolean test(Gadgets gadget);

}

public class Gadgets{

    private String name;
    private int weight;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gadgets(String name, int weight, String type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public Gadgets() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
