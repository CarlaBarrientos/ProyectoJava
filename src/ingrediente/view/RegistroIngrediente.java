package ingrediente.view;

import java.util.Scanner;

import ingrediente.entity.Ingrediente;
import view.InputTypes;


public class RegistroIngrediente {
  
	public static  Ingrediente Ingresar(Scanner scanner) {
		
		int codIngrediente = 0;
		String descripción = InputTypes.readString("Descripción: ", scanner);
		double costo =  InputTypes.readDouble("Costo: ", scanner);
		int numAlmacén = InputTypes.readInt("Ingrese el número de Almacén", scanner);
		int cantidad = InputTypes.readInt("Ingrese la cantidad de Ingredientes", scanner);
		return new 
				Ingrediente(codIngrediente, descripción, costo, numAlmacén, cantidad);
	}
}