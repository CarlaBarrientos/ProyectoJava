package categoría.entity;

public class NoExisteCategoría extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteCategoría() {
		super("No existe la categoría");
	}

	
}
