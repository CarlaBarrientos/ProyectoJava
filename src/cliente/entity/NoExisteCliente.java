package cliente.entity;

public class NoExisteCliente extends Exception{

	private static final long serialVersionUID = 1L;

	public NoExisteCliente() {
		super("El cliente del código ingresado no existe!");
	}
}
