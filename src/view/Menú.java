package view;

import java.sql.SQLException;
import java.util.Scanner;

import Ingrediente.entity.Ingrediente;
import Ingrediente.view.RegistroIngredientes;
import Ingrediente.view.IngredienteMen�;
import control.Conexi�n;

import view.InputTypes;

public class Men� {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingrediente");
			System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException 
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexi�n conexi�n = new Conexi�n("root","","Tienda");
		RegistroIngredientes IngredienteView = new RegistroIngredientes(conexi�n, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				
			case 2:
			
			}
		}
		conexi�n.close();
	}
}


