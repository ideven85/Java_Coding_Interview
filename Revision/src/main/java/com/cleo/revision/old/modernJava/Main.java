package com.cleo.revision.old.modernJava;


import java.util.function.Function;

abstract class ExtendMe{
    public abstract void overRideMe();

    public final int stringLength(final String x){

        Function<String,Integer> length = String::length;
        return length.apply(x);
    }
    public final void sayHello(){
        System.out.println("Hi");
    }
}

class FirstExtendedClass extends ExtendMe{



    @Override
    public void overRideMe() {
        System.out.println("In First Extended Class");
    }

}
public class Main extends ExtendMe{

    @Override
    public void overRideMe() {
        System.out.println("Hi there");
    }

    public static void main(String[] args) {
        Main obj1 = new Main();
        obj1.overRideMe();
        obj1.sayHello();

        FirstExtendedClass firstExtendedClass = new FirstExtendedClass();
        System.out.println(firstExtendedClass.stringLength("Deven"));
        firstExtendedClass.overRideMe();
        firstExtendedClass.sayHello();
    }
}
