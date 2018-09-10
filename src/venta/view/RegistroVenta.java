package venta.view;

import java.util.Scanner;

import venta.entity.Venta;
import view.InputTypes;

public class RegistroVenta {
public static Venta ingresar(Scanner scanner){
		
		int numVenta = InputTypes.readInt("Ingrese el n�mero de venta: ", scanner);
		String fecha = InputTypes.readString("Fecha: ", scanner);
		int codEnv�o = InputTypes.readInt("C�digo env�o: ", scanner);
		int codCliente = InputTypes.readInt("C�digo cliente: ", scanner);
		int codEmpleado = InputTypes.readInt("C�digo empleado: ", scanner);
		
		return new Venta(numVenta, fecha, codEnv�o, codCliente, codEmpleado);

	}

}
