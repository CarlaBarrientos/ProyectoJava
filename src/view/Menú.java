package view;

import java.sql.SQLException;
import java.util.Scanner;


import control.Conexión;
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
			System.out.println("1. Categoría");
			System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú 
	 * @throws SQLException 
	 * @throws ClassNotFoundException *
	 ****************************/

	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexión conexión = new Conexión("root","","Tienda");
		CategoríasIO categoríasIO = new CategoríasIO(conexión, scanner);
		ProductosIO productosIO = new ProductosIO(conexión, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					categoría.view.Menú.menú(scanner, categoríasIO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				producto.view.Menú.menú(scanner, productosIO);
				break;
		
			}
		}
		conexión.close();
	}
}
