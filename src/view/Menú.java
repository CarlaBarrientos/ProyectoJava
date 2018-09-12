package view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.view.RegistroCompraIngredientes;
import control.Conexión;
import ingrediente.view.RegistroIngredientes;
import view.InputTypes;

public class Menú {

	/****************************
	 * Encabezado del menú *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingrediente");
			System.out.println("2. Compra del Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}


	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
	
		Conexión conexión = new Conexión("root","","fábricachocolates");
		RegistroIngredientes ingredienteView = new RegistroIngredientes(conexión, scanner);
		RegistroCompraIngredientes compraIngredienteView = new RegistroCompraIngredientes(conexión, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					
				ingrediente.view.IngredienteMenú.menú(scanner, ingredienteView);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				compraIngrediente.view.CompraIngredienteMenú.menú(scanner, compraIngredienteView);
				break;
		
			}
		}
		conexión.close();
	}
}
