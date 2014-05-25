package com.ankit.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

@Path("/v1/exchange")
public class MoneyExchange {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response exchangeMoney(@QueryParam("fromCurr") String fromCurrStr, @QueryParam("amt")double amt, @QueryParam("toCurr")String toCurrStr){
		if(fromCurrStr == null){
			return Response.status(404).build();
		}
		Currency fromCurr = Currency.valueOf(fromCurrStr);
		Currency toCurr = Currency.valueOf(toCurrStr);
		//Get rate
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertor.getCurrencyConvertorSoap();
		double rate = convertorSoap.conversionRate(fromCurr, toCurr);
		System.out.println(toCurrStr + rate*amt);
		return Response.ok(""+rate*amt).build();
	//	return "HELLO WORLD";
		
	}
	
	@GET
	@Path("/{frm}/{amt}/{to}")
	@Produces(MediaType.TEXT_HTML)
	public Response exchangeMoneyPath(@PathParam("frm") String fromCurrStr, @PathParam("amt")double amt, @PathParam("to")String toCurrStr){
		if(fromCurrStr == null){
			return Response.status(404).build();
		}
		Currency fromCurr = Currency.valueOf(fromCurrStr);
		Currency toCurr = Currency.valueOf(toCurrStr);
		//Get rate
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		CurrencyConvertorSoap convertorSoap = currencyConvertor.getCurrencyConvertorSoap();
		double rate = convertorSoap.conversionRate(fromCurr, toCurr);
		System.out.println(toCurrStr + rate*amt);
		return Response.ok(""+rate*amt).build();
	//	return "HELLO WORLD";
		
	}
	
	@GET
	@Path("/version")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVersion(){
//		Currency fromCurr = Currency.valueOf(fromCurrStr);
//		Currency toCurr = Currency.valueOf(toCurrStr);
//		//Get rate
//		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
//		CurrencyConvertorSoap convertorSoap = currencyConvertor.getCurrencyConvertorSoap();
//		double rate = convertorSoap.conversionRate(fromCurr, toCurr);
//		System.out.println(toCurrStr + rate*amt);
//		return rate*amt;
		return "{\"Version\": \"1.0\"}";
		
	}

}
