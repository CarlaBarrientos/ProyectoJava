package empleado.entity;

public class Empleado {
	private int codEMpleado;
	private String nombre;
	private int cI;
	private int teléfono;
	private int celular;
	private String dirección;
	private String cargo;
	public Empleado(int codEMpleado, String nombre, int cI, int teléfono, int celular, String dirección, String cargo) {
		super();
		this.codEMpleado = codEMpleado;
		this.nombre = nombre;
		this.cI = cI;
		this.teléfono = teléfono;
		this.celular = celular;
		this.dirección = dirección;
		this.cargo = cargo;
	}
	public int getCodEMpleado() {
		return codEMpleado;
	}
	public void setCodEMpleado(int codEMpleado) {
		this.codEMpleado = codEMpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getcI() {
		return cI;
	}
	public void setcI(int cI) {
		this.cI = cI;
	}
	public int getTeléfono() {
		return teléfono;
	}
	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Empleado [codEMpleado=" + codEMpleado + ", nombre=" + nombre + ", cI=" + cI + ", teléfono=" + teléfono
				+ ", celular=" + celular + ", dirección=" + dirección + ", cargo=" + cargo + "]";
	}
	
	

}
