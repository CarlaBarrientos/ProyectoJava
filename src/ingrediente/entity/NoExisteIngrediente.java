package ingrediente.entity;

public class NoExisteIngrediente extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteIngrediente() {
		super("No existe el ingrediente");
	}
}
