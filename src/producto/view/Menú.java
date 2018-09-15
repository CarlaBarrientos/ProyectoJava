package producto.view;

import java.sql.SQLException;
import java.util.Scanner;
import categor�a.entity.NoExisteCategor�a;
import producto.entity.NoExisteProducto;
import producto.entity.Producto;
import view.InputTypes;

public class Men� {

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

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void men�(Scanner scanner, Productos productos) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					productos.add();
				} catch (NoExisteCategor�a e) {
					System.out.println();
					System.out.println("No existe la categor�a!");
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
				} catch (NoExisteCategor�a e) {
					System.out.println();
					System.out.println("No existe categor�a!");
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
			System.out.println("2. Descripci�n");
			System.out.println("3. Precio");
			System.out.println("4. Categor�a");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

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
			}
		}
		
	}
}