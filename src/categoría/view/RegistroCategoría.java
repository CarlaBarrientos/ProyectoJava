
package categor�a.view;

import java.util.Scanner;

import categor�a.entity.Categor�a;
import view.InputTypes;

public class RegistroCategor�a {
	
	public static Categor�a ingresar(Scanner scanner) {
		int codProducto = 0;
		String nombre = InputTypes.readString("Nombre: ", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);
		
		return new 
				Categor�a(codProducto, nombre, descripci�n);
	}
}