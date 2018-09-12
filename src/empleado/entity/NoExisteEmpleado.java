package empleado.entity;

public class NoExisteEmpleado extends Exception{

	private static final long serialVersionUID = 1L;

	public NoExisteEmpleado() {
		super("El empleado del código ingresado no existe!");
	}
}
