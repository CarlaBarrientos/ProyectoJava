package detalleVenta.view;

import java.util.Scanner;

import detalleVenta.entity.DetalleVenta;
import view.InputTypes;

public class RegistroDetalleVenta {

	
	/****************************
	 * Registro de detalleVenta    *
	 ****************************/
	
	public static DetalleVenta ingresar(Scanner scanner) {
		int codVenta = 
				InputTypes.readInt("Ingrese el código de venta: ", scanner);
		int numVenta = 
				InputTypes.readInt("Ingrese el número de venta: ", scanner);
		int codProducto =
				InputTypes.readInt("Ingrese el codigo del producto: ", scanner);
		int cantidad = 
				InputTypes.readInt("Ingrese las cantidad: ", scanner);
		return new 
				DetalleVenta(codVenta, numVenta, codProducto, cantidad);
		
	}
}
