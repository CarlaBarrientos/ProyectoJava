package categoría.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;
import control.Conexión;
import producto.entity.Producto;
import view.InputTypes;

public class Categorías {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor
	 * 
	 * @param productos *
	 ****************************/

	public Categorías(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar categorías *
	 ****************************/

	public void add() {
		Categoría categoría = RegistroCategoría.ingresar(scanner);
		String sql = "Insert into Categoría (nombre, descripción) " + "values(?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, categoría.getNombre());
			conexión.getSentencia().setString(2, categoría.getDescripción());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar categorías
	 * 
	 * @throws SQLException
	 * 
	 * @throws NoExisteCategoría *
	 ****************************/

	public void delete() throws SQLException {
		int codCategoría = InputTypes.readInt("Código de categoría: ", scanner);
		String sql = "delete from categoría where coCatgoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		conexión.modificacion();
	}

	/****************************
	 * Modificar categorías
	 * 
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteCategoría, SQLException {
		ResultSet resultSet;
		Categoría categoría;
		String nombre;
		String descripción;
		int codCategoría = InputTypes.readInt("Código de categoría: ", scanner);
		String sql = "select * from categoría where codCategoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			categoría = new Categoría(codCategoría, nombre, descripción);
		} else {
			throw new NoExisteCategoría();
		}

		System.out.println(categoría);
		Menú.menúModificar(scanner, categoría);

		sql = "update categoría set nombre = ?, descripción = ? where codCategoría = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, categoría.getNombre());
		conexión.getSentencia().setString(2, categoría.getDescripción());
		conexión.getSentencia().setInt(3, categoría.getCodCategoría());
		conexión.modificacion();
	}

	/****************************
	 * Listar categorías
	 * 
	 ****************************/

	public void list() throws SQLException {
		Categoría categoría;
		String sql = "select * from categoría ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			categoría = new Categoría(resultSet.getInt("código"), resultSet.getString("nombre"),
					resultSet.getString("descripción"));
			System.out.println(categoría);
		}
	}

	/****************************
	 * Listar categorías .
	 * 
	 * @throws NoExisteCategoría
	 * @throws SQLException *
	 ****************************/

	public void listProducts() throws NoExisteCategoría, SQLException {
		ResultSet resultSet;
		Categoría categoría;
		String nombre;
		String descripción;
		int codCategoría = InputTypes.readInt("Código de categoría: ", scanner);
		String sql = "select * from categoría where codCategoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			categoría = new Categoría(codCategoría, nombre, descripción);
		} else {
			throw new NoExisteCategoría();
		}
		System.out.println(categoría);

		Producto producto;
		Double precio;
		int codProducto;
		int codIngrediente;

		sql = "select * from producto where codCategoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("codProducto");
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			precio = resultSet.getDouble("precio");
			codIngrediente = resultSet.getInt("codIngrediente");
			producto = new Producto(codProducto, nombre, descripción, precio, codCategoría, codIngrediente);
			System.out.println(producto);
		} else {
			throw new NoExisteCategoría();
		}

	}

}
