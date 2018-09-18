package envio.view;

import java.sql.SQLException;
import java.util.Scanner;

import envio.entity.Envío;
import envio.entity.NoExisteEnvío;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class Menú {
	
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Registrar envío: ");
			System.out.println("2. Eliminar envío: ");
			System.out.println("3. Actualizar envío: ");
			System.out.println("4. Listar envíos: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
		public static void menú(Scanner scanner, Envíos envíos) {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						try {
							envíos.add();
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
							envíos.delete();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					break;
				case 3:
					try {
						try {
							envíos.update();
						} catch (NoExisteVenta e) {
							System.out.println();
							System.out.println("No existe la venta!");
							System.out.println();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (NoExisteEnvío e1) {
						System.out.println();
						System.out.println("No existe el envío!");
						System.out.println();
					}
					break;
				case 4:
					try {
						envíos.list();
					} catch (NoExisteEnvío e) {
						System.out.println();
						System.out.println("No existen envíos que listar");
						System.out.println();
					}

					break;

				}
			}
		}
		public static void menúModificar(Scanner scanner, Envío envío) {
					envío.setDestinatario(InputTypes.readString("Ingrese el nuevo destinatario: ", scanner));
					envío.setTeléfono(InputTypes.readInt("Ingrese el nuevo teléfono: ", scanner));
					envío.setCostoAdicional(InputTypes.readDouble("Ingrese el nuevo costo adicional: ", scanner));
		}
}
