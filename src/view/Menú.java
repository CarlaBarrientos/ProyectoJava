package view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.view.RegistroCompraIngredientes;
import control.Conexi�n;
import ingrediente.view.RegistroIngredientes;
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
			System.out.println("2. Compra del Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}


	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
	
		Conexi�n conexi�n = new Conexi�n("root","","f�bricachocolates");
		RegistroIngredientes ingredienteView = new RegistroIngredientes(conexi�n, scanner);
		RegistroCompraIngredientes compraIngredienteView = new RegistroCompraIngredientes(conexi�n, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					
				ingrediente.view.IngredienteMen�.men�(scanner, ingredienteView);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				compraIngrediente.view.CompraIngredienteMen�.men�(scanner, compraIngredienteView);
				break;
		
			}
		}
		conexi�n.close();
	}
}
