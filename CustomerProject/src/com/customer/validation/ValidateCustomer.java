package com.customer.validation;

import java.time.LocalDate;
import java.util.List;

import com.customer.CustomException;
import com.customer.Customer;
import com.customer.serviceplan;

public class ValidateCustomer {

	public static serviceplan validatePlan(String plan) throws CustomException
	{
		return serviceplan.valueOf(plan.toUpperCase());	
	}
	
	
	public static void validateRegAmount(serviceplan plan,double regAmount) throws CustomException
	{
		
		if(plan.getServiceCharges()!=regAmount)
			throw new CustomException("Amount doesnt match");
	}
	
	public static void validateMail(String email) throws CustomException
	{
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org)";
		if(!email.matches(pattern))
			throw new CustomException("Invalid email");
	}
	
	public static void duplicateMail(String email,List<Customer> customers) throws CustomException
	{
		if(customers.contains(new Customer(email)))
			throw new CustomException("Duplicate email");
	}
	
	public static void checkPassword(String password) throws CustomException
	{
		String pattern = "[A-Z]+[a-z0-9]+@";
		if(!password.matches(pattern))
			throw new CustomException("Invalid password");
	}
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	
	
	public static Customer validateAll(String firstName, String lastName, String email, String password, double regAmount, String dob, String plan, String lastSubscriptionPaidDate,List<Customer> customers) throws IllegalArgumentException, CustomException
	{
		serviceplan xplan=validatePlan(plan);
		validateRegAmount(xplan,regAmount);
		validateMail(email);
		duplicateMail(email,customers);
		LocalDate date = parseDate(dob);
		LocalDate lDate = parseDate(lastSubscriptionPaidDate);
		
		return new Customer(firstName,lastName,email,password,regAmount,date,xplan,lDate);
	}
	
}

