package com.ankit.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.ankit.model.Money;

@WebService(name="MoneyExchange", portName="MoneyExchangePort", serviceName="MoneyExchangeService")
public interface MoneyExchangeInterface {
	
	@WebMethod
	@WebResult(name="ExchangedAmount")
	public abstract double exchangeMoney(@WebParam(name="FromCurrency") String fromCurrStr, @WebParam(name="Amount")double amt,
			@WebParam(name="ToCurrency")String toCurrStr);
	
//	@WebMethod
//	@WebResult(name="ExchangedAmount")
//	public abstract Money exchangeMoneyV2(@WebParam(name="FromCurrency") String fromCurrStr, @WebParam(name="Amount")double amt,
//			@WebParam(name="ToCurrency")String toCurrStr);
	
	@WebMethod
	public abstract Money exchangeMoneyV2(String fromCurrStr, double amt,
			String toCurrStr);
	
}