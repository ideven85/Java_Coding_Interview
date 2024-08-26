package com.cleo.revision.records_new;

import java.util.Optional;

interface Student{
    String getSchoolName();
}
record StudentImpl(String name, String school ) implements Student{
    @Override
    public String getSchoolName() {
        return school;
    }
}
public record Person(String name, int age, String school) implements Student {

    @Override
    public String getSchoolName() {
        return school;
    }

    public static void main(String[] args) {
        Student student = new StudentImpl("Deven", "IIIT Hyderabad");
       Person deven = new Person("Deven",21, "IIIT Hyderabad");
        System.out.println(student);
        System.out.println(deven.name()+" "+deven.getSchoolName());
    }
}
