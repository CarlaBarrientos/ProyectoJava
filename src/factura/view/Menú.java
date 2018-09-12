package factura.view;

import java.sql.SQLException;
import java.util.Scanner;

import factura.entity.Factura;
import factura.entity.NoExisteFactura;
import view.InputTypes;

public class Men� {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Registrar factura: ");
			System.out.println("2. Eliminar factura: ");
			System.out.println("3. Actualizar factura: ");
			System.out.println("4. Listar facturas: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
		public static void men�(Scanner scanner, Facturas facturas) {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						facturas.add();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					try {
						facturas.delete();
					} catch (NoExisteFactura e1) {
						e1.printStackTrace();
					}
					break;
				case 3:
					try {
						facturas.update();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (NoExisteFactura e1) {
						e1.printStackTrace();
					}
					break;
				case 4:
					try {
						facturas.list();
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
				System.out.println("1. Modificar NIT: ");
				System.out.println("2. Modificar nombre: ");
				System.out.println("3. Modificar descripci�n: ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("�Su opci�n? ", scanner);

				if (opcion >= 0 && opcion <= 3) {
					return opcion;
				}
			}
		}

		public static void men�Modificar(Scanner scanner, Factura factura) {
			boolean salir = false;

			while (!salir) {
				switch (encabezadoModificar(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					factura.setNit(InputTypes.readInt("Ingrese el nuevo NIT: ", scanner));
					break;
				case 2:
					factura.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
					break;
				case 3:
					factura.setDescripci�n(InputTypes.readString("Ingrese la nueva descripci�n: ", scanner));
					break;

				}
			}
		}

}
