package com.customer;

public enum serviceplan {
	SILVER (1000), GOLD (2000), DIAMOND (5000),PLATINUM (10000);
	private double serviceCharges;
	
	private serviceplan(double serviceCharges)
	{
		//super(name,ordinal);
		this.serviceCharges=serviceCharges;
	}
	
	@Override
	public String toString()
	{
		return name()+"Serive Charge:"+serviceCharges;
	}

	public double getServiceCharges() {
		return serviceCharges;
	}

	
}
