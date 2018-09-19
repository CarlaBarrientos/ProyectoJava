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
			System.out.println("4. Listar Detalles de Ventas");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, DetalleVentas detalleVentasView) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					detalleVentasView.add();
				} catch (SQLException e1) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			case 2:
				try {
					detalleVentasView.delete();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NoExisteDetalleVenta e) {
					System.out.println();
					System.out.println("No existe detalle de venta!");
					System.out.println();
				}
				break;
			case 3:
				try {
					detalleVentasView.update();
				} catch (NoExisteDetalleVenta e1) {
					System.out.println();
					System.out.println("No existe el detalle de venta");
					System.out.println();
					e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			case 4:
				try {
					detalleVentasView.list();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NoExisteDetalleVenta e) {
					System.out.println();
					System.out.println("No existen detalles de ventas");
					System.out.println();
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
			System.out.println("1. Modificar codigo de producto");
			System.out.println("2. Modificar cantidad");
			System.out.println("3. Modificar precio total de la venta");
			System.out.println("4. Modificar número de venta");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
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
			case 3:
				detalleVenta.setTotalVenta(InputTypes.readDouble("Ingrese el nuevo precio total: ", scanner));
				break;
			case 4:
				detalleVenta.setNumVenta(InputTypes.readInt("Ingrese el nuevo número de venta: ", scanner));
				break;
			}
		}
	}
}