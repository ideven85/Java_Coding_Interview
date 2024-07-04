package com.cleo.hr.personnel;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Models an employee form a business perspective
 */
@Getter
@Setter
public abstract class Employee {
    private String firstName;
    private String lastName;
    private int monthlyIncome;
    private int nbHoursPerWeek;

    public Employee(String fullName, int monthlyIncome){
        setMonthlyIncome(monthlyIncome);

        String[] names = fullName.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public String getEmail() {
        return this.firstName + "." +
                this.lastName +
                "@globomanticshr.com";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("### EMPLOYEE RECORD ####");
        sb.append(System.lineSeparator());
        sb.append("NAME: ");
        sb.append(getFullName());
        sb.append(System.lineSeparator());
        sb.append("POSITION: ");
        String type = this.getClass().getTypeName();
        type = type.substring(type.lastIndexOf('.') + 1);
        sb.append(type);
        sb.append(System.lineSeparator());
        sb.append("EMAIL: ");
        sb.append(getEmail());
        sb.append(System.lineSeparator());
        sb.append("MONTHLY WAGE: ");
        sb.append(getMonthlyIncome());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

/*
    public int getMonthlyIncome() {
        return monthlyIncome;
    }
*/

    public void setMonthlyIncome(int monthlyIncome) {
        if(monthlyIncome < 0){
            throw new IllegalArgumentException("Income must be positive");
        }

        this.monthlyIncome = monthlyIncome;
    }

   /* public int getNbHoursPerWeek() {
        return nbHoursPerWeek;
    }
*/
    public void setNbHoursPerWeek(int nbHoursPerWeek) {
        if(nbHoursPerWeek <= 0){
            throw new IllegalArgumentException("Income must be positive");
        }

        this.nbHoursPerWeek = nbHoursPerWeek;
    }

   /* public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
*/
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

}
