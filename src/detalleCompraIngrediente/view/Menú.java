package detalleCompraIngrediente.view;

import java.sql.SQLException;
import java.util.Scanner;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import view.InputTypes;

public class Menú {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar detalles de compra ingrediente");
			System.out.println("2. Modificar detalles de compra ingredientes");
			System.out.println("3. Listar detalles de compras de ingredientes");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, DetalleCompraIngredientes detalleCompraIngredientes) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					detalleCompraIngredientes.add();
				} catch (Exception e) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			case 2:
				try {
					detalleCompraIngredientes.update();
				} catch (NoExisteDetalleCompraIngrediente e) {
					System.out.println();
					System.out.println("No existen detalles de compra del ingrediente!");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					detalleCompraIngredientes.list();
				} catch (NoExisteDetalleCompraIngrediente e) {
					System.out.println();
					System.out.println("No existen detalles de compras de ingredientes!");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
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
			System.out.println("1. Código del ingrediente");
			System.out.println("2. código de compra del ingrediente");
			System.out.println("3. Cantidad");
			System.out.println("4. Total de la compra");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, DetalleCompraIngrediente detalleCompraIngrediente) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				detalleCompraIngrediente.setCodIngrediente(InputTypes.readInt("Ingrese el nuevo proveedor: ", scanner));
				break;
			case 2:
				detalleCompraIngrediente.setCodCompraIng(InputTypes.readInt("Ingrese el código del empleado: ", scanner));
				break;
			case 3:
				detalleCompraIngrediente.setCantidad(InputTypes.readInt("Ingrese la nueva cantidad: ", scanner));
				break;
			case 4:
				detalleCompraIngrediente.setTotalCompra(InputTypes.readDouble("Ingrese el nuevo total: ", scanner));
				break;
			}
		}
	}
}