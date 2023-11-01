package com.customer.test;

import static com.customer.utils.CustomerUtils.*;
import static com.customer.validation.ValidateCustomer.validateAll;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.customer.CustomException;
import com.customer.Customer;
import com.customer.utils.*;


public class Tester {
	
	public static void main(String[] args) throws RuntimeException, CustomException {
		
		List<Customer> customers=populateCustomer(); //		List<Customer> customers= new ArrayList<>();
		
		try(Scanner sc= new Scanner(System.in)){
			
			System.out.println("---> Welcome to CMS! <---");
			try {
			boolean exit=false;
			while(!exit)
			{
				System.out.println("1.Sign Up \n2.Sign in \n3.Change Password \n.4.Unsuscribe customer \n5.Display all customers \n6Sort by email \n7.Sort by DOB \n8.Sort by DOB and last name \n9.Pending Subscription \n10.Remove Pending Subscriptions");
				System.out.println("Enter choice:");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Sign Up");
					System.out.println("Enter details");
					System.out.println("first name, last name, email, password, registrationAmount, dob, ServicePlan, lastSubscriptionPaidDate");
					customers.add(validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), sc.next(),customers));
					System.out.println("SignUp Successful!");
					break;
					
				case 2:
					System.out.println("Sign in");
					System.out.println("Enter email and password");
					validateMailPassword(sc.next(), sc.next(), customers);
					System.out.println("Signed In Successfully");
					break;
					
				case 3:
					System.out.println("Change Password");
					System.out.println("Enter your email and password");
					Customer x=validateMailPassword(sc.next(), sc.next(), customers);
					System.out.println("Enter new password");
					x.setPassword(sc.next());
					break;
					
				case 4:
					System.out.println("Unsuscribe customer");
					System.out.println("Enter email and password");
					boolean removed = customers.remove(validateMailPassword(sc.next(), sc.next(), customers));
					if(removed)
						System.out.println("Unsuscribed");
					break;
					
				case 5:
					System.out.println("Display all customers");
					printList(customers);
					break;
				
				case 6: 
					System.out.println("Sorting by email");
					Collections.sort(customers);
					printList(customers);
				   break;
				
				case 7:
					System.out.println("Sorting by date of Birth");
					Collections.sort(customers, new dateComparator());
					System.out.println("Sorted list");
					printList(customers);
					break;
					
				case 8:
					System.out.println("Sorting by date of Birth and last name");
					Collections.sort(customers, new dateNnameComparator());
					System.out.println("Sorted list");
					printList(customers);
					break;
					
				case 9:
					System.out.println("Pending Subscriptions");
					System.out.println("List of customers with due subscriptions");
					pendingSubscriptions(customers);
					printList(customers);
					break;
					
				case 10:
					System.out.println("Remove Pending Subscriptions");
					removePendingSubscriptions(customers);
				default:
					System.out.println("default case");
					break;
				}
				System.out.println("Out of Switch !");
			}
			System.out.println("Out of while !");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("eRR!!!");
		}
		}
	}
}
