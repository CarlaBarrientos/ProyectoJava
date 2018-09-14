package compraIngrediente.entity;

public class NoExisteCompraIngrediente extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteCompraIngrediente() {
		super("No existe compra de ingrediente");
	} 

}