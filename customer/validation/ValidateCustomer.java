package com.customer.validation;

import java.time.LocalDate;
import com.customer.CustomException;
import com.customer.Customer;
import com.customer.serviceplan;

public class ValidateCustomer {

	public boolean validatePlan(String plan)
	{
		for(serviceplan s: serviceplan.values())
			if(s.equals(plan))
				return true;
		return false;
	}
	
	public boolean validateRegAmount(String plan,Double regAmount )
	{
		for(serviceplan s: serviceplan.values())
		{
			serviceplan sp=serviceplan.DIAMOND;
			if(sp.getServiceCharges().equals(regAmount))
		return false;
		}
	}
	
	public static Customer validateAll(int customerId,String firstName, String lastName, String email, String password, Double regAmount, LocalDate dob, serviceplan plan) throws IllegalArgumentException, CustomException
	{
		return new Customer(firstName,lastName,email,password,regAmount,dob,plan);
	}
	
}
