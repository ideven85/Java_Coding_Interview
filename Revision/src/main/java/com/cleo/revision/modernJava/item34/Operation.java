package com.cleo.revision.modernJava.item34;

public enum Operation {

    PLUS("+"){
        public double apply(double x, double y){
            return x+y;
        }
    },
    MINUS("-"){
        public double apply(double x, double y){
            return x-y;
        }
    },
    MULTIPLY("*"){
        public double apply(double x, double y){
            return x*y;
        }
    },
    DIVIDE("/"){
        public double apply(double x, double y){
            return y!=0?x/y:-1;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

    public abstract double apply(double x, double y);


    public static void main(String[] args) {
        double x = 2.0,y=3.9;
        for(Operation op: Operation.values()){
            System.out.println("Result: " + x + " " + op + " " + y +"="+ op.apply(x,y));
        }

    }
}
