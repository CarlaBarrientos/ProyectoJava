package factura.view;

import java.util.Scanner;

import factura.entity.Factura;
import view.InputTypes;

public class RegistroFactura {

public static Factura ingresar(Scanner scanner){
		int numVenta = InputTypes.readInt("N�mero de venta: ", scanner);
		int nit = InputTypes.readInt("NIT: ", scanner);
		String nombre = InputTypes.readString("Nombre: ", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);

		return new Factura(numVenta, nit, nombre, descripci�n);

	}
}
