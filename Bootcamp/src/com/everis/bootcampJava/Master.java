package com.everis.bootcampJava;

import java.util.ArrayList;

import com.everis.bootcampJava.DataBaseEmpregado;

public class Master {
	public static void main(String[] args) {
		
		try {
			ArrayList<Empregado> empregados = DataBaseEmpregado.databaseManager();			
			WriterFileCsv.ficheiro(empregados);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}