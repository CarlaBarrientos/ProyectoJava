package view;

import java.sql.SQLException;
import java.util.Scanner;

import categoría.view.Categorías;
import control.Conexión;
import detalleVenta.view.DetalleVentas;
import producto.view.Productos;

public class Menú {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opción: ");
			System.out.println("------------------- ");
			System.out.println("1. Categorìa");
			System.out.println("2. Producto");
			System.out.println("3. Detale de Venta");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}
	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexión conexión = new Conexión("root","","Fábricachocolates");
		Categorías categorìas = new Categorías(conexión, scanner);
		Productos productos = new Productos(conexión, scanner);
		DetalleVentas detalleVentas = new DetalleVentas(conexión, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categoría.view.Menú.menú(scanner, categorìas);
				break;
			case 2:
				producto.view.Menú.menú(scanner, productos);
				break;
			case 3:
				detalleVenta.view.Menú.menú(scanner, detalleVentas);
				break;
			}
			
		}
		conexión.close();
	}
}
