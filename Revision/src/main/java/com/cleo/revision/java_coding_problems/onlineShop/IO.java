package com.cleo.revision.java_coding_problems.onlineShop;



import java.io.IOException;
import java.util.Scanner;

@FunctionalInterface
interface ScannerFloat{
    Float in(Scanner scanner) throws IOException;
}
public class IO {


    public static float read(ScannerFloat scannerFloat) throws IOException{
        try(Scanner in = new Scanner(System.in)){
           return scannerFloat.in(in);

        }
    }

    public static void main(String[] args) throws IOException{

        float s = IO.read(Scanner::nextFloat);
        System.out.println(s);

    }
}
