package envio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import envio.entity.Envío;
import envio.entity.NoExisteEnvío;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class Envíos {

	private Conexión conexión;
	private Scanner scanner;
	public Envíos(Conexión conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}
	public void add() throws SQLException, NoExisteVenta{
		Envío envío = RegistroEnvío.ingresar(scanner);
		String sqlV = "Select numVenta from Venta where numVenta = ?";
		conexión.consulta(sqlV);
		conexión.getSentencia().setInt(1, envío.getNumVenta());
		ResultSet resultSetCli = conexión.resultado();
		if(resultSetCli.next()) {
			String sql = "Insert into Envío (codEnvío, destinatario, teléfono, costoAdicional, numVenta) values(?,?,?,?,?)";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, envío.getCodEnvío());
			conexión.getSentencia().setString(2, envío.getDestinatario());
			conexión.getSentencia().setInt(3, envío.getTeléfono());
			conexión.getSentencia().setDouble(4, envío.getCostoAdicional());
			conexión.getSentencia().setInt(5, envío.getNumVenta());
			conexión.modificacion();
		}else {
			throw new NoExisteVenta();
		}
	}
	public void delete() throws SQLException{
		int codEnvío= InputTypes.readInt("Código del envío: ", scanner);
		String sql = "delete from envío where codEnvío = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codEnvío);
			conexión.modificacion();

	}

	public void update() throws SQLException, NoExisteEnvío, NoExisteVenta {
		ResultSet resultSet1;
		Envío envío=null;
		String destinatario;
		int teléfono;
		double costoAdicional;
		int codEnvío = InputTypes.readInt("Código del envío: ", scanner);
		String sql = "select * from envío where codEnvío = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codEnvío);
		resultSet1 = conexión.resultado();
		if (resultSet1.next()) {
			int numVenta = InputTypes.readInt("Número de la venta: ", scanner);
			String sql1 = "select * from venta where numVenta = ?";
			conexión.consulta(sql1);
			conexión.getSentencia().setInt(1, numVenta);
			ResultSet resultSet = conexión.resultado();
			if(resultSet.next()) {
				System.out.println("adcwe");
				destinatario = resultSet1.getString("destinatario");
				codEnvío = resultSet1.getInt("codEnvío");
				teléfono = resultSet1.getInt("teléfono");
				costoAdicional = resultSet1.getDouble("costoAdicional");
				numVenta = resultSet1.getInt("numVenta");
				envío = new Envío(codEnvío, destinatario, teléfono, costoAdicional, numVenta);
				System.out.println(envío);
				Menú.menúModificar(scanner, envío);

				sql = "update envío set numVenta = ?, destinatario = ?, teléfono = ?, costoAdicional = ?  where codEnvío = ?";

				conexión.consulta(sql);
				conexión.getSentencia().setInt(5, envío.getCodEnvío());
				conexión.getSentencia().setString(2, envío.getDestinatario());
				conexión.getSentencia().setInt(3, envío.getTeléfono());
				conexión.getSentencia().setDouble(4, envío.getCostoAdicional());
				conexión.getSentencia().setInt(1, envío.getNumVenta());
				conexión.modificacion();
			}else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteEnvío();
		}


	}
	public void list() throws NoExisteEnvío{
		Envío envío;
		String sql = "select * from envío ";
		try {
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				envío = new Envío(resultSet.getInt("codEnvío"), resultSet.getString("destinatario"), resultSet.getInt("teléfono"),
						resultSet.getDouble("costoAdicional"), resultSet.getInt("numVenta"));
				System.out.println(envío);
			}
		} catch (SQLException e) {
			throw new NoExisteEnvío();
		}

	}
}
