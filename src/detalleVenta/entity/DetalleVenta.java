package detalleVenta.entity;

public class DetalleVenta {

	private int codDetalle;
	private int codProducto;
	private int cantidad;
	private double totalVenta;
	private int numVenta;
	
	public DetalleVenta(int codDetalle, int codProducto, int cantidad, double totalVenta, int numVenta) {
		this.codDetalle = codDetalle;
		this.codProducto = codProducto;
		this.cantidad = cantidad;
		this.totalVenta = totalVenta;
		this.numVenta = numVenta;
	}

	public int getCodDetalle() {
		return codDetalle;
	}

	public void setCodDetalle(int codDetalle) {
		this.codDetalle = codDetalle;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public int getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}

	@Override
	public String toString() {
		return "DetalleVenta [codDetalle=" + codDetalle + ", codProducto=" + codProducto + ", cantidad=" + cantidad
				+ ", totalVenta=" + totalVenta + ", numVenta=" + numVenta + "]";
	}
}