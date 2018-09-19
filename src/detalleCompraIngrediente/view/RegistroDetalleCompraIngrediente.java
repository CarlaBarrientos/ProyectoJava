package detalleCompraIngrediente.view;

import java.util.Scanner;

import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import view.InputTypes;

public class RegistroDetalleCompraIngrediente {
    
	public static DetalleCompraIngrediente ingresar(Scanner scanner) {
		 int codDetalle = 0;
	     int codCompraIng = InputTypes.readInt("Ingrese el codigo de Compra del Ingrediente: ", scanner);
		 int codIngrediente = InputTypes.readInt("Ingrese el codigo del Ingrediente: ", scanner);
		 int cantidad = InputTypes.readInt("Ingrese  la cantidad de ingredientes: ", scanner);
		 double totalCompra = InputTypes.readDouble("Ingrese el total de compra: ", scanner);
		return new  
				DetalleCompraIngrediente(codDetalle, codCompraIng, codIngrediente, cantidad, totalCompra);
	}
}
