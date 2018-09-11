package Ingrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import Ingrediente.entity.Ingrediente;
import Ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;


public class IngredienteMen� {
	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Ingrediente");
			System.out.println("2. Listar Ingredientes ");
			System.out.println("3. Eliminar Ingrediente ");
			System.out.println("4. Modificar Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� 
	 * @throws SQLException *
	 ****************************/

	public static void men�(Scanner scanner, RegistroIngredientes ingredienteView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				ingredienteView.add();
				break;
			case 2:
				ingredienteView.list();
				break;
			case 3:
				try {
					ingredienteView.delete();
				} catch (SQLException e) {
					System.out.println("No existe ingrediente");
				}
				break;

			case 4:
				try {
					ingredienteView.update();
				} catch (NoExisteIngrediente e) {
					System.out.println("No existe ingrediente");
				}
				break;

			case 5:
				try {
					ingredienteView.listIngrediente();;
				} catch (NoExisteIngrediente e) {
					System.out.println("No existe ingrediente");
				}
				break;
			}
		}
	}

	/*****
	 * nuevo
	 */

	/****************************
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar ingrediente");
			System.out.println("2. Modificar descripci�n ");
			System.out.println("3. Modificar costo");
			System.out.println("4. Modificar cantidad");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Ingrediente ingrediente) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				ingrediente.setDescripci�n(InputTypes.readString("Ingrese la nueva descripci�n: ", scanner));
				break;
			case 2:
				ingrediente.setCosto(InputTypes.readDouble("Ingrese el nuevo costo:", scanner));
				break;
			case 3:
				ingrediente.setNumAlmac�n(InputTypes.readInt("Ingrese el  nuevo n�mero del almacen:", scanner));
				break;
			case 4:
				ingrediente.setCantidad(InputTypes.readInt("Ingrese el nuevo n�mero de cantidad de ingredinte:", scanner));
				break;
			}
		}
	}

}


