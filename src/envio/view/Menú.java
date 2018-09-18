package envio.view;

import java.sql.SQLException;
import java.util.Scanner;

import envio.entity.Env�o;
import envio.entity.NoExisteEnv�o;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class Men� {
	
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Registrar env�o: ");
			System.out.println("2. Eliminar env�o: ");
			System.out.println("3. Actualizar env�o: ");
			System.out.println("4. Listar env�os: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
		public static void men�(Scanner scanner, Env�os env�os) {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						try {
							env�os.add();
						} catch (NoExisteVenta e) {
							System.out.println();
							System.out.println("No existe la venta!");
							System.out.println();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					try {
							env�os.delete();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					break;
				case 3:
					try {
						try {
							env�os.update();
						} catch (NoExisteVenta e) {
							System.out.println();
							System.out.println("No existe la venta!");
							System.out.println();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (NoExisteEnv�o e1) {
						System.out.println();
						System.out.println("No existe el env�o!");
						System.out.println();
					}
					break;
				case 4:
					try {
						env�os.list();
					} catch (NoExisteEnv�o e) {
						System.out.println();
						System.out.println("No existen env�os que listar");
						System.out.println();
					}

					break;

				}
			}
		}
		public static void men�Modificar(Scanner scanner, Env�o env�o) {
					env�o.setDestinatario(InputTypes.readString("Ingrese el nuevo destinatario: ", scanner));
					env�o.setTel�fono(InputTypes.readInt("Ingrese el nuevo tel�fono: ", scanner));
					env�o.setCostoAdicional(InputTypes.readDouble("Ingrese el nuevo costo adicional: ", scanner));
		}
}
