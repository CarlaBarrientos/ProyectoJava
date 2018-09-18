package envio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import envio.entity.Env�o;
import envio.entity.NoExisteEnv�o;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class Env�os {

	private Conexi�n conexi�n;
	private Scanner scanner;
	public Env�os(Conexi�n conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}
	public void add() throws SQLException, NoExisteVenta{
		Env�o env�o = RegistroEnv�o.ingresar(scanner);
		String sqlV = "Select numVenta from Venta where numVenta = ?";
		conexi�n.consulta(sqlV);
		conexi�n.getSentencia().setInt(1, env�o.getNumVenta());
		ResultSet resultSetCli = conexi�n.resultado();
		if(resultSetCli.next()) {
			String sql = "Insert into Env�o (codEnv�o, destinatario, tel�fono, costoAdicional, numVenta) values(?,?,?,?,?)";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, env�o.getCodEnv�o());
			conexi�n.getSentencia().setString(2, env�o.getDestinatario());
			conexi�n.getSentencia().setInt(3, env�o.getTel�fono());
			conexi�n.getSentencia().setDouble(4, env�o.getCostoAdicional());
			conexi�n.getSentencia().setInt(5, env�o.getNumVenta());
			conexi�n.modificacion();
		}else {
			throw new NoExisteVenta();
		}
	}
	public void delete() throws SQLException{
		int codEnv�o= InputTypes.readInt("C�digo del env�o: ", scanner);
		String sql = "delete from env�o where codEnv�o = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codEnv�o);
			conexi�n.modificacion();

	}

	public void update() throws SQLException, NoExisteEnv�o, NoExisteVenta {
		ResultSet resultSet1;
		Env�o env�o=null;
		String destinatario;
		int tel�fono;
		double costoAdicional;
		int codEnv�o = InputTypes.readInt("C�digo del env�o: ", scanner);
		String sql = "select * from env�o where codEnv�o = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codEnv�o);
		resultSet1 = conexi�n.resultado();
		if (resultSet1.next()) {
			int numVenta = InputTypes.readInt("N�mero de la venta: ", scanner);
			String sql1 = "select * from venta where numVenta = ?";
			conexi�n.consulta(sql1);
			conexi�n.getSentencia().setInt(1, numVenta);
			ResultSet resultSet = conexi�n.resultado();
			if(resultSet.next()) {
				System.out.println("adcwe");
				destinatario = resultSet1.getString("destinatario");
				codEnv�o = resultSet1.getInt("codEnv�o");
				tel�fono = resultSet1.getInt("tel�fono");
				costoAdicional = resultSet1.getDouble("costoAdicional");
				numVenta = resultSet1.getInt("numVenta");
				env�o = new Env�o(codEnv�o, destinatario, tel�fono, costoAdicional, numVenta);
				System.out.println(env�o);
				Men�.men�Modificar(scanner, env�o);

				sql = "update env�o set numVenta = ?, destinatario = ?, tel�fono = ?, costoAdicional = ?  where codEnv�o = ?";

				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(5, env�o.getCodEnv�o());
				conexi�n.getSentencia().setString(2, env�o.getDestinatario());
				conexi�n.getSentencia().setInt(3, env�o.getTel�fono());
				conexi�n.getSentencia().setDouble(4, env�o.getCostoAdicional());
				conexi�n.getSentencia().setInt(1, env�o.getNumVenta());
				conexi�n.modificacion();
			}else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteEnv�o();
		}


	}
	public void list() throws NoExisteEnv�o{
		Env�o env�o;
		String sql = "select * from env�o ";
		try {
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				env�o = new Env�o(resultSet.getInt("codEnv�o"), resultSet.getString("destinatario"), resultSet.getInt("tel�fono"),
						resultSet.getDouble("costoAdicional"), resultSet.getInt("numVenta"));
				System.out.println(env�o);
			}
		} catch (SQLException e) {
			throw new NoExisteEnv�o();
		}

	}
}
