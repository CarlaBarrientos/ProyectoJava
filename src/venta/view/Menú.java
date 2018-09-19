package venta.view;

import java.sql.SQLException;
import java.util.Scanner;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Menú {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Venta: ");
			System.out.println("2. Actualizar Venta: ");
			System.out.println("3. Listar Ventas: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
	
	public static void menú(Scanner scanner, Ventas ventas){
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					ventas.add();
				} catch (SQLException e2) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				}
				break;
			case 2:
				try {
					ventas.update();
				} catch (SQLException e1) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados no existe");
					System.out.println();
				} catch (NoExisteVenta e1) {
					System.out.println();
					System.out.println("No existe la venta!");
					System.out.println();
				}
				break;
			case 3:
				try {
					ventas.list();
				} catch (NoExisteVenta e) {
					System.out.println();
					System.out.println("No existen ventas que listar");
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
			System.out.println("1. Fecha");
			System.out.println("2. Código del cliente");
			System.out.println("3. Código del empleado");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Venta venta){
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				venta.setFecha(InputTypes.readDate("Ingrese la nueva fecha: ", scanner));
				break;
			case 2:
				venta.setCodCliente(InputTypes.readInt("Ingrese el nuevo código del cliente: ", scanner));
				break;
			case 3:
				venta.setCodEmpleado(InputTypes.readInt("Ingrese el nuevo código del empleado: ", scanner));
				break;
			}
		}
	}
}
