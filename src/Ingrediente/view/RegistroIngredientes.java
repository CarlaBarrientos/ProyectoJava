package Ingrediente.view;

import java.util.Scanner;


import control.Conexi�n;

public class RegistroIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;
	
	public RegistroIngredientes(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
		
	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingrediente (codIngrediente, descripci�n, costo, numAlmac�n, cantidad) " + "values(?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, ingrediente.getCodIngrediente());
			conexi�n.getSentencia().setString(2, ingrediente.getDescripci�n());
			conexi�n.getSentencia()ingrediente.set
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

}
