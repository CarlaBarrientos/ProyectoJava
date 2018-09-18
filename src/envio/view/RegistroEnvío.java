package envio.view;

import java.util.Scanner;

import envio.entity.Envío;
import view.InputTypes;

public class RegistroEnvío {
public static Envío ingresar(Scanner scanner){
		int codEnvío=0;
		String destinatario = InputTypes.readString("Destinatario: ", scanner);
		int teléfono = InputTypes.readInt("Teléfono: ", scanner);
		double costoAdicional = InputTypes.readDouble("El costo adicional es : ", scanner);
		int numVenta = InputTypes.readInt("El número de venta es: ", scanner);
		
		return new Envío(codEnvío, destinatario, teléfono, costoAdicional, numVenta);

	}

}
