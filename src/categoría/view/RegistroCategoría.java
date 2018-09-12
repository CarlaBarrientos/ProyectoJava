package categoría.view;

import java.util.Scanner;

import categoría.entity.Categoría;
import view.InputTypes;

public class RegistroCategoría {
	
	
	/****************************
	 * Registro de categoría    *
	 ****************************/
	
	public static Categoría ingresar(Scanner scanner) {
		int codProducto = 
				InputTypes.readInt("Ingrese el código de la categoría", scanner);
		String nombre = 
				InputTypes.readString("Nombre: ", scanner);
		String descripción =
				InputTypes.readString("Descripción: ", scanner);
		return new 
				Categoría(codProducto, nombre, descripción);
		
	}
}
