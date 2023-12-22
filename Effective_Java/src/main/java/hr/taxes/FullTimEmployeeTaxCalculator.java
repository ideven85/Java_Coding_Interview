package hr.taxes;

import hr.personnel.Employee;

public class FullTimEmployeeTaxCalculator implements TaxCalculator {
	// Fixed $100 amount for base health insurance
	//- 16% income tax
	//- 10% retirement tax
	private static  int  BASE_HEALTH_INSURANCE=100;
	private static  int INCOME_TAX=16;
	private static  int RETIREMENT_TAX=10;

	@Override
	public double  calculateTax(Employee employee){

		return BASE_HEALTH_INSURANCE +
				(employee.getMonthlyIncome()*INCOME_TAX)/100.0+
				(employee.getMonthlyIncome()*RETIREMENT_TAX)/100.0;



	}
}
