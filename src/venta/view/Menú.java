package venta.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import empleado.entity.NoExisteEmpleado;
import envio.entity.NoExisteEnvío;
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
			System.out.println("2. Eliminar Venta: ");
			System.out.println("3. Actualizar Venta: ");
			System.out.println("4. Listar Ventas: ");
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
					try {
						ventas.add();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (NoExisteCliente e) {
					System.out.println();
					System.out.println("No existe el cliente!");
					System.out.println();
				} catch (NoExisteEmpleado e) {
					System.out.println();
					System.out.println("No existe el empleado!");
					System.out.println();
				} catch (NoExisteEnvío e) {
					System.out.println();
					System.out.println("No existe el envío!");
					System.out.println();
				}
				break;
			case 2:

				try {
					ventas.delete();
				} catch (NoExisteVenta e2) {
					System.out.println();
					System.out.println("No existe la venta!");
					System.out.println();
				} catch (SQLException e2) {
					e2.printStackTrace();
					System.out.println("defwe");
				}

				break;
			case 3:

				try {
					ventas.update();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NoExisteVenta e1) {
					System.out.println();
					System.out.println("No existe la venta!");
					System.out.println();
				} catch (NoExisteCliente e1) {
					System.out.println();
					System.out.println("No existe el cliente!");
					System.out.println();
				} catch (NoExisteEmpleado e1) {
					System.out.println();
					System.out.println("No existe el empleado!");
					System.out.println();
				} catch (NoExisteEnvío e1) {
					System.out.println();
					System.out.println("No existe el envío!");
					System.out.println();
				}
				break;
			case 4:
				try {
					ventas.list();
				} catch (NoExisteVenta e) {
					System.out.println();
					System.out.println("No existen ventas que listar");
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
			System.out.println("1. Modificar fecha: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Venta venta)throws NoExisteVenta, NoExisteCliente, NoExisteEnvío, NoExisteEmpleado{
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				venta.setFecha(InputTypes.readDate("Ingrese la fecha a modificar: ", scanner));
				break;
			}
		}
	}
}
