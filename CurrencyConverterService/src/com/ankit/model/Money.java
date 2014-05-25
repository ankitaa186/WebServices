package com.ankit.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Money")
@XmlType(propOrder={"currencyType", "amount"})
public class Money {
	
	private double amount;
	private String currencyType;
	
	public Money(){
		
	}
	
	public Money(double amount, String currType){
		this.amount = amount;
		this.currencyType = currType;
		
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	

}
