package com.cleo.revision.item2;

/**
 * The Following record is same as the final class below
 */
record Person_Record(int age, String name){}


final class Person1 {
    private int age;
    private String name;

    public Person1(){

    }
    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int age() {
        return age;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
//implementation not shown for brevity
        return super.equals(o);
    }

    @Override
    public int hashCode() {
//implementation not shown for brevity
        return super.hashCode();
    }

    @Override
    public String toString() {
//implementation not shown for brevity
        return super.toString();
    }
}



public class Person{
    //First 3 parameters do not have a default value
    private final String name;
    private final int age;
    private final String sex;
    private  final String profession;
    private final boolean isMarried;

    public static class Builder{
        private final String name;
        private final int age;
        private final String sex;
        private String profession;
        private boolean isMarried;
        public Builder(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }
        public Builder isMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
    /*public Person(){
        this(Builder)
        //this(builder);
    }*/
    public Person(Builder builder){

        this.name = builder.name;
        this.age = builder.age;
        this.sex= builder.sex;
        this.profession = builder.profession;
        this.isMarried=builder.isMarried;
    }

    public String toString(){
        return this.name + " " + this.age;
    }

    public static void main(String[] args) {
        Person p = new Builder("Deven",24,"Male").profession("Software Engineer").build();
        System.out.println(p);
    }

}
