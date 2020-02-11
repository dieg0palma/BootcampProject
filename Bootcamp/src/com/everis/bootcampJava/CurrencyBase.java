package com.everis.bootcampJava;

public class CurrencyBase {

	public CryptoCurrency getCryptoCurrency(String ccType){
	      
		if(ccType == null){
	         return null;
	      }
		
	      if(ccType.equalsIgnoreCase("BTC")){
	         return new BTC();
	      } 
	      
	      else if(ccType.equalsIgnoreCase("LTC")){
	         return new LTC();
	      }
	         return null;
	         
	      }
	
}
