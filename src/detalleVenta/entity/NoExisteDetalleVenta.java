package detalleVenta.entity;

public class NoExisteDetalleVenta extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteDetalleVenta() {
		super("No existe el detalle de venta!");
	}

}
