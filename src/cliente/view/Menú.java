package cliente.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.entity.NoExisteCliente;
import view.InputTypes;

public class Menú {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Cliente: ");
			System.out.println("2. Eliminar Cliente: ");
			System.out.println("3. Actualizar Cliente: ");
			System.out.println("4. Listar Clientes: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
		public static void menú(Scanner scanner, Clientes clientes) {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						clientes.add();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:

						try {
							try {
								clientes.delete();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}  catch (NoExisteCliente e1) {
							System.out.println();
							System.out.println("No existe el cliente!");
							System.out.println();
					}
					break;
				case 3:
					try {
						clientes.update();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (NoExisteCliente e1) {
						System.out.println();
						System.out.println("No existe el cliente!");
						System.out.println();
					}
					break;
				case 4:

						try {
							clientes.list();
						} catch (NoExisteCliente e) {
							System.out.println();
							System.out.println("No existen clientes que listar");
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
				System.out.println("1. Modificar nombre: ");
				System.out.println("2. Modificar CI: ");
				System.out.println("3. Modificar teléfono: ");
				System.out.println("4. Modificar celular: ");
				System.out.println("5. Modificar dirección: ");
				System.out.println("6. Modificar puntos: ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("¿Su opción? ", scanner);

				if (opcion >= 0 && opcion <= 6) {
					return opcion;
				}
			}
		}

		public static void menúModificar(Scanner scanner, Cliente cliente) {
			boolean salir = false;

			while (!salir) {
				switch (encabezadoModificar(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					cliente.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
					break;
				case 2:
					cliente.setCI(InputTypes.readInt("Ingrese el nuevo CI: ", scanner));
					break;
				case 3:
					cliente.setTeléfono(InputTypes.readInt("Ingrese el nuevo teléfono: ", scanner));
					break;
				case 4:
					cliente.setCelular(InputTypes.readInt("Ingrese el nuevo celular: ", scanner));
					break;
				case 5:
					cliente.setDirección(InputTypes.readString("Ingrese la nueva dirección: ", scanner));
					break;
				case 6:
					cliente.setPuntos(InputTypes.readInt("Ingrese la nueva cantidad de puntos: ", scanner));
					break;
				}
			}
		}
	}
