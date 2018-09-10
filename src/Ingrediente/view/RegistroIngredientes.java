package Ingrediente.view;

import java.util.Scanner;


import control.Conexión;

public class RegistroIngredientes {
	private Conexión conexión;
	private Scanner scanner;
	
	public RegistroIngredientes(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
		
	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingrediente (codIngrediente, descripción, costo, numAlmacén, cantidad) " + "values(?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, ingrediente.getCodIngrediente());
			conexión.getSentencia().setString(2, ingrediente.getDescripción());
			conexión.getSentencia()ingrediente.set
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

}
