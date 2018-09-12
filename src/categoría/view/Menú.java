package categoría.view;

import java.sql.SQLException;
import java.util.Scanner;

import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;
import view.InputTypes;

public class Menú {

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Categoría");
			System.out.println("2. Listar Categorías ");
			System.out.println("3. Eliminar Categoría ");
			System.out.println("4. Modificar Categoría ");
			System.out.println("5. Productos por Categoría ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú 
	 * @throws SQLException *
	 ****************************/

	public static void menú(Scanner scanner, Categorías categoríasView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categoríasView.add();
				break;
			case 2:
				categoríasView.list();
				break;
			case 3:
				try {
					categoríasView.delete();
				} catch (SQLException e) {
					System.out.println("No existe categoría!");
				}
				break;

			case 4:
				try {
					categoríasView.update();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;

			case 5:
				try {
					categoríasView.listProducts();
				} catch (NoExisteCategoría e) {
					System.out.println("No existe categoría!");
				}
				break;
			}
		}
	}

	/*****
	 * nuevo
	 */

	/****************************
	 * Encabezado del menú *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("2. Modificar descripción ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Categoría categoría) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categoría.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				categoría.setDescripción(InputTypes.readString("Ingrese la nueva descripcíon: ", scanner));
				break;
			}
		}
	}

}
