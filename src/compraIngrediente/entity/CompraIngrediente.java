package compraIngrediente.entity;

public class CompraIngrediente {
  
   private int codCompraIngrediente;
   private String proveedor;
   private int codEmpleado;
   private String nombre;
  
   public CompraIngrediente(int codCompraIngrediente, String proveedor, int codEmpleado, String nombre) {
	   this.codCompraIngrediente = codCompraIngrediente;
	   this.proveedor = proveedor;
	   this.codEmpleado = codEmpleado;
	   this.nombre = nombre;
   }
   
    public int getCodCompraIngrediente() {
		return codCompraIngrediente;
	}
    
	public void setCodCompraIngrediente(int codCompraIngrediente) {
		this.codCompraIngrediente = codCompraIngrediente;
	}
	
	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	public int getCodEmpleado() {
		return codEmpleado ;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CompraIngrediente [codCompraIngrediente=" + codCompraIngrediente + ", proveedor=" + proveedor + ",codEmpleado=" + codEmpleado + "]";
	}
}