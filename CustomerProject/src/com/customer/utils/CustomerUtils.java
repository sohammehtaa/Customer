package com.customer.utils;

import static com.customer.validation.ValidateCustomer.validateAll;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.customer.CustomException;
import com.customer.Customer;

public class CustomerUtils {

	public static Customer validateMailPassword(String mail,String password,List<Customer> list) throws CustomException
	{
		Customer c=new Customer(mail);
		int index=list.indexOf(c);
		if(index!=-1) {
				if(password.equals(list.get(index).getPassword()))
				{
					return list.get(index);
				}
				else 
					throw new CustomException("Incorrect Password !");
			}
			else
				throw new CustomException("Mail Doesn't exist in list !");
	 }
	
	public static void printList(List<Customer> list)
	{
		for(Customer c: list)
			System.out.println(c);
	}
	
	public static long calculatePeriod(LocalDate startDate, LocalDate endDate)
	{
		Period period = Period.between(startDate,endDate);
		return period.toTotalMonths();
		
	}
	
	public static String pendingSubscriptions(List<Customer> customers)
	{
		for(Customer s: customers)
		{
			if(calculatePeriod(s.getLastSubscriptionPaidDate(),LocalDate.now())>6);
			return getName(s);
		}
		return null;
	}
	
	public static void removePendingSubscriptions(List<Customer> customers)
	{
		for(Customer s: customers)
		{
			Iterator<Customer> iter=customers.iterator();
			while(iter.hasNext())
			if(pendingSubscriptions(customers)==getName(s))
				iter.remove();
		}
	}
	
	public static String getName(Customer x)
	{
		String name=x.getFirstName()+x.getLastName();
		return name;
	}

	
	public static List<Customer> populateCustomer() throws IllegalArgumentException, CustomException
	{
		List<Customer> customers= new ArrayList<>();
		customers.add(validateAll("Soham","Mehta","mehtasoham01@gmail.com","ssss",1000,"2001-09-09","SILVER","2023-09-22",customers));
		customers.add(validateAll("Deep","Suman","deepsuman01@gmail.com","dddd",10000,"2011-09-09","PLATINUM","2022-11-09",customers));
		customers.add(validateAll("Prasad","Singatkar","singatkarp01@gmail.com","pppp",5000,"2001-11-09","DIAMOND","2023-05-24",customers));
		customers.add(validateAll("Krishna","Mahajan","mahajan2001@gmail.com","mmmm",1000,"2015-09-22","SILVER","2023-12-12",customers));
		customers.add(validateAll("Samayaka","Dongre","samypamy99@gmail.com","ssss",2000,"2000-01-09","GOLD","2023-03-05",customers));
		customers.add(validateAll("Suyash","Kolhe","suyashkolhe01@gmail.com","kkkk",10000,"2000-01-09","PLATINUM","2023-12-05",customers));
		customers.add(validateAll("Kaivalya","Joshi","bachhi04@gmail.com","bbbb",10000,"2002-09-04","PLATINUM","2023-12-05",customers));
		customers.add(validateAll("Deep","Mehta","deepmehta20@gmail.com","xxxx",10000,"2003-11-04","PLATINUM","2023-11-11",customers));
		return customers;
	}

}

