package envio.entity;

public class Envío {
	private int codEnvío;
	private String destinatario;
	private int teléfono;
	private double costoAdicional;
	public Envío(int codEnvío, String destinatario, int teléfono, double costoAdicional) {
		super();
		this.codEnvío = codEnvío;
		this.destinatario = destinatario;
		this.teléfono = teléfono;
		this.costoAdicional = costoAdicional;
	}
	public int getCodEnvío() {
		return codEnvío;
	}
	public void setCodEnvío(int codEnvío) {
		this.codEnvío = codEnvío;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public int getTeléfono() {
		return teléfono;
	}
	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}
	public double getCostoAdicional() {
		return costoAdicional;
	}
	public void setCostoAdicional(double costoAdicional) {
		this.costoAdicional = costoAdicional;
	}
	@Override
	public String toString() {
		return "Envío [codEnvío=" + codEnvío + ", destinatario=" + destinatario + ", teléfono=" + teléfono
				+ ", costoAdicional=" + costoAdicional + "]";
	}
	
}
