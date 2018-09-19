package venta.view;

import java.util.Date;
import java.util.Scanner;
import venta.entity.Venta;
import view.InputTypes;

public class RegistroVenta {

	public static Venta ingresar(Scanner scanner) {
		int numVenta=0;
		Date fecha = InputTypes.readDate("Fecha: ", scanner);
		int codCliente = InputTypes.readInt("Código cliente: ", scanner);
		int codEmpleado = InputTypes.readInt("Código empleado: ", scanner);
		return new Venta(numVenta, fecha, codCliente, codEmpleado);
	}
}
