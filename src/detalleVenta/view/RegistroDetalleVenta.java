package detalleVenta.view;

import java.util.Scanner;

import detalleVenta.entity.DetalleVenta;
import view.InputTypes;

public class RegistroDetalleVenta {
	
	public static DetalleVenta ingresar(Scanner scanner) {
		int codDetalle = 0;
		int codProducto = InputTypes.readInt("Ingrese el codigo del producto: ", scanner);
		int cantidad = InputTypes.readInt("Ingrese la cantidad: ", scanner);
		double totalVenta = InputTypes.readDouble("Ingrese el precio total de la venta: ", scanner);
		int numVenta = InputTypes.readInt("Ingrese el número de la venta", scanner);
		return new 
				DetalleVenta(codDetalle, codProducto, cantidad, totalVenta, numVenta);
	}
}
