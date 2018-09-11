package factura.entity;

public class NoExisteFactura extends Exception{

	private static final long serialVersionUID = 1L;

	public NoExisteFactura() {
		super("No existe esta factura");
	}
}
