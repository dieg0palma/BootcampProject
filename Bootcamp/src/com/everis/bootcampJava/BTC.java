package com.everis.bootcampJava;

import java.net.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class BTC implements CryptoCurrency{
	
	@Override
	public double cmoeda() {
		JSONObject amount = null;
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject json = null;
			
			//("data":("base":"BTC", "currency": "EUR", "amount":"7511"))
			
			URL url = new URL("https://api.coinbase.com/v2/prices/BTC-EUR/spot");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new Exception("Failed: HTTP error code : " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader
					(conn.getInputStream()));
			String output;
			
			//System.out.print("Output from API: ");
			
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				json = (JSONObject) parser.parse(output);	
			}
			
			amount =(JSONObject) json.get("data");
			//System.out.println(amount.get("amount"));
			conn.disconnect();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return Double.parseDouble(amount.get("amount").toString());
		
	}

}