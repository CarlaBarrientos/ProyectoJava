package factura.entity;

public class Factura {
	private int numVenta;
	private int nit;
	private String nombre;
	private String descripción;
	public Factura(int numVenta, int nit, String nombre, String descripción) {
		super();
		this.numVenta = numVenta;
		this.nit = nit;
		this.nombre = nombre;
		this.descripción = descripción;
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
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	@Override
	public String toString() {
		return "Factura [numVenta=" + numVenta + ", nit=" + nit + ", nombre=" + nombre + ", descripción=" + descripción
				+ "]";
	}
	
}
