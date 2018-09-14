
package categoría.view;

import java.util.Scanner;

import categoría.entity.Categoría;
import view.InputTypes;

public class RegistroCategoría {
	
	public static Categoría ingresar(Scanner scanner) {
		int codProducto = 0;
		String nombre = InputTypes.readString("Nombre: ", scanner);
		String descripción = InputTypes.readString("Descripción: ", scanner);
		
		return new 
				Categoría(codProducto, nombre, descripción);
	}
}