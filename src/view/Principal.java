package view;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Conexion;


public class Principal {

	public static void main(String[] args) {
		
		ResultSet resultSet;
		
		try {
			Conexion conexion= new Conexion("root", "", "fábricachocolates");
			conexion.consulta("SELECT CLIENTE, NOMBRE FROM CLIENTE");
			resultSet=conexion.resultado();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("CLIENTE"));
				System.out.println("\t");
				System.out.println(resultSet.getDouble("PRECIO_UNIDAD"));
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
