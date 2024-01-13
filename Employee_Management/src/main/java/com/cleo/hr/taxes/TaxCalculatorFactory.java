package com.cleo.hr.taxes;

import com.cleo.hr.personnel.Employee;
import com.cleo.hr.personnel.FullTimeEmployee;
import com.cleo.hr.personnel.Intern;
import com.cleo.hr.personnel.PartTimeEmployee;

public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {

        if (employee instanceof FullTimeEmployee) {
            return new FullTimEmployeeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}
