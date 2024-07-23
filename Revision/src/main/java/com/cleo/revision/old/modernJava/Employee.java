package com.cleo.revision.old.modernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {

    private final String name;
    private final int age;
    private final double salary;

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public double getSalary() {
        return salary;
    }



    public Employee(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return name;
    }

    public static List<Employee> sortingEmployees(List<Employee> employees, Predicate<Employee> p){
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Dave",23, (float) 123.1),
                new Employee("Jack",24,(float) 2345.2)

        );

        var employeesList = new ArrayList<>(employees);
        System.out.println(employeesList);
        var employeesSortedByName = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        var employeesSortedBySalary = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());

        System.out.println(employeesSortedByName);
        System.out.println(employeesSortedBySalary);

        System.out.println(sortingEmployees(employees, (Employee e)->e.getSalary()>2000));


    }
}
