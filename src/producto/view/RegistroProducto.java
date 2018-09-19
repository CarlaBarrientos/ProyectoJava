package producto.view;

import java.util.Scanner;
import producto.entity.Producto;
import view.InputTypes;

public class RegistroProducto {

	public static Producto ingresar(Scanner scanner) {
				
		int codProducto = 0;
		String nombreProducto = InputTypes.readString("Nombre: ", scanner);
		String descripción = InputTypes.readString("Descripción: ", scanner);
		double precio = InputTypes.readDouble("Precio: ", scanner);
		int codCategoría = InputTypes.readInt("Código Categoría: ", scanner);
		
		return new Producto(codProducto, nombreProducto, descripción, precio, codCategoría);

	}

}