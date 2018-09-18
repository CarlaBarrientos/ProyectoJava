package venta.entity;

import java.util.Date;


public class Venta {
	private int numVenta;
	private Date fecha;
	private int codCliente;
	private int codEmpleado;
	public Venta(int numVenta, Date fecha, int codCliente, int codEmpleado) {
		super();
		this.numVenta = numVenta;
		this.fecha = fecha;
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
		return "Venta [numVenta=" + numVenta + ", fecha=" + fecha + ", codCliente="
				+ codCliente + ", codEmpleado=" + codEmpleado + "]";
	}
	

}
