package producto.entity;

public class Producto {
	
	private int codProducto;
	private String nombre;
	private String descripción;
	private double precio;
	private int codCategoría;
	
	public Producto(int codProducto, String nombre, String descripción, double precio, int codCategoría) {
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripción = descripción;
		this.precio = precio;
		this.codCategoría = codCategoría;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodCategoría() {
		return codCategoría;
	}

	public void setCodCategoría(int codCategoría) {
		this.codCategoría = codCategoría;
	}

	@Override
	public String toString() {
		return "Producto [codProducto=" + codProducto + ", nombre=" + nombre + ", descripción=" + descripción
				+ ", precio=" + precio + ", codCategoría=" + codCategoría + "]";
	}
}