package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class RegistroCliente {

	public static Cliente ingresar(Scanner scanner){
		
		int codCliente = InputTypes.readInt("Ingrese el c�digo del cliente: ", scanner);
		String nombreCliente = InputTypes.readString("Nombre: ", scanner);
		int cI = InputTypes.readInt("CI: ", scanner);
		int tel�fono = InputTypes.readInt("Tel�fono: ", scanner);
		int celular = InputTypes.readInt("Celular: ", scanner);
		String direcci�n = InputTypes.readString("Direcci�n: ", scanner);
		int puntos = InputTypes.readInt("Cantidad de puntos: ", scanner);
		
		return new Cliente(codCliente, nombreCliente, cI, tel�fono, celular, direcci�n, puntos);

	}
}
