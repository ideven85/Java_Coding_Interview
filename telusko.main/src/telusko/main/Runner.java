package telusko.main;

import telusko.util.Calculator;

public class Runner {


    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("From different module simple int: "+ c.add(1,2));
        System.out.println("From different module simple float/double" + c.add(1.2,2.4));
    }

}
