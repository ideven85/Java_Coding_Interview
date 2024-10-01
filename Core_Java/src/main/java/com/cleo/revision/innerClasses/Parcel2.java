package com.cleo.revision.innerClasses;


public class Parcel2 {
    record Person(int age, String name){}

    public static void main(String[] args) {
        Person p = new Person(24, "Deven");
        System.out.println(p+" ");
        System.out.println(p.name()+" " + p.age());

    }
}



