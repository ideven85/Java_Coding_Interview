package com.cleo.hr.main;

import com.cleo.hr.logging.ConsoleLogger;
import com.cleo.hr.persistence.EmployeeFileSerializer;
import com.cleo.hr.persistence.EmployeeRepository;
import com.cleo.hr.personnel.Employee;
import com.google.gson.Gson;

import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        // Grab employees
        Gson gson = new Gson();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            try {
                repository.save(e);
                System.out.println(("Successfully saved employee: " + e.toString()));
            }catch (Exception ie){

                consoleLogger.writeError("Error saving: " + ie.getLocalizedMessage());
            }
        }
    }
}
