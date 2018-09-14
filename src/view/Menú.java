package view;

import java.sql.SQLException;
import java.util.Scanner;

import categoría.view.Categorías;
import cliente.view.Clientes;
import compraIngrediente.view.CompraIngredientes;
import control.Conexión;
import detalleVenta.view.DetalleVentas;
import empleado.view.Empleados;
import envio.view.Envíos;
import factura.view.Facturas;
import ingrediente.view.Ingredientes;
import producto.view.Productos;
import venta.view.Ventas;

public class Menú {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opción: ");
			System.out.println("------------------- ");
			System.out.println("1. Empleado");
			System.out.println("2. Cliente");
			System.out.println("3. Envío");
			System.out.println("4. Venta");
			System.out.println("5. Factura");
			System.out.println("6. Detale de Venta");
			System.out.println("7. Categoría");
			System.out.println("8. Producto");
			System.out.println("9. Ingrediente");
			System.out.println("10. Compra del Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 10) {
				return opcion;
			}
		}
	}
	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;

		Conexión conexión = new Conexión("root","","Fábricachocolates");
		Clientes clientes = new Clientes(conexión, scanner);
		Empleados empleados = new Empleados(conexión, scanner);
		Envíos envíos = new Envíos(conexión, scanner);
		Ventas ventas = new Ventas(conexión, scanner);
		Facturas facturas = new Facturas(conexión, scanner);
		Categorías categorìas = new Categorías(conexión, scanner);
		Productos productos = new Productos(conexión, scanner);
		DetalleVentas detalleVentas = new DetalleVentas(conexión, scanner);
		Ingredientes ingredientes = new Ingredientes(conexión, scanner);
		CompraIngredientes compraIngredientes = new CompraIngredientes(conexión, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				empleado.view.Menú.menú(scanner, empleados);
				break;
			case 2:
				cliente.view.Menú.menú(scanner, clientes);
				break;
			case 3:
				envio.view.Menú.menú(scanner, envíos);
				break;
			case 4:
				venta.view.Menú.menú(scanner, ventas);

				break;
			case 5:
				factura.view.Menú.menú(scanner, facturas);
				break;
			case 6:
				detalleVenta.view.Menú.menú(scanner, detalleVentas);
				break;
			case 7:
				categoría.view.Menú.menú(scanner, categorìas);
				break;
			case 8:
				producto.view.Menú.menú(scanner, productos);
				break;

			case 9:
				try {

					ingrediente.view.Menú.menú(scanner, ingredientes);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 10:
				compraIngrediente.view.Menú.menú(scanner, compraIngredientes);
				break;

			}
		}
		conexión.close();
	}
}


