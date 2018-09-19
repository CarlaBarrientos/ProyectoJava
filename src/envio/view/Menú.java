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
					envíos.add();
				} catch (NoExisteVenta e) {
					System.out.println();
					System.out.println("No existe la venta!");
					System.out.println();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					envíos.delete();
				} catch (NoExisteEnvío e) {
					System.out.println();
					System.out.println("No existe el envío");
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					envíos.update();
				} catch (SQLException e1) {
					System.out.println();
					System.out.println("Alguno de los datos ingresados es incorrecto");
					System.out.println();
				} catch (NoExisteEnvío e) {
					System.out.println();
					System.out.println("No existe el envío");
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
			System.out.println("1. Destinatario");
			System.out.println("2. Teléfono");
			System.out.println("3. Costo adicional");
			System.out.println("4. Número de Venta");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Envío envío) {

		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				envío.setDestinatario(InputTypes.readString("Ingrese el nuevo destinatario: ", scanner));
				break;
			case 2:
				envío.setTeléfono(InputTypes.readInt("Ingrese el nuevo teléfono: ", scanner));
				break;
			case 3:
				envío.setCostoAdicional(InputTypes.readDouble("Ingrese el nuevo costo adicional: ", scanner));
				break;
			case 4:
				envío.setNumVenta(InputTypes.readInt("Ingrese el nuevo número de venta: ", scanner));
				break;
			}
		}
	}
}
