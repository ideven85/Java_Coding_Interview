package com.cleo;


import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public record Test(String a, String b) {

   /* @Override
    public String a() {
        return "Deven";

    }

    @Override
    public String b() {
        return "Kalra"
    }*/




    public  String  toString() {
        if(a==null || b==null)
            return null;

        /*Objects.requireNonNull(a,"a cannot be null");
        Objects.requireNonNull(b,"a cannot be null");
*/

        return a + " " + b;
    }

    public static void main(String[] args) {
        Test test = new Test("Deven","Kalra");
        Test test1 = new Test(null,null);
        LocalDate date = LocalDate.now();
        System.out.println(date);
       // System.out.println(date);
        System.out.println(test1 );
        Date date1 = new Date();
        System.out.println(date.getYear() + " " + date1.toInstant());
    }
}
