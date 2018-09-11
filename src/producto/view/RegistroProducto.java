package producto.view;

import java.util.Scanner;

import categor�a.entity.NoExisteCategor�a;

import producto.entity.Producto;
import view.InputTypes;

public class RegistroProducto {

	/****************************
	 * Registro de producto 
	 * @throws NoExisteCategor�a *
	 ****************************/

	public static Producto ingresar(Scanner scanner) throws NoExisteCategor�a {
				
		int codProducto = InputTypes.readInt("Ingrese el c�digo del producto", scanner);
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		int codCategor�a = InputTypes.readInt("C�digo Categor�a: ", scanner);
		int codIngrediente = InputTypes.readInt("C�digo Ingrediente: ", scanner);
		
		return new Producto(codProducto, nombreProducto, descripci�n, precio, codCategor�a, codIngrediente);

	}

}
