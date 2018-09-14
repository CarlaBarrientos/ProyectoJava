package producto.entity;

public class Producto {
	
	private int codProducto;
	private String nombre;
	private String descripci�n;
	private double precio;
	private int codCategor�a;
	private int codIngrediente;
	
	public Producto(int codProducto, String nombre, String descripci�n, double precio, int codCategor�a, int codIngrediente) {
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
		this.precio = precio;
		this.codCategor�a = codCategor�a;
		this.codIngrediente = codIngrediente;
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
	
	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodCategor�a() {
		return codCategor�a;
	}

	public void setCodCategor�a(int codCategor�a) {
		this.codCategor�a = codCategor�a;
	}

	public int getCodIngrediente() {
		return codIngrediente;
	}

	public void setCodIngrediente(int codIngrediente) {
		this.codIngrediente = codIngrediente;
	}

	@Override
	public String toString() {
		return "Producto [codProducto=" + codProducto + ", nombre=" + nombre + ", descripci�n=" + descripci�n
				+ ", precio=" + precio + ", codCategor�a=" + codCategor�a + ", codIngrediente=" + codIngrediente + "]";
	}


}