package envio.view;

import java.util.Scanner;

import envio.entity.Env�o;
import view.InputTypes;

public class RegistroEnv�o {
public static Env�o ingresar(Scanner scanner){
		int codEnv�o=0;
		String destinatario = InputTypes.readString("Destinatario: ", scanner);
		int tel�fono = InputTypes.readInt("Tel�fono: ", scanner);
		double costoAdicional = InputTypes.readDouble("El costo adicional es : ", scanner);
		
		return new Env�o(codEnv�o, destinatario, tel�fono, costoAdicional);

	}

}
