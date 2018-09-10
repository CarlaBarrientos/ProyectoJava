package venta.view;

import java.util.Scanner;

import venta.entity.Venta;
import view.InputTypes;

public class RegistroVenta {
public static Venta ingresar(Scanner scanner){
		
		int numVenta = InputTypes.readInt("Ingrese el número de venta: ", scanner);
		String fecha = InputTypes.readString("Fecha: ", scanner);
		int codEnvío = InputTypes.readInt("Código envío: ", scanner);
		int codCliente = InputTypes.readInt("Código cliente: ", scanner);
		int codEmpleado = InputTypes.readInt("Código empleado: ", scanner);
		
		return new Venta(numVenta, fecha, codEnvío, codCliente, codEmpleado);

	}

}
