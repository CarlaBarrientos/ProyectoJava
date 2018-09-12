package compraIngrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import ingrediente.view.RegistroIngredientes;
import view.InputTypes;

public class CompraIngredienteMenú {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar  compra de Ingrediente");
			System.out.println("2. Listar la compra de Ingredientes ");
			System.out.println("3. Eliminar compra de Ingrediente ");
			System.out.println("4. Modificar la comprs de Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}

	

	public static void menú(Scanner scanner, RegistroCompraIngredientes compraIngredienteView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				compraIngredienteView.add();
				break;
			case 2:
				compraIngredienteView.list();
				break;
			case 3:
				try {
					compraIngredienteView.delete();
				} catch (SQLException e) {
					System.out.println("No existe ingrediente");
				}
				break;

			case 4:
				try {
					compraIngredienteView.update();
				} catch (NoExisteCompraIngrediente e) {
					System.out.println("No existe compra de ingrediente");
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
			System.out.println("1. Modificar compra de ingrediente");
			System.out.println("2. Modificar nombre ");
			System.out.println("3. Modificar cantidad");
			System.out.println("4. Modificar factura");
			System.out.println("5. Modificar proveedor");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
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
				compraIngrediente.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				compraIngrediente.setCantidad(InputTypes.readInt("Ingrese la nueva cantidad:", scanner));
				break;
			case 3:
				compraIngrediente.setFactura(InputTypes.readInt("Ingrese el  nuevo número de factura:", scanner));
				break;
			case 4:
				compraIngrediente.setProveedor(InputTypes.readString("Ingrese el nuevo proveedor:", scanner));
				break;
			}
		}
	}
}
