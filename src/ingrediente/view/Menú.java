package ingrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;


public class Menú {


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

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}



	public static void menú(Scanner scanner, Ingredientes ingredientes) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				ingredientes.add();
				break;
			case 2:
		
				try {
					ingredientes.list();
				} catch (NoExisteIngrediente e1) {
					System.out.println();
					System.out.println("No existen ingredientes!");
					System.out.println();
				}
				break;
			case 3:
				try {
					ingredientes.delete();
				} catch (NoExisteIngrediente e) {
					System.out.println();
					System.out.println("No existe ingrediente!");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();	
				}
				break;
			case 4:
				try {
					ingredientes.update();
				} catch (NoExisteIngrediente e) {
					System.out.println("No existe ingrediente");
				}
				break;

			}
		}
	}



	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar descripción: ");
			System.out.println("2. Modificar costo: ");
			System.out.println("3. Modificar número de almacén: ");
			System.out.println("4. Modificar cantidad: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}



	public static void menúModificar(Scanner scanner, Ingrediente ingrediente) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				ingrediente.setDescripción(InputTypes.readString("Ingrese la nueva descripción: ", scanner));
				break;
			case 2:
				ingrediente.setCosto(InputTypes.readDouble("Ingrese el nuevo costo:", scanner));
				break;
			case 3:
				ingrediente.setNumAlmacén(InputTypes.readInt("Ingrese el  nuevo número del almacen:", scanner));
				break;
			case 4:
				ingrediente.setCantidad(InputTypes.readInt("Ingrese el nuevo número de cantidad de ingredinte:", scanner));
				break;
			}
		}
	}

}