package empleado.view;

import java.sql.SQLException;
import java.util.Scanner;

import empleado.entity.Empleado;
import empleado.entity.NoExisteEmpleado;
import view.InputTypes;

public class Men� {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Empleado: ");
			System.out.println("2. Eliminar Empleado: ");
			System.out.println("3. Actualizar Empleado: ");
			System.out.println("4. Listar Empleados: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}
	
	public static void men�(Scanner scanner, Empleados empleados) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					empleados.add();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					try {
						empleados.delete();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (NoExisteEmpleado e1) {
					System.out.println();
					System.out.println("No existe el empleado!");
					System.out.println();
				}
				break;
			case 3:
				try {
					empleados.update();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NoExisteEmpleado e1) {
					System.out.println();
					System.out.println("No existe el empleado!");
					System.out.println();
				}
				break;
			case 4:
				try {
					empleados.list();
				} catch (NoExisteEmpleado e) {
					System.out.println();
					System.out.println("No existen empleados que listar");
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
			System.out.println("3. Modificar tel�fono: ");
			System.out.println("4. Modificar celular: ");
			System.out.println("5. Modificar direcci�n: ");
			System.out.println("6. Modificar cargo: ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}

	public static void men�Modificar(Scanner scanner, Empleado empleado) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				empleado.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 2:
				empleado.setcI(InputTypes.readInt("Ingrese el nuevo CI: ", scanner));
				break;
			case 3:
				empleado.setTel�fono(InputTypes.readInt("Ingrese el nuevo tel�fono: ", scanner));
				break;
			case 4:
				empleado.setCelular(InputTypes.readInt("Ingrese el nuevo celular: ", scanner));
				break;
			case 5:
				empleado.setDirecci�n(InputTypes.readString("Ingrese la nueva direcci�n: ", scanner));
				break;
			case 6:
				empleado.setCargo(InputTypes.readString("Ingrese el nuevo cargo: ", scanner));
				break;
			}
		}
	}
}
