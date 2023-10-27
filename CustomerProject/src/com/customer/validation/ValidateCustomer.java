package com.customer.validation;

import java.time.LocalDate;
import com.customer.CustomException;
import com.customer.Customer;
import com.customer.serviceplan;

public class ValidateCustomer {

	public static boolean validatePlan(String plan)
	{
		for(serviceplan s: serviceplan.values()) 
		{
			if(s==serviceplan.valueOf(plan.toUpperCase()))
				return true;
		}
		return false;
	}
	
	
	public static boolean validateRegAmount(String plan,Double regAmount)
	{
		for(serviceplan s: serviceplan.values())
		{
			if(s.getServiceCharges()==regAmount)
				return true;
		}
		return false;
	}
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	public static Customer validateAll(String firstName, String lastName, String email, String password, Double regAmount, String dob, String plan) throws IllegalArgumentException, CustomException
	{
		validatePlan(plan);
		validateRegAmount(plan,regAmount);
		LocalDate date = parseDate(dob);
		serviceplan xplan=serviceplan.valueOf(plan.toUpperCase());
		
		return new Customer(firstName,lastName,email,password,regAmount,date,xplan);
	}
	
}

