package com.customer.utils;

import java.util.Comparator;

import com.customer.Customer;

public class dateNnameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1,Customer c2) {
		
		int ret= c1.getDob().compareTo(c2.getDob());
		
		if(ret==0)
		{
			return c1.getLastName().compareTo(c2.getLastName());
		}
		
		return ret;
	}

}
