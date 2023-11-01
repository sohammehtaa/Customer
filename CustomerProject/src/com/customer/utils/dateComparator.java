package com.customer.utils;

import java.util.Comparator;

import com.customer.Customer;

public class dateComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2)
	{
		if(c1.getDob().isBefore(c2.getDob()))
			return -1;
		if(c1.getDob().isEqual(c2.getDob()))
			return 0;
		return 1;
	}

}
