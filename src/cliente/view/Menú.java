package cliente.view;

import java.sql.SQLException;
import java.util.Scanner;

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
						clientes.add();
					break;
				case 2:
						clientes.delete();;
					break;
				case 3:
					try {
						clientes.update();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoExisteCliente e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					break;
				case 4:
					try {
						clientes.list();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				}
			}
		}
	}
