package cliente.entity;

public class Cliente {
	private int codCliente;
	private String nombre;
	private int cI;
	private int tel�fono;
	private int celular;
	private String direcci�n;
	private int puntos;
	public Cliente(int codCliente, String nombre, int cI, int tel�fono, int celular, String direcci�n, int puntos) {
		super();
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.cI= cI;
		this.tel�fono = tel�fono;
		this.celular = celular;
		this.direcci�n = direcci�n;
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
	public int getTel�fono() {
		return tel�fono;
	}
	public void setTel�fono(int tel�fono) {
		this.tel�fono = tel�fono;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nombre=" + nombre + ", CI=" + cI + ", tl�fono=" + tel�fono
				+ ", celular=" + celular + ", direcci�n=" + direcci�n + ", puntos=" + puntos + "]";
	}
}
