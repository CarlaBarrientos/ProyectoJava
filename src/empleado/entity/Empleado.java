package empleado.entity;

public class Empleado {
	private int codEmpleado;
	private String nombre;
	private int cI;
	private int teléfono;
	private int celular;
	private String dirección;
	private String cargo;
	public Empleado(int codEmpleado, String nombre, int cI, int teléfono, int celular, String dirección, String cargo) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.cI = cI;
		this.teléfono = teléfono;
		this.celular = celular;
		this.dirección = dirección;
		this.cargo = cargo;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEMpleado) {
		this.codEmpleado = codEMpleado;
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
		return "Empleado [codEMpleado=" + codEmpleado + ", nombre=" + nombre + ", cI=" + cI + ", teléfono=" + teléfono
				+ ", celular=" + celular + ", dirección=" + dirección + ", cargo=" + cargo + "]";
	}
	
	

}
