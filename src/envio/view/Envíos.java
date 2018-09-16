package envio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import envio.entity.Envío;
import envio.entity.NoExisteEnvío;
import view.InputTypes;

public class Envíos {

	private Conexión conexión;
	private Scanner scanner;
	public Envíos(Conexión conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}
	public void add() throws SQLException{
		Envío envío = RegistroEnvío.ingresar(scanner);
		String sql = "Insert into Envío (codEnvío, destinatario, teléfono, costoAdicional) values(?,?,?,?)";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, envío.getCodEnvío());
			conexión.getSentencia().setString(2, envío.getDestinatario());
			conexión.getSentencia().setInt(3, envío.getTeléfono());
			conexión.getSentencia().setDouble(4, envío.getCostoAdicional());
			conexión.modificacion();
	}
	public void delete() throws NoExisteEnvío, SQLException{
		int codEnvío= InputTypes.readInt("Código del envío: ", scanner);
		String sql = "delete from envío where codEnvío = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codEnvío);
			ResultSet resultSet = conexión.resultado();
			if (resultSet.next()) {
				conexión.modificacion();
			} else {
				throw new NoExisteEnvío();
			}

	}
	
	public void update() throws SQLException, NoExisteEnvío {
		ResultSet resultSet;
		Envío envío=null;
		String destinatario;
		int teléfono;
		double costoAdicional;
		int codEnvío = InputTypes.readInt("Código del envío: ", scanner);
		String sql = "select * from envío where codEnvío = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codEnvío);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			destinatario = resultSet.getString("destinatario");
			codEnvío = resultSet.getInt("codEnvío");
			teléfono = resultSet.getInt("teléfono");
			costoAdicional = resultSet.getDouble("costoAdicional");
			envío = new Envío(codEnvío, destinatario, teléfono, costoAdicional);
		} else {
			throw new NoExisteEnvío();
		}

		System.out.println(envío);
		Menú.menúModificar(scanner, envío);

		sql = "update envío set destinatario = ?, teléfono = ?, costoAdicional = ? where codEnvío = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(4, envío.getCodEnvío());
		conexión.getSentencia().setString(1, envío.getDestinatario());
		conexión.getSentencia().setInt(2, envío.getTeléfono());
		conexión.getSentencia().setDouble(3, envío.getCostoAdicional());
		conexión.modificacion();
	}
	public void list() throws NoExisteEnvío{
		Envío envío;
		String sql = "select * from envío ";
		try {
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			envío = new Envío(resultSet.getInt("codEnvío"), resultSet.getString("destinatario"), resultSet.getInt("teléfono"),
					resultSet.getDouble("costoAdicional"));
			System.out.println(envío);
		}
		} catch (SQLException e) {
			throw new NoExisteEnvío();
		}
		
	}
}
