package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Facilitador facilitador = new Facilitador();

		System.out.print("Apartamento com consumo em m³: ");
		Double consumoTotal = sc.nextDouble();
		
		facilitador.distribuicao10(consumoTotal);
		facilitador.distribuicao20(consumoTotal);
		facilitador.distribuicao30(consumoTotal);
		facilitador.distribuicao50(consumoTotal);
		facilitador.distribuicao51(consumoTotal);
	
		
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from faixaconsumo");
			List<Double> list = new ArrayList<>();
			Double somaTotal = 0.0;
			
			while (rs.next()) {
				System.out.println("Faixa de consumo = " + rs.getString("FaixaDeConsumo") 
									+ ", Tarifa = " + String.format("%.2f", rs.getDouble("Tarifa")) 
									+ ", Distribuição = " + rs.getDouble("Distribuicao") 
									+ ", SubTotal = " + String.format("%.2f", rs.getDouble("SubTotal")));
			list.add(rs.getDouble("SubTotal"));
			}
			
			for (Double sTot : list) {
				somaTotal = somaTotal + sTot;
			}
			
			System.out.println("Soma total = " + String.format("%.2f", somaTotal));
			System.out.println("Soma + esgoto = " + String.format("%.2f", 2 * somaTotal));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		sc.close();	
	}
}
