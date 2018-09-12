package producto.view;

import java.sql.SQLException;
import java.util.Scanner;
import categor�a.entity.NoExisteCategor�a;
import producto.entity.Producto;
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
			System.out.println("1. Ingresar Producto");
			System.out.println("2. Listar Productos ");
			System.out.println("3. Eliminar Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� *
	 ****************************/

	public static void men�(Scanner scanner, Productos productosIO) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					productosIO.add();
				} catch (NoExisteCategor�a e) {
					System.out.println();
					System.out.println("No existe la categor�a!");
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
	 * Encabezado del men� *
	 ****************************/

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("2. Modificar descripci�n");
			System.out.println("3. Modificar precio");
			System.out.println("4. Modificar categor�a");
			System.out.println("5. Modificar ingrediente");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del modificar *
	 ****************************/

	public static void men�Modificar(Scanner scanner, Producto producto) {
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
				producto.setDescripci�n(InputTypes.readString("Ingrese la nueva descripci�n: ", scanner));
				break;
			case 3:
				producto.setPrecio(InputTypes.readDouble("Ingrese el nuevo precio: ", scanner));
				break;
			case 4:
				producto.setCodCategor�a(InputTypes.readInt("Ingrese el nuevo c�digo de categor�a: ", scanner));
				break;
			case 5:
				producto.setCodIngrediente(InputTypes.readInt("Ingrese el nuevo c�digo de ingrediemte: ", scanner));
			}
		}
	}

}

