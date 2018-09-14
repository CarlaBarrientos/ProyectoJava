package detalleVenta.view;

import java.sql.SQLException;
import java.util.Scanner;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import view.InputTypes;

public class Menú {
	private static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Detalle de Venta");
			System.out.println("2. Eliminar Detalle de Venta ");
			System.out.println("3. Modificar Detalle de Venta ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, DetalleVentas detalleVentasView) throws SQLException {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				detalleVentasView.add();
				break;
			case 2:
				try {
					detalleVentasView.delete();
				} catch (SQLException e) {
					System.out.println("No existe detalle de venta!");
				}
				break;

			case 3:
				try {
					detalleVentasView.update();
				} catch (NoExisteDetalleVenta e) {
					System.out.println("No existe detalle de venta!");
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
			System.out.println("1. Modificar número de venta");
			System.out.println("2. Modificar codigo de producto");
			System.out.println("3. Modificar cantidad");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, DetalleVenta detalleVenta) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				detalleVenta.setCodProducto(InputTypes.readInt("Ingrese el nuevo código del producto: ", scanner));
				break;
			case 2:
				detalleVenta.setCantidad(InputTypes.readInt("Ingrese la nueva cantidad: ", scanner));
				break;
			}
		}
	}
}