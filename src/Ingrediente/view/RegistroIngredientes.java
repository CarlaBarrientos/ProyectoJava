package Ingrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Ingrediente.entity.Ingrediente;
import Ingrediente.entity.NoExisteIngrediente;
import control.Conexi�n;
import view.InputTypes;
import Ingrediente.view.IngredienteMen�;

public class RegistroIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;
	
	public RegistroIngredientes(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
		
	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingrediente (codIngrediente, descripci�n, costo, numAlmac�n, cantidad) " + "values(?,?,?,?,?)";
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

	public void delete() throws SQLException {
		int codIngrediente = InputTypes.readInt("C�digo del Ingrediente: ", scanner);
		String sql = "delete " + "from ingrediente " + "where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codIngrediente);
		conexi�n.modificacion();
	}
	
	public void update() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripci�n;
		int costo;
		int numAlmac�n;
		int cantidad;
		int codIngrediente = InputTypes.readInt("C�digo del Ingrediente: ", scanner);
		String sql = "select * from ingrediente where c�digo = ?";
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
		IngredienteMen�.men�Modificar(scanner, ingrediente);

		sql = "update ingrediente set nombre = ?, descripci�n = ? where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, ingrediente.getCodIngrediente());
		conexi�n.getSentencia().setString(2, ingrediente.getDescripci�n());
		conexi�n.getSentencia().setDouble(3, ingrediente.getCosto());
		conexi�n.getSentencia().setInt(4, ingrediente.getNumAlmac�n());
		conexi�n.getSentencia().setInt(5,ingrediente.getCantidad());
		conexi�n.modificacion();
	}

	
	public void list() throws SQLException {
		Ingrediente ingrediente;
		String sql = "select * from ingrediente ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			ingrediente = new Ingrediente(resultSet.getInt("c�digo"), resultSet.getString("descripci�n"),
					resultSet.getInt("costo"), resultSet.getInt("numAlmac�n"), resultSet.getInt("cantidad"));
			System.out.println(ingrediente);
		}
	}
	
	public void listIngrediente() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripci�n;
		int costo;
		int numAlmac�n;
		int cantidad;
		int codIngrediente = InputTypes.readInt("C�digo del Ingrediente: ", scanner);
		String sql = "select * from categor�a where c�digo = ?";
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

		}

	}

