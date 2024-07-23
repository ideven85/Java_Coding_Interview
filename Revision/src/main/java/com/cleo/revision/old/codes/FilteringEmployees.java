package com.cleo.revision.old.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringEmployees {

    static class Employee{
        private String name;
        private String gender;
        private int roll_number;

        public Employee(String name, String gender, int roll_number) {
            this.name = name;
            this.gender = gender;
            this.roll_number = roll_number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getRoll_number() {
            return roll_number;
        }

        public void setRoll_number(int roll_number) {
            this.roll_number = roll_number;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    static interface EmployeePredicate{
        boolean test(Employee e);
    }
    static List<Employee> filteringEmployees(List<Employee> employees,EmployeePredicate p){
        List<Employee> result = new ArrayList<>();
        for(var e:employees){
            if(p.test(e))
                result.add(e);
        }
        return result;

    }

    private static final List<Employee> employees = Arrays.asList(
            new Employee("Deven","MALE",21),
            new Employee("Anchit","MALE",22),
            new Employee("Aanchal","FEMALE",23),
            new Employee("Susan","FeMALE",24),
            new Employee("Pooja","FeMALE",20),
            new Employee("Prabhu","MALE",19),
            new Employee("Modi","MALE",18)


            );

    public static boolean isMale(Employee e){
        return e.gender.equals("MALE");
    }


    public static void main(String[] args) {

        List<Employee> maleEmployees = employees.stream().filter(FilteringEmployees::isMale).toList();
        List<Employee> femaleEmployees = employees.stream().filter(c->!isMale(c)).toList();
        System.out.println("Male Employees: "  + maleEmployees);
        System.out.println("Female Employees: " + femaleEmployees);

        List<Employee> males = filteringEmployees(employees,e->e.getGender().equals("MALE"));
        System.out.println("Male Employees: "  + males);
        List<Employee> sortedEmployees = employees.stream().sorted((c1,c2)->c1.getRoll_number()-c2.getRoll_number()).toList();
        System.out.println(sortedEmployees);



    }
}
