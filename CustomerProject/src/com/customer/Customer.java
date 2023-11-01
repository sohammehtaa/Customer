package com.customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{

	private static int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private serviceplan plan;
	private LocalDate lastSubscriptionPaidDate;
	
	static {
		customerId=1001;
	}
	
	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob, serviceplan plan, LocalDate lastSubscriptionPaidDate) {
		super();
		customerId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
	}
	
	public Customer(String email)
	{
		this.email = email;
	}



	@Override
	public String toString() {
		return "Customer [customerId "+customerId +"firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan
				+ ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
	}

	@Override
	public boolean equals (Object o)
	{
		System.out.println("--> Equals method <---");
		if(o instanceof Customer)
			return this.email.equals(((Customer)o).email);
		return false;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(Customer c) {
			return this.email.compareTo(c.email);
	}
	
	
}
