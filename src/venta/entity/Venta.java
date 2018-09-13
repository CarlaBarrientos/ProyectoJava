package venta.entity;

import java.util.Date;


public class Venta {
	private int numVenta;
	private Date fecha;
	private int codEnv�o;
	private int codCliente;
	private int codEmpleado;
	public Venta(int numVenta, Date fecha, int codEnv�o, int codCliente, int codEmpleado) {
		super();
		this.numVenta = numVenta;
		this.fecha = fecha;
		this.codEnv�o = codEnv�o;
		this.codCliente = codCliente;
		this.codEmpleado = codEmpleado;
	}
	public int getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(int numVenta){
		this.numVenta = numVenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCodEnv�o() {
		return codEnv�o;
	}
	public void setCodEnv�o(int codEnv�o){
		this.codEnv�o = codEnv�o;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente){
		this.codCliente = codCliente;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado){
		this.codEmpleado = codEmpleado;
	}
	@Override
	public String toString() {
		return "Venta [numVenta=" + numVenta + ", fecha=" + fecha + ", codEnv�o=" + codEnv�o + ", codCliente="
				+ codCliente + ", codEmpleado=" + codEmpleado + "]";
	}
	

}
