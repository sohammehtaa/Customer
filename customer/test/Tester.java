package com.customer.test;

import java.time.LocalDate;
import java.util.Scanner;

import com.customer.Customer;
import com.customer.serviceplan;

public class Tester {
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("---> Welcome to CMS! <---");
			System.out.println("Enter the details:");
			System.out.println("customer id, first name, last name, email, password, registrationAmount, dob, ServicePlan ");
			Customer c=new Customer(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()),serviceplan.valueOf(sc.next().toUpperCase()));
		}
		catch(Exception e)
		{
			System.out.println("eRR!!!");
		}
		
	}
}
