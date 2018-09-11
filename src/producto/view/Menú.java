package producto.view;

import java.sql.SQLException;
import java.util.Scanner;
import categoría.entity.NoExisteCategoría;
import producto.entity.Producto;
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
			System.out.println("1. Ingresar Producto");
			System.out.println("2. Listar Productos ");
			System.out.println("3. Eliminar Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del menú *
	 ****************************/

	public static void menú(Scanner scanner, Productos productosIO) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					productosIO.add();
				} catch (NoExisteCategoría e) {
					System.out.println();
					System.out.println("No existe la categoría!");
					System.out.println();
				}
				break;
			case 2:
				try {
					productosIO.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				productosIO.delete();
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
			System.out.println("2. Modificar descripciòn");
			System.out.println("3. Modificar precio");
			System.out.println("4. Modificar categoría");
			System.out.println("5. Modificar ingrediente");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void menúModificar(Scanner scanner, Producto producto) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				producto.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				producto.setDescripción(InputTypes.readString("Ingrese la nueva descripción: ", scanner));
				break;
			case 3:
				producto.setPrecio(InputTypes.readDouble("Ingrese el nuevo precio: ", scanner));
				break;
			case 4:
				producto.setCodCategoría(InputTypes.readInt("Ingrese el nuevo código de categoría: ", scanner));
				break;
			case 5:
				producto.setCodIngrediente(InputTypes.readInt("Ingrese el nuevo código de ingrediemte: ", scanner));
			}
		}
	}

}

