package detalleVenta.view;

import java.util.Scanner;

import detalleVenta.entity.DetalleVenta;
import view.InputTypes;

public class RegistroDetalleVenta {
	
	public static DetalleVenta ingresar(Scanner scanner) {
		int numVenta = 0;
		int codProducto = InputTypes.readInt("Ingrese el codigo del producto: ", scanner);
		int cantidad = InputTypes.readInt("Ingrese la cantidad: ", scanner);
		return new 
				DetalleVenta(numVenta, codProducto, cantidad);
	}
}
