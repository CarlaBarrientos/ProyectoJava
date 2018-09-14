package compraIngrediente.view;

import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import view.InputTypes;

public class RegistroCompraIngrediente {

	public static CompraIngrediente Ingresar(Scanner scanner) {
		int codCompraIngrediente = InputTypes.readInt("Ingresar código de compra del ingrediente", scanner);
		String nombre = InputTypes.readString("Ingresar el nombre del ingrediente", scanner);
		int cantidad = InputTypes.readInt("Ingressar cantidad de ingredientes ", scanner);
		int factura= InputTypes.readInt("Ingresar número de factura", scanner);
		String proveedor = InputTypes.readString("Ingresar nombre del proveedor", scanner);
		return new CompraIngrediente(codCompraIngrediente, nombre, cantidad, factura, proveedor);
	}
}
