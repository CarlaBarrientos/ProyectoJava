package empleado.view;

import java.util.Scanner;

import empleado.entity.Empleado;
import view.InputTypes;

public class RegistroEmpleado {

public static Empleado ingresar(Scanner scanner){
		int codEmpleado=0;
		String nombreEmpleado = InputTypes.readString("Nombre: ", scanner);
		int cI = InputTypes.readInt("CI: ", scanner);
		int tel�fono = InputTypes.readInt("Tel�fono: ", scanner);
		int celular = InputTypes.readInt("Celular: ", scanner);
		String direcci�n = InputTypes.readString("Direcci�n: ", scanner);
		String cargo = InputTypes.readString("Cargo: ", scanner);
		
		return new Empleado(codEmpleado, nombreEmpleado, cI, tel�fono, celular, direcci�n, cargo);

	}
}
