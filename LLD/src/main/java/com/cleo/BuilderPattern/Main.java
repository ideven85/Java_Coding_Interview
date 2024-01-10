package com.cleo.BuilderPattern;

import java.lang.reflect.AccessibleObject;
import java.util.EnumSet;

import static com.cleo.BuilderPattern.NyPizza.Size.*;
import static com.cleo.BuilderPattern.Pizza.Topping.*;

public class Main {


	public static void main(String[] args) {
		enum Test{ONE,TWO,THREE};
		EnumSet<Test> tests = EnumSet.noneOf(Test.class);
		tests.add(Test.ONE);
		System.out.println(tests);
		NyPizza pizza = new NyPizza.Builder(SMALL)
				.addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder()
				.addTopping(HAM).sauceInside().build();
		// AccessibleObject.setAccessible(NyPizza.class,true);
		System.out.println(pizza);
		System.out.println(calzone);
	}
}
