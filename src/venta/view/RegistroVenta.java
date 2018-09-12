package venta.view;

import java.util.Date;
import java.util.Scanner;

import venta.entity.Venta;
import view.InputTypes;

public class RegistroVenta {
public static Venta ingresar(Scanner scanner){
		
		Date fecha = InputTypes.readDate("Fecha: ", scanner);
		int codEnvío = InputTypes.readInt("Código envío: ", scanner);
		int codCliente = InputTypes.readInt("Código cliente: ", scanner);
		int codEmpleado = InputTypes.readInt("Código empleado: ", scanner);
		
		return new Venta(fecha, codEnvío, codCliente, codEmpleado);

	}

}
