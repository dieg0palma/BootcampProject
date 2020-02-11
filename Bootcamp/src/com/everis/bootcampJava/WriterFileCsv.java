package com.everis.bootcampJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriterFileCsv {
	
public static void ficheiro(ArrayList<Empregado> empregados) {
		
	try (PrintWriter writer = new PrintWriter(new File("pagamentos.csv"))) {		
			double valorComissaoCM, valorComissaoEuro;
			Calculo calculo = new Calculo();
			StringBuilder sb = new StringBuilder();
			
			sb.append("Id");
			sb.append(",");
			sb.append("Name");
			sb.append(",");
			sb.append("Pagamento total em euro");
			sb.append(",");
			sb.append("Porcentagem da Comissao");
			sb.append(",");
			sb.append("Criptomoeda escolhida");
			sb.append(",");
			sb.append("Data do Pagamento");
			sb.append(",");
			sb.append("IBAN");
			sb.append(",");
			sb.append("Valor total da comissao em euro");
			sb.append(",");
			sb.append("Valor a receber em criptomoeda");
			sb.append(",");
			sb.append("Valor a receber em euro");
			sb.append("\n");
			
			for (int i = 0; i < empregados.size(); i++ ) {
				
				sb.append(empregados.get(i).getID());
				sb.append(",");
				sb.append(empregados.get(i).getNome());
				sb.append(",");
				sb.append(empregados.get(i).getPagamento());
				sb.append(",");
				sb.append(empregados.get(i).getPctCommCM());
				sb.append(",");
				sb.append(empregados.get(i).getCriptomoeda());
				sb.append(",");
				sb.append(empregados.get(i).getData());
				sb.append(",");
				sb.append(empregados.get(i).getIban());
				sb.append(",");
				sb.append(empregados.get(i).getComissaoEuro());
				sb.append(",");
				if(empregados.get(i).getCriptomoeda() != null) {
					valorComissaoCM = calculo.calcula(empregados.get(i).getComissaoEuro(), empregados.get(i).getPctCommCM(), empregados.get(i).getCriptomoeda());
					sb.append(valorComissaoCM + " " + empregados.get(i).getCriptomoeda());
				} else {
					sb.append("0");
				}
				sb.append(",");
				if(empregados.get(i).getCriptomoeda() != null) {
					valorComissaoEuro = calculo.comissaoEmEuro(empregados.get(i).getComissaoEuro(), empregados.get(i).getPctCommCM());
					sb.append(valorComissaoEuro);
				} else {
					sb.append("0");
				}
				
				sb.append("\n");
			
			}
			
			writer.write(sb.toString());
			
			System.out.println("Done!");
			
		} catch (FileNotFoundException s) {
			System.out.println(s.getMessage());
		}
	
	}
	
}