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
		public static void menú(Scanner scanner, Ventas ventas) {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						ventas.add();
					} catch (NoExisteCliente e) {
						e.printStackTrace();
					} catch (NoExisteEmpleado e) {
						e.printStackTrace();
					} catch (NoExisteEnvío e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						ventas.delete();
					} catch (NoExisteCliente e) {
						e.printStackTrace();
					} catch (NoExisteEmpleado e) {
						e.printStackTrace();
					} catch (NoExisteEnvío e) {
						e.printStackTrace();
					} catch (NoExisteVenta e) {
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						ventas.update();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (NoExisteVenta e) {
						e.printStackTrace();
					} catch (NoExisteCliente e) {
						e.printStackTrace();
					} catch (NoExisteEmpleado e) {
						e.printStackTrace();
					} catch (NoExisteEnvío e) {
						e.printStackTrace();
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
				System.out.println("2. Modificar código del envío: ");
				System.out.println("3. Modificar código del cliente: ");
				System.out.println("4. Modificar código del empleado: ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("¿Su opción? ", scanner);

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}
			}
		}

		public static void menúModificar(Scanner scanner, Venta venta) {
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
					venta.setCodEnvío(InputTypes.readInt("Ingrese el nuevo código de envío: ", scanner));
					break;
				case 3:
					venta.setCodCliente(InputTypes.readInt("Ingrese el nuevo código del cliente: ", scanner));
					break;
				case 4:
					venta.setCodEmpleado(InputTypes.readInt("Ingrese el nuevo códigp del empleado: ", scanner));
					break;
				}
			}
		}

}
