package com.customer.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.customer.CustomException;
import com.customer.Customer;
import com.customer.serviceplan;
import com.customer.validation.ValidateCustomer;
import com.customer.utils.CustomerUtils;

public class Tester {
	
	public static void main(String[] args) {
		
//		List<Customer> customers= new ArrayList<>();
		
		try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("---> Welcome to CMS! <---");
//			System.out.println("Enter the details:");
//			System.out.println("first name, last name, email, password, registrationAmount, dob, ServicePlan ");
//			Customer c=new Customer(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()),serviceplan.valueOf(sc.next().toUpperCase()));

			List<Customer> customers= new ArrayList<>();
			boolean exit=false;
			while(!exit)
			{
				System.out.println("1.Sign Up \n2.Sign in \n3.Change Password \n.4.Unsuscribe customer \n5.Display all customers");
				System.out.println("Enter choice:");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Sign Up");
					System.out.println("Enter details");
					System.out.println("first name, last name, email, password, registrationAmount, dob, ServicePlan ");
//					ValidateCustomer.validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next());
					customers.add(ValidateCustomer.validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next()));
					break;
				case 2:
					System.out.println("Sign in");
					System.out.println("Enter email and password");
					if(CustomerUtils.validateMailPassword(sc.next(),sc.next())==null);
						System.out.println("Sign in Successful !");
					break;
				case 3:
					System.out.println("Change Password");
					//validation function copy and set new pass using setter
//					CustomerUtils.validateMailPassword(sc.next(),sc.next());
						for (Customer c: customers)
						{
							if(c.equals(CustomerUtils.validateMailPassword(sc.next(),sc.next())))
							c.setPassword(sc.next());
						}
					break;
				case 4:
					System.out.println("Unsuscribe customer");
					System.out.println("Enter email and password");
					//after validation
					for (Customer c: customers)
					{
						if(c.getEmail()==sc.next())
						{
							customers.remove(c);
							System.out.println("Customer Deleted");
						}
					}
					break;
				case 5:
					System.out.println("Display all customers");
					for(Customer c: customers)
						System.out.println(c);
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("eRR!!!");
		}
		
	}
}
