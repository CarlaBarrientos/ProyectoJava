package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class RegistroCliente {

	public static Cliente ingresar(Scanner scanner){
		int codCliente = 0;
		String nombreCliente = InputTypes.readString("Nombre: ", scanner);
		int cI = InputTypes.readInt("CI: ", scanner);
		int tel�fono = InputTypes.readInt("Tel�fono: ", scanner);
		int celular = InputTypes.readInt("Celular: ", scanner);
		String direcci�n = InputTypes.readString("Direcci�n: ", scanner);
		int puntos = InputTypes.readInt("Cantidad de puntos iniciales: ", scanner);
		
		return new Cliente(codCliente, nombreCliente, cI, tel�fono, celular, direcci�n, puntos);

	}
}
