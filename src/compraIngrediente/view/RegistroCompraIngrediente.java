package compraIngrediente.view;

import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import view.InputTypes;

public class RegistroCompraIngrediente {

	public static CompraIngrediente Ingresar(Scanner scanner) {
		int codCompraIngrediente = 0;
		String proveedor = InputTypes.readString("Ingresar nombre del proveedor", scanner);
		int codEmpleado = InputTypes.readInt("Ingresar el codigo del empleado", scanner);

		return new CompraIngrediente(codCompraIngrediente, proveedor, codEmpleado);
	}
}
