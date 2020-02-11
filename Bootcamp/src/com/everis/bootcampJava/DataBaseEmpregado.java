package com.everis.bootcampJava;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseEmpregado {


	public static ArrayList<Empregado> databaseManager () throws SQLException {
			
		Empregado emp = new Empregado();
		ArrayList<Empregado> lista = new ArrayList<Empregado>();
		
		Connection conn = DriverManager.getConnection(
			 "jdbc:mysql://localhost/hr?useTimezone=true&serverTimezone=UTC",
			 "root",
			 "admin" );
		
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery( "select e.employee_id, concat(first_name,\" \",last_name) as \"name\", salary + coalesce (commission_pct*salary,0) as \"valor_a_pagar\", e.CM_pct, e.CM, bk.payday, bk.iban, coalesce (commission_pct*salary,0) as \"valor_comissao\" \r\n" + 
													"from employees e, bankdetails bk\r\n" + 
													"where e.employee_id = bk.employee_id;" );
			    try {
			    	while ( rs.next() ) {
			        	
			    		int numColumns = rs.getMetaData().getColumnCount();
			            emp = new Empregado();
			            for ( int i = 1 ; i <= numColumns ; i++ ) {
	
			            	if (i == 1) {
			            		emp.setID(Integer.parseInt(rs.getObject(i).toString()));
				        	} else if (i == 2) {
				        		emp.setNome((String) rs.getObject(i));
				        	} else if (i == 3) {
				        		emp.setPagamento(Double.parseDouble(rs.getObject(i).toString()));
				        	} else if (i == 4) {
				        		if (rs.getObject(i) != null) {
				        			emp.setPctCommCM(Double.parseDouble(rs.getObject(i).toString()));
				        		}
				        	} else if (i == 5) {
				        		if (rs.getObject(i) != null) {
				        			emp.setCriptomoeda((String) rs.getObject(i));
				        		}
				        	} else if (i == 6) {
				        		emp.setData((Date) (rs.getObject(i)));
				        	} else if (i == 7) {
				        		emp.setIban((String) rs.getObject(i));
				        	}else if(i == 8) {
				        		if (rs.getObject(i) != null) {
				        			emp.setComissaoEuro(Double.parseDouble(rs.getObject(i).toString()));
				        		}
				        		
				        	}
				            
			            }
			            
			            lista.add(emp);
			            
			        }
			    } finally {
			        try { rs.close(); } catch (Throwable ignore) { }
			    }
			} finally {
			    try { stmt.close(); } catch (Throwable ignore) { }
			}
		} finally {
	
			try { conn.close(); } catch (Throwable ignore) { }
		}
		
		return lista;
			
	}

}