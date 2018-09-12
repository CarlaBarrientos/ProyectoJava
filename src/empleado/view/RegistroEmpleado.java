package empleado.view;

import java.util.Scanner;

import empleado.entity.Empleado;
import view.InputTypes;

public class RegistroEmpleado {

public static Empleado ingresar(Scanner scanner){
		int codEmpleado=0;
		String nombreEmpleado = InputTypes.readString("Nombre: ", scanner);
		int cI = InputTypes.readInt("CI: ", scanner);
		int teléfono = InputTypes.readInt("Teléfono: ", scanner);
		int celular = InputTypes.readInt("Celular: ", scanner);
		String dirección = InputTypes.readString("Dirección: ", scanner);
		String cargo = InputTypes.readString("Cargo: ", scanner);
		
		return new Empleado(codEmpleado, nombreEmpleado, cI, teléfono, celular, dirección, cargo);

	}
}
