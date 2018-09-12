package envio.view;

import java.util.Scanner;

import envio.entity.Envío;
import view.InputTypes;

public class RegistroEnvío {
public static Envío ingresar(Scanner scanner){
		
		String destinatario = InputTypes.readString("Destinatario: ", scanner);
		int teléfono = InputTypes.readInt("Teléfono: ", scanner);
		double costoAdicional = InputTypes.readDouble("El costo adicional es : ", scanner);
		
		return new Envío(destinatario, teléfono, costoAdicional);

	}

}
