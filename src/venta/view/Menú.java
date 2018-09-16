package venta.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import empleado.entity.NoExisteEmpleado;
import envio.entity.NoExisteEnv�o;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Men� {
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

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
		public static void men�(Scanner scanner, Ventas ventas){
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
						// TODO Auto-generated catch block
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
					} catch (NoExisteEnv�o e) {
						System.out.println();
						System.out.println("No existe el env�o!");
						System.out.println();
					}
					break;
				case 2:
						ventas.delete();
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
					} catch (NoExisteEnv�o e1) {
						System.out.println();
						System.out.println("No existe el env�o!");
						System.out.println();
					}
					break;
				case 4:
					try {
						ventas.list();
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
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Modificar fecha: ");
				System.out.println("2. Modificar c�digo del env�o: ");
				System.out.println("3. Modificar c�digo del cliente: ");
				System.out.println("4. Modificar c�digo del empleado: ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("�Su opci�n? ", scanner);

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}
			}
		}

		public static void men�Modificar(Scanner scanner, Venta venta)throws NoExisteVenta, NoExisteCliente, NoExisteEnv�o, NoExisteEmpleado{
			boolean salir = false;

			while (!salir) {
				switch (encabezadoModificar(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					venta.setFecha(InputTypes.readDate("Ingrese la fecha a modificar: ", scanner));
					break;
				case 2:
						venta.setCodEnv�o(InputTypes.readInt("Ingrese el nuevo c�digo de env�o: ", scanner));
					break;
				case 3:
						venta.setCodCliente(InputTypes.readInt("Ingrese el nuevo c�digo del cliente: ", scanner));
					break;
				case 4:
						venta.setCodEmpleado(InputTypes.readInt("Ingrese el nuevo c�digo del empleado: ", scanner));
					break;
				}
			}
		}

}
