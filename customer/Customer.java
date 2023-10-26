package com.customer;

import java.time.LocalDate;

public class Customer {

	private static int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Double regAmount;
	private LocalDate dob;
	private serviceplan plan;
	
	static {
		customerId=1001;
	}
	
	public Customer(String firstName, String lastName, String email, String password, Double regAmount, LocalDate dob, serviceplan plan) {
		super();
		customerId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", regAmount="
				+ regAmount + ", plan=" + plan + "]";
	}
	
	@Override
	public boolean equals (Object o)
	{
		System.out.println("--> Equals method <---");
		Customer c= (Customer)o;
		if(o instanceof Customer)
			return this.email.equals(c.email);
		return false;
	}
	
	
}
