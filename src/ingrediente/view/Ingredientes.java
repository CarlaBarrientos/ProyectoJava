package ingrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;

public class Ingredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;

	public Ingredientes(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;

	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingredientes (codIngrediente, descripci�n, costo, numAlmac�n, cantidad) values(?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, ingrediente.getCodIngrediente());
			conexi�n.getSentencia().setString(2, ingrediente.getDescripci�n());
			conexi�n.getSentencia().setDouble(3, ingrediente.getCosto());
			conexi�n.getSentencia().setInt(4, ingrediente.getNumAlmac�n());
			conexi�n.getSentencia().setInt(5,ingrediente.getCantidad());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void delete() throws NoExisteIngrediente, SQLException {
		int codIngrediente = InputTypes.readInt("C�digo del Ingrediente: ", scanner);
		String sql = "delete from ingredientes where codIngrediente = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codIngrediente);
		ResultSet resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			conexi�n.modificacion(); 
		}else {
			throw new NoExisteIngrediente();
		}
	}

	public void update() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripci�n;
		int costo;
		int numAlmac�n;
		int cantidad;
		int codIngrediente = InputTypes.readInt("C�digo del Ingrediente: ", scanner);
		String sql = "select * from ingredientes where codIngrediente = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codIngrediente);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			descripci�n = resultSet.getString("descripci�n");
			costo = resultSet.getInt("costo");
			numAlmac�n = resultSet.getInt("numAlmac�n");
			cantidad = resultSet.getInt("cantidad");
			ingrediente = new Ingrediente(codIngrediente, descripci�n, costo, numAlmac�n, cantidad);
		} else {
			throw new NoExisteIngrediente();
		}

		System.out.println(ingrediente);
		Men�.men�Modificar(scanner, ingrediente);

		sql = "update ingredientes set descripci�n = ?, costo = ?, numAlmac�n = ? where codIngrediente = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, ingrediente.getCodIngrediente());
		conexi�n.getSentencia().setString(2, ingrediente.getDescripci�n());
		conexi�n.getSentencia().setDouble(3, ingrediente.getCosto());
		conexi�n.getSentencia().setInt(4, ingrediente.getNumAlmac�n());
		conexi�n.getSentencia().setInt(5,ingrediente.getCantidad());
		conexi�n.modificacion();
	}

	public void list() throws NoExisteIngrediente, SQLException {
		Ingrediente ingrediente;
		String sql = "select * from ingredientes";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		if(resultSet.next()) {
			while (resultSet.next()) {
				ingrediente = new Ingrediente(resultSet.getInt("codIngrediente"), resultSet.getString("descripci�n"),
						resultSet.getInt("costo"), resultSet.getInt("numAlmac�n"), resultSet.getInt("cantidad"));
				System.out.println(ingrediente);
			}
		} else {
			throw new NoExisteIngrediente();
		}


	}
}
