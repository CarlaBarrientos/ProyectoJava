package Ingrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Ingrediente.entity.Ingrediente;
import Ingrediente.entity.NoExisteIngrediente;
import control.Conexión;
import view.InputTypes;
import Ingrediente.view.IngredienteMenú;

public class RegistroIngredientes {
	private Conexión conexión;
	private Scanner scanner;
	
	public RegistroIngredientes(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
		
	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingrediente (codIngrediente, descripción, costo, numAlmacén, cantidad) " + "values(?,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, ingrediente.getCodIngrediente());
			conexión.getSentencia().setString(2, ingrediente.getDescripción());
			conexión.getSentencia().setDouble(3, ingrediente.getCosto());
			conexión.getSentencia().setInt(4, ingrediente.getNumAlmacén());
			conexión.getSentencia().setInt(5,ingrediente.getCantidad());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void delete() throws SQLException {
		int codIngrediente = InputTypes.readInt("Código del Ingrediente: ", scanner);
		String sql = "delete " + "from ingrediente " + "where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codIngrediente);
		conexión.modificacion();
	}
	
	public void update() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripción;
		int costo;
		int numAlmacén;
		int cantidad;
		int codIngrediente = InputTypes.readInt("Código del Ingrediente: ", scanner);
		String sql = "select * from ingrediente where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codIngrediente);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			descripción = resultSet.getString("descripción");
			costo = resultSet.getInt("costo");
			numAlmacén = resultSet.getInt("numAlmacén");
			cantidad = resultSet.getInt("cantidad");
			ingrediente = new Ingrediente(codIngrediente, descripción, costo, numAlmacén, cantidad);
		} else {
			throw new NoExisteIngrediente();
		}

		System.out.println(ingrediente);
		IngredienteMenú.menúModificar(scanner, ingrediente);

		sql = "update ingrediente set nombre = ?, descripción = ? where código = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, ingrediente.getCodIngrediente());
		conexión.getSentencia().setString(2, ingrediente.getDescripción());
		conexión.getSentencia().setDouble(3, ingrediente.getCosto());
		conexión.getSentencia().setInt(4, ingrediente.getNumAlmacén());
		conexión.getSentencia().setInt(5,ingrediente.getCantidad());
		conexión.modificacion();
	}

	
	public void list() throws SQLException {
		Ingrediente ingrediente;
		String sql = "select * from ingrediente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			ingrediente = new Ingrediente(resultSet.getInt("código"), resultSet.getString("descripción"),
					resultSet.getInt("costo"), resultSet.getInt("numAlmacén"), resultSet.getInt("cantidad"));
			System.out.println(ingrediente);
		}
	}
	
	public void listIngrediente() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripción;
		int costo;
		int numAlmacén;
		int cantidad;
		int codIngrediente = InputTypes.readInt("Código del Ingrediente: ", scanner);
		String sql = "select * from categoría where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codIngrediente);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			descripción = resultSet.getString("descripción");
			costo = resultSet.getInt("costo");
			numAlmacén = resultSet.getInt("numAlmacén");
			cantidad = resultSet.getInt("cantidad");
			ingrediente = new Ingrediente(codIngrediente, descripción, costo, numAlmacén, cantidad);
		} else {
			throw new NoExisteIngrediente();
		}
		System.out.println(ingrediente);

		}

	}

