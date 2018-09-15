package producto.view;

import java.sql.SQLException;
import java.util.Scanner;
import categoría.entity.NoExisteCategoría;
import producto.entity.NoExisteProducto;
import producto.entity.Producto;
import view.InputTypes;

public class Menú {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Producto");
			System.out.println("2. Listar Productos");
			System.out.println("3. Eliminar Producto");
			System.out.println("4. Modificar Producto");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, Productos productos) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					productos.add();
				} catch (NoExisteCategoría e) {
					System.out.println();
					System.out.println("No existe la categoría!");
					System.out.println();
				}
				break;
			case 2:
				try {
					productos.list();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NoExisteProducto e) {
					System.out.println();
					System.out.println("No existen productos");
					System.out.println();
				}
				break;
			case 3:
				productos.delete();
				break;
			case 4:
				try {
					productos.update();
				} catch (NoExisteCategoría e) {
					System.out.println();
					System.out.println("No existe categoría!");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NoExisteProducto e) {
					System.out.println();
					System.out.println("No existe producto!");
					System.out.println();
				}
				break;
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Que desea modificar: ");
			System.out.println("------------------- ");
			System.out.println("1. Nombre");
			System.out.println("2. Descripciòn");
			System.out.println("3. Precio");
			System.out.println("4. Categoría");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

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
			}
		}
		
	}
}