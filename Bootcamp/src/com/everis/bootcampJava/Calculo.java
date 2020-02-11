package com.everis.bootcampJava;

public class Calculo {
	
	public double calcula(double comissao, double pct, String criptomoeda) {
		CurrencyBase currencyFactory = new CurrencyBase();
		CryptoCurrency moeda = currencyFactory.getCryptoCurrency(criptomoeda);
		double formula = (comissao * pct) / moeda.cmoeda();
		return formula;			
	}
		
	public double comissaoEmEuro(double comissao, double pct) {
		double valorEmEuro = (1-pct)*comissao;
		return valorEmEuro;
	}
		

}