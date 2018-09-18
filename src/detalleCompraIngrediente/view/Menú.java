package detalleCompraIngrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.NoExisteCompraIngrediente;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import ingrediente.entity.NoExisteIngrediente;
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
				} catch (NoExisteCompraIngrediente e1) {
					System.out.println();
					System.out.println("No existe compra de ingrediente!");
					System.out.println();
				} catch (NoExisteIngrediente e1) {
					System.out.println();
					System.out.println("No existen ingredientes!");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					detalleCompraIngredientes.update();
				} catch (NoExisteCompraIngrediente e) {
					System.out.println();
					System.out.println("No existe compra de ingrediente!");
					System.out.println();
				} catch (NoExisteIngrediente e) {
					System.out.println();
					System.out.println("No existe el ingrediente!");
					System.out.println();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public static void menúModificar(Scanner scanner, DetalleCompraIngrediente detalleCompraIngrediente) {
		detalleCompraIngrediente.setCantidad(InputTypes.readInt("Ingrese la nueva cantidad: ", scanner));
		detalleCompraIngrediente.setTotalCompra(InputTypes.readDouble("Ingrese el nuevo total: ", scanner));
	}
}