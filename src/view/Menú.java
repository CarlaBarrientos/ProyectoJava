package view;

import java.sql.SQLException;
import java.util.Scanner;

import categor�a.view.Categor�as;
import control.Conexi�n;
import detalleVenta.view.DetalleVentas;
import producto.view.Productos;

public class Men� {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opci�n: ");
			System.out.println("------------------- ");
			System.out.println("1. Categor�a");
			System.out.println("2. Producto");
			System.out.println("3. Detale de Venta");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}
	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexi�n conexi�n = new Conexi�n("root","","F�bricachocolates");
		Categor�as categor�as = new Categor�as(conexi�n, scanner);
		Productos productos = new Productos(conexi�n, scanner);
		DetalleVentas detalleVentas = new DetalleVentas(conexi�n, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categor�a.view.Men�.men�(scanner, categor�as);
				break;
			case 2:
				producto.view.Men�.men�(scanner, productos);
				break;
			case 3:
				detalleVenta.view.Men�.men�(scanner, detalleVentas);
				break;
			}
			
		}
		conexi�n.close();
	}
}
