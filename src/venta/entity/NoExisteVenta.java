package venta.entity;

public class NoExisteVenta extends Exception{
	private static final long serialVersionUID = 1L;

	public NoExisteVenta() {
		super("El n�mero de venta ingresado no existe!");
	}

}
