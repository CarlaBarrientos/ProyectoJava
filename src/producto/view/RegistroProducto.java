package producto.view;

import java.util.Scanner;

import categor�a.entity.NoExisteCategor�a;

import producto.entity.Producto;
import view.InputTypes;

public class RegistroProducto {

	public static Producto ingresar(Scanner scanner) throws NoExisteCategor�a {
				
		int codProducto = 0;
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		String descripci�n = InputTypes.readString("Descripci�n: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		int codCategor�a = InputTypes.readInt("C�digo Categor�a: ", scanner);
		
		return new Producto(codProducto, nombreProducto, descripci�n, precio, codCategor�a);

	}

}
