package producto.view;

import java.util.Scanner;

import categoría.entity.NoExisteCategoría;

import producto.entity.Producto;
import view.InputTypes;

public class RegistroProducto {

	/****************************
	 * Registro de producto 
	 * @throws NoExisteCategoría *
	 ****************************/

	public static Producto ingresar(Scanner scanner) throws NoExisteCategoría {
				
		int codProducto = InputTypes.readInt("Ingrese el código del producto", scanner);
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		String descripción = InputTypes.readString("Descripción: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		int codCategoría = InputTypes.readInt("Código Categoría: ", scanner);
		int codIngrediente = InputTypes.readInt("Código Ingrediente: ", scanner);
		
		return new Producto(codProducto, nombreProducto, descripción, precio, codCategoría, codIngrediente);

	}

}
