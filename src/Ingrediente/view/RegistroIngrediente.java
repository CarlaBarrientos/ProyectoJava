package Ingrediente.view;

import java.util.Scanner;

import Ingrediente.entity.Ingrediente;
import view.InputTypes;


public class RegistroIngrediente {
  
	public static  Ingrediente Ingresar(Scanner scanner) {
		
		int codIngrediente = InputTypes.readInt("Ingrese el c�digo del Ingrediente", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);
		double costo =  InputTypes.readDouble("Costo: ", scanner);
		int numAlmac�n = InputTypes.readInt("Ingrese el n�mero de Almac�n", scanner);
		int cantidad = InputTypes.readInt("Ingrese la cantidad de Ingredientes", scanner);
		return new 
				Ingrediente(codIngrediente, descripci�n, costo, numAlmac�n, cantidad);
	}
}
