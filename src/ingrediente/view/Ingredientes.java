package ingrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;

public class Ingredientes {
	private Conexión conexión;
	private Scanner scanner;

	public Ingredientes(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;

	}
	public void add() {
		Ingrediente ingrediente = RegistroIngrediente.Ingresar(scanner);
		String sql = "Insert into Ingredientes (codIngrediente, descripción, costo, numAlmacén, cantidad) values(?,?,?,?,?)";
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

	public void delete() throws NoExisteIngrediente, SQLException {
		int codIngrediente = InputTypes.readInt("Código del Ingrediente: ", scanner);
		String sql = "delete from ingredientes where codIngrediente = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codIngrediente);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			conexión.modificacion(); 
		}else {
			throw new NoExisteIngrediente();
		}
	}

	public void update() throws NoExisteIngrediente, SQLException {
		ResultSet resultSet;
		Ingrediente ingrediente;
		String descripción;
		int costo;
		int numAlmacén;
		int cantidad;
		int codIngrediente = InputTypes.readInt("Código del Ingrediente: ", scanner);
		String sql = "select * from ingredientes where codIngrediente = ?";
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
		Menú.menúModificar(scanner, ingrediente);

		sql = "update ingredientes set descripción = ?, costo = ?, numAlmacén = ? where codIngrediente = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, ingrediente.getCodIngrediente());
		conexión.getSentencia().setString(2, ingrediente.getDescripción());
		conexión.getSentencia().setDouble(3, ingrediente.getCosto());
		conexión.getSentencia().setInt(4, ingrediente.getNumAlmacén());
		conexión.getSentencia().setInt(5,ingrediente.getCantidad());
		conexión.modificacion();
	}

	public void list() throws NoExisteIngrediente, SQLException {
		Ingrediente ingrediente;
		String sql = "select * from ingredientes";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if(resultSet.next()) {
			while (resultSet.next()) {
				ingrediente = new Ingrediente(resultSet.getInt("codIngrediente"), resultSet.getString("descripción"),
						resultSet.getInt("costo"), resultSet.getInt("numAlmacén"), resultSet.getInt("cantidad"));
				System.out.println(ingrediente);
			}
		} else {
			throw new NoExisteIngrediente();
		}


	}
}
