package CompraIngrediente.entity;



public class CompraIngrediente {
  
   private int codCompraIngrediente;
   private String nombre;
   private int cantidad;
   private int factura;
   private String proveedor;
  
   public CompraIngrediente(int codCompraIngrediente, String nombre, int cantidad, int factura, String proveedor) {
	   this.codCompraIngrediente = codCompraIngrediente;
	   this.nombre = nombre;
	   this.cantidad = cantidad;
	   this.factura = factura;
	   this.proveedor = proveedor;
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

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "CompraIngrediente [codCompraIngrediente=" + codCompraIngrediente + ", nombre=" + nombre + ", cantidad=" + cantidad + ", factura="
				+ factura + ", proveedor=" + proveedor + "]";
	}
	
}
