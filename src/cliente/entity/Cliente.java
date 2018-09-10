package cliente.entity;

public class Cliente {
	private int codCliente;
	private String nombre;
	private int cI;
	private int tléfono;
	private int celular;
	private String dirección;
	private int puntos;
	public Cliente(int codCliente, String nombre, int cI, int tléfono, int celular, String dirección, int puntos) {
		super();
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.cI= cI;
		this.tléfono = tléfono;
		this.celular = celular;
		this.dirección = dirección;
		this.puntos = puntos;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCI() {
		return cI;
	}
	public void setCI(int cI) {
		this.cI = cI;
	}
	public int getTléfono() {
		return tléfono;
	}
	public void setTléfono(int tléfono) {
		this.tléfono = tléfono;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nombre=" + nombre + ", CI=" + cI + ", tléfono=" + tléfono
				+ ", celular=" + celular + ", dirección=" + dirección + ", puntos=" + puntos + "]";
	}
}
