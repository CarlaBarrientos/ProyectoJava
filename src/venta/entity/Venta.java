package venta.entity;


public class Venta {
	private int numVenta;
	private String fecha;
	private int codEnvío;
	private int codCliente;
	private int codEmpleado;
	public Venta(int numVenta, String fecha, int codEnvío2, int codCliente2, int codEmpleado2) {
		super();
		this.numVenta = numVenta;
		this.fecha = fecha;
		this.codEnvío = codEnvío2;
		this.codCliente = codCliente2;
		this.codEmpleado = codEmpleado2;
	}
	public int getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodEnvío() {
		return codEnvío;
	}
	public void setCodEnvío(int codEnvío) {
		this.codEnvío = codEnvío;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	@Override
	public String toString() {
		return "Venta [numVenta=" + numVenta + ", fecha=" + fecha + ", codEnvío=" + codEnvío + ", codCliente="
				+ codCliente + ", codEmpleado=" + codEmpleado + "]";
	}
	

}
