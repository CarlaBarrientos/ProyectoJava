package compraIngrediente.entity;



public class CompraIngrediente {
  
   private int codCompraIngrediente;
   private String proveedor;
   private int codEmpleado;
  
   public CompraIngrediente(int codCompraIngrediente, String proveedor, int codEmpleado) {
	   this.codCompraIngrediente = codCompraIngrediente;
	   this.proveedor = proveedor;
	   this.codEmpleado = codEmpleado;
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

	@Override
	public String toString() {
		return "CompraIngrediente [codCompraIngrediente=" + codCompraIngrediente + ", proveedor=" + proveedor + ",codEmpleado=" + codEmpleado + "]";
	}
	
}