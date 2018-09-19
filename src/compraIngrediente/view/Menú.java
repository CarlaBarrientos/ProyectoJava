package compraIngrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import view.InputTypes;

public class Menú {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar  compra de Ingrediente");
			System.out.println("2. Listar la compra de Ingredientes ");
			System.out.println("3. Modificar la compra de Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, CompraIngredientes compraIngredientes) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					compraIngredientes.add();
				} catch (SQLException e2) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			case 2:
				try {
					compraIngredientes.list();
				} catch (NoExisteCompraIngrediente e1) {
					System.out.println();
					System.out.println("No existe  compra ingrediente");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					compraIngredientes.update();
				} catch (NoExisteCompraIngrediente e) {
					System.out.println();
					System.out.println("No existe compra de ingrediente");
					System.out.println();
				} catch (SQLException e) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("¿Que desea modificar?");
			System.out.println("------------------- ");
			System.out.println("1. Proveedor");
			System.out.println("2. Código del empleado");
			System.out.println("3. Nombre");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, CompraIngrediente compraIngrediente) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				compraIngrediente.setProveedor(InputTypes.readString("Ingrese el nuevo proveedor: ", scanner));
				break;
			case 2:
				compraIngrediente.setCodEmpleado(InputTypes.readInt("Ingrese el código del empleado: ", scanner));
				break;
			case 3:
				compraIngrediente.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			}
		}
	}
}
