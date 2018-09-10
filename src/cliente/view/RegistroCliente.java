package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;
import view.InputTypes;

public class RegistroCliente {

	public static Cliente ingresar(Scanner scanner){
		
		int codCliente = InputTypes.readInt("Ingrese el código del cliente: ", scanner);
		String nombreCliente = InputTypes.readString("Nombre: ", scanner);
		int cI = InputTypes.readInt("CI: ", scanner);
		int teléfono = InputTypes.readInt("Teléfono: ", scanner);
		int celular = InputTypes.readInt("Celular: ", scanner);
		String dirección = InputTypes.readString("Dirección: ", scanner);
		int puntos = InputTypes.readInt("Cantidad de puntos: ", scanner);
		
		return new Cliente(codCliente, nombreCliente, cI, teléfono, celular, dirección, puntos);

	}
}
