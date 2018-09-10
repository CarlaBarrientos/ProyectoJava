package CompraIngrediente.entity;



public class CompraIngrediente {
  
   private int codCompraIngrediente;
   private String nombre;
   private int cantidad;
   private int factura;
  
   public CompraIngrediente(int codCompraIngrediente, String nombre, int cantidad, int factura) {
	   this.codCompraIngrediente = codCompraIngrediente;
	   this.nombre = nombre;
	   this.cantidad = cantidad;
	   this.factura = factura;
   }
   
    public int getCodCompraIngrediente() {
		return codCompraIngrediente;
	}
	public void setCodCompraIngrediente(int codCompraIngrediente) {
		this.codCompraIngrediente = codCompraIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getFactura() {
		return factura;
	}
	public void setFactura(int factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "CompraIngrediente [codCompraIngrediente=" + codCompraIngrediente + ", nombre=" + nombre + ", cantidad=" + cantidad + ", factura="
				+ factura + "]";
	}
	
}
