package com.cleo.hr.persistence;

import com.cleo.hr.personnel.Employee;
import com.google.gson.Gson;

public class EmployeeFileSerializer {
	public String serialize(Employee employee) {
		/*StringBuilder sb = new StringBuilder();

		sb.append("### EMPLOYEE RECORD ####");
		sb.append(System.lineSeparator());
		sb.append("NAME: ");
		sb.append(employee.getFullName());
		sb.append(System.lineSeparator());
		sb.append("POSITION: ");
		String type = employee.getClass().getTypeName();
		type = type.substring(type.lastIndexOf('.') + 1);
		sb.append(type);
		sb.append(System.lineSeparator());
		sb.append("EMAIL: ");
		sb.append(employee.getEmail());
		sb.append(System.lineSeparator());
		sb.append("MONTHLY WAGE: ");
		sb.append(employee.getMonthlyIncome());
		sb.append(System.lineSeparator());

		return sb.toString();*/
		Gson gson = new Gson();

		return gson.toJson(employee, Employee.class);

	}

}
