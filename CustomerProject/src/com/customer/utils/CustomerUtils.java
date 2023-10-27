package com.customer.utils;

import com.customer.CustomException;
import com.customer.Customer;
import com.customer.test.Tester;

public class CustomerUtils {

	public static Customer validateMailPassword(String mail,String password)
	{
		Customer refCustomer= new Customer(mail,password);
		for (Customer c: customers)
		{
			if(c.equals(refCustomer))
			{
				System.out.println("You can now Login !");
				return refCustomer;
			}
			else
				return null;
			
			Throw new CustomException ("Invalid Credentials");
		}
	}
}
