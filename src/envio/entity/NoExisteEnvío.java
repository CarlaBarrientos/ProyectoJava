package envio.entity;

public class NoExisteEnvío extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteEnvío() {
		super("No existe el envío");
	}

}
