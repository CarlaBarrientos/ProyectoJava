package factura.entity;

public class Factura {
	private int numVenta;
	private int nit;
	private String nombre;
	private String descripci�n;
	public Factura(int numVenta, int nit, String nombre, String descripci�n) {
		super();
		this.numVenta = numVenta;
		this.nit = nit;
		this.nombre = nombre;
		this.descripci�n = descripci�n;
	}
	public int getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
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
	@Override
	public String toString() {
		return "Factura [numVenta=" + numVenta + ", nit=" + nit + ", nombre=" + nombre + ", descripci�n=" + descripci�n
				+ "]";
	}
	
}
