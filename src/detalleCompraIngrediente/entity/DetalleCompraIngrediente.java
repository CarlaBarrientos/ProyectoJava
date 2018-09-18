package detalleCompraIngrediente.entity;

public class DetalleCompraIngrediente {
	private int codDetalle;
	private int codCompraIng;
	private int codIngrediente;
	private int cantidad;
	private double totalCompra;
	public DetalleCompraIngrediente(int codDetalle, int codCompraIng, int codIngrediente, int cantidad, double totalCompra) {
		this.codDetalle = codDetalle;
		this.codCompraIng = codCompraIng;
		this.codIngrediente = codIngrediente;
		this.cantidad = cantidad;
		this.totalCompra = totalCompra;
		
	}
	
	public int getCodDetalle() {
		return codDetalle;
	}
	
	public void setCodDetalle(int codDetalle) {
		this.codDetalle = codDetalle;
	}
	
	public int getCodCompraIng() {
		return codCompraIng;
	}
	
	public void setCodCompraIng(int codCompraIng) {
		this.codCompraIng = codCompraIng;
	}
	
	public int getCodIngrediente() {
		return codIngrediente;
	}
	
	public void setCodIngrediente(int codIngrediente) {
		this.codIngrediente = codIngrediente;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotalCompra() {
		return totalCompra;
	}
	
	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}
	
	@Override
	public String toString() {
		return "DetalleVenta [codDetalle=" + codDetalle + ", codCompraIng=" + codCompraIng
				+ ", codIngrediente=" + codIngrediente + ", cantidad=" + cantidad + ", totalCompra=" + totalCompra + "]";
	}
}
