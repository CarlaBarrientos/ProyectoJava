package detalleCompraIngrediente.view;

import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.NoExisteCompraIngrediente;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;

public class Menú {
		private static int encabezado(Scanner scanner) {
			int opcion;

			while (true) {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Ingresar Detalle de Compra Ingrediente");
				System.out.println("2. Eliminar Detalle de Compra Ingrediente ");
				System.out.println("3. Modificar Detalle de Compra Ingrediente ");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("¿Su opción? ", scanner);

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}
			}
		}

		public static void menú(Scanner scanner, DetalleCompraIngredientes detalleCompraIngredientes) throws SQLException {
			boolean salir = false;

			while (!salir) {
				switch (encabezado(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					try {
						detalleCompraIngredientes.add();
					} catch (NoExisteCompraIngrediente e1) {
						System.out.println();
						System.out.println("No existen Compra Ingrediente!");
						System.out.println();
						//e1.printStackTrace();
					} catch (NoExisteIngrediente e1) {
						System.out.println();
						System.out.println("No existen ingredientes!");
						System.out.println();
						//e1.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						detalleCompraIngredientes.delete();
					} catch (SQLException e) {
						System.out.println("No existe detalle de compra ingrediente!");
					}
					break;

				case 3:
					try {
						detalleCompraIngredientes.update();
					} catch (NoExisteCompraIngrediente e) {
						e.printStackTrace();
					} catch (NoExisteIngrediente e) {
						e.printStackTrace();
					} catch (NoExisteDetalleCompraIngrediente e) {
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
				System.out.println("1. Modificar código de compra ingrediente");
				System.out.println("2. Modificar codigo de ingrediente");
				System.out.println("3. Modificar cantidad");
				System.out.println("4. Modificar total de compra");
				System.out.println("0. Salir");
				System.out.println();

				opcion = InputTypes.readInt("¿Su opción? ", scanner);

				if (opcion >= 0 && opcion <= 3) {
					return opcion;
				}
			}
		}

		public static void menúModificar(Scanner scanner, DetalleCompraIngrediente detalleCompraIngrediente) {
			boolean salir = false;

			while (!salir) {
				switch (encabezadoModificar(scanner)) {
				case 0:
					salir = true;
					break;
				case 1:
					detalleCompraIngrediente.setCodCompraIng(InputTypes.readInt("Ingrese el nuevo código de compra ingrediente: ", scanner));
					break;
				case 2:
					detalleCompraIngrediente.setCodIngrediente(InputTypes.readInt("Ingrese el nuevo código de ingrediente: ", scanner));
					break;
				case 3:
					detalleCompraIngrediente.setCantidad(InputTypes.readInt("Ingrese la nueva cantidad", scanner));
					break;
				case 4:
					detalleCompraIngrediente.setTotalCompra(InputTypes.readInt("Ingrese el nuevo total", scanner));
				}
			}
		}
}

