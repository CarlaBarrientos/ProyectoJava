package view;

import java.sql.SQLException;
import java.util.Scanner;

import categor�a.view.Categor�as;
import cliente.view.Clientes;
import compraIngrediente.view.CompraIngredientes;
import control.Conexi�n;
import detalleVenta.view.DetalleVentas;
import empleado.view.Empleados;
import envio.view.Env�os;
import factura.view.Facturas;
import ingrediente.view.Ingredientes;
import producto.view.Productos;
import venta.view.Ventas;

public class Men� {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opci�n: ");
			System.out.println("------------------- ");
			System.out.println("1. Empleado");
			System.out.println("2. Cliente");
			System.out.println("3. Env�o");
			System.out.println("4. Venta");
			System.out.println("5. Factura");
			System.out.println("6. Detale de Venta");
			System.out.println("7. Categor�a");
			System.out.println("8. Producto");
			System.out.println("9. Ingrediente");
			System.out.println("10. Compra del Ingrediente ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 10) {
				return opcion;
			}
		}
	}
	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;

		Conexi�n conexi�n = new Conexi�n("root","","F�bricachocolates");
		Clientes clientes = new Clientes(conexi�n, scanner);
		Empleados empleados = new Empleados(conexi�n, scanner);
		Env�os env�os = new Env�os(conexi�n, scanner);
		Ventas ventas = new Ventas(conexi�n, scanner);
		Facturas facturas = new Facturas(conexi�n, scanner);
		Categor�as categor�as = new Categor�as(conexi�n, scanner);
		Productos productos = new Productos(conexi�n, scanner);
		DetalleVentas detalleVentas = new DetalleVentas(conexi�n, scanner);
		Ingredientes ingredientes = new Ingredientes(conexi�n, scanner);
		CompraIngredientes compraIngredientes = new CompraIngredientes(conexi�n, scanner);

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				empleado.view.Men�.men�(scanner, empleados);
				break;
			case 2:
				cliente.view.Men�.men�(scanner, clientes);
				break;
			case 3:
				envio.view.Men�.men�(scanner, env�os);
				break;
			case 4:
				venta.view.Men�.men�(scanner, ventas);

				break;
			case 5:
				factura.view.Men�.men�(scanner, facturas);
				break;
			case 6:
				detalleVenta.view.Men�.men�(scanner, detalleVentas);
				break;
			case 7:
				categor�a.view.Men�.men�(scanner, categor�as);
				break;
			case 8:
				producto.view.Men�.men�(scanner, productos);
				break;

			case 9:
				try {

					ingrediente.view.Men�.men�(scanner, ingredientes);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 10:
				compraIngrediente.view.Men�.men�(scanner, compraIngredientes);
				break;

			}
		}
		conexi�n.close();
	}
}


