package com.cleo.revision.records;

import java.util.Objects;
interface UserDAO{

    String getNameAndAge();
}
record User(String name, int age, String profession) implements UserDAO{
    @Override
    public String getNameAndAge(){
        return "Hi "+name + "of " + age;
    }

    public User {
        Objects.requireNonNull(name);
        Objects.requireNonNull(profession);
        name=name+ " ";
        profession=profession.toUpperCase();
    }

    @Override
    public String toString() {
        return name + " " + age + " "+ " " + profession;
    }
}
public record Container<T>(T content, String identifier) {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>("hello String","1");
        System.out.println(stringContainer);
        User user = new User("Deven",23,"Software Engineer");
     //   user.setName("Anchit");
        System.out.println(user);
        System.out.println(user.name());
        System.out.println(user.getClass().isSealed());
    }
}


