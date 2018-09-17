package detalleCompraIngrediente.entity;

public class NoExisteDetalleCompraIngrediente extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteDetalleCompraIngrediente() {
		super("No existe el detalle de compra de ingrediente!");
	}
 

 }
