package producto.entity;

public class NoExisteProducto extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoExisteProducto (){
		super("No existe producto");
	}
}
