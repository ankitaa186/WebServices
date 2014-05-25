package com.ankit.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.ankit.model.Money;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

@WebService(endpointInterface="com.ankit.ws.MoneyExchangeInterface")
public class MoneyExchange implements MoneyExchangeInterface {
	
	/* (non-Javadoc)
	 * @see com.ankit.ws.MoneyExchangeInterface#exchangeMoney(java.lang.String, double, java.lang.String)
	 */
	@Override
	public double exchangeMoney(String fromCurrStr, double amt, String toCurrStr){
		Currency fromCurr = Currency.valueOf(fromCurrStr);
		Currency toCurr = Currency.valueOf(toCurrStr);
		//Get rate
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertor.getCurrencyConvertorSoap();
		double rate = convertorSoap.conversionRate(fromCurr, toCurr);
		System.out.println(toCurrStr + rate*amt);
		return rate*amt;
		
	}
	 
	@Override
	public Money exchangeMoneyV2(String fromCurrStr, double amt, String toCurrStr){
		Currency fromCurr = Currency.valueOf(fromCurrStr);
		Currency toCurr = Currency.valueOf(toCurrStr);
		//Get rate
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertor.getCurrencyConvertorSoap();
		double rate = convertorSoap.conversionRate(fromCurr, toCurr);
		System.out.println(toCurrStr + rate*amt);
		return new Money(rate*amt,toCurrStr);
		
	}

}
