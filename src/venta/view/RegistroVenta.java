package venta.view;

import java.util.Date;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import empleado.entity.NoExisteEmpleado;
import envio.entity.NoExisteEnv�o;
import venta.entity.Venta;
import view.InputTypes;

public class RegistroVenta {
public static Venta ingresar(Scanner scanner)throws NoExisteCliente, NoExisteEnv�o, NoExisteEmpleado{
		int numVenta=0;
		Date fecha = InputTypes.readDate("Fecha: ", scanner);
		int codEnv�o = InputTypes.readInt("C�digo env�o: ", scanner);
		int codCliente = InputTypes.readInt("C�digo cliente: ", scanner);
		int codEmpleado = InputTypes.readInt("C�digo empleado: ", scanner);
		
		return new Venta(numVenta, fecha, codEnv�o, codCliente, codEmpleado);

	}

}
