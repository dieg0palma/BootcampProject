package com.everis.bootcampJava;

import java.sql.Date;

public class Empregado {
	
	private String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private Integer ID;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	
	private Date data;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	private double pagamento;
	
	public double getPagamento() {
		return pagamento;
	}
	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}

	private String criptomoeda;
	
	public String getCriptomoeda() {
		return criptomoeda;
	}
	public void setCriptomoeda(String criptomoeda) {
		this.criptomoeda = criptomoeda;
	}

	private double pctCommCM;
	
	public double getPctCommCM() {
		return pctCommCM;
	}
	public void setPctCommCM(double comissao) {
		this.pctCommCM = comissao;
	}
	
	private String iban; 
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	private double comissaoEuro;
	
	public double getComissaoEuro() {
		return comissaoEuro;
	}
	public void setComissaoEuro(double valorComissao) {
		this.comissaoEuro = valorComissao;
	}
	
}