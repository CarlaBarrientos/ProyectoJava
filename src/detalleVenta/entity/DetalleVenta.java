package detalleVenta.entity;

public class DetalleVenta {

	private int codVenta;
	private int numVenta;
	private int codProducto;
	private int cantidad;
	
	public DetalleVenta(int codVenta, int numVenta, int codProducto, int cantidad) {
		this.codVenta = codVenta;
		this.numVenta = numVenta;
		this.codProducto = codProducto;
		this.cantidad = cantidad;
	}
	
	public int getCodVenta() {
		return codVenta;
	}
	
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	
	public int getNumVenta() {
		return numVenta;
	}
	
	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
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
	
	@Override
	public String toString() {
		return "DetalleVenta [codVenta=" + codVenta + ", numVenta=" + numVenta + ", codProducto=" + codProducto
				+ ", cantidad=" + cantidad + "]";
	}
}
