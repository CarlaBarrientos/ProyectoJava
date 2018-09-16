package categoría.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;
import control.Conexión;
import producto.entity.NoExisteProducto;
import producto.entity.Producto;
import view.InputTypes;

public class Categorías {
	private Conexión conexión;
	private Scanner scanner;

	public Categorías(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

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

	public void delete() throws NoExisteCategoría, SQLException {
		System.out.println("Se eliminaran tambien todos los productos pertenecientes a la categoría");
		int codCategoría = InputTypes.readInt("Código de categoría: ", scanner);
		String sql1 = "delete from producto where codCategoría = ?";
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, codCategoría);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			String sql2 = "delete from categoría where codCategoría = ?";
			conexión.consulta(sql2);
			conexión.getSentencia().setInt(1, codCategoría);
			conexión.modificacion();
		} else {
			throw new NoExisteCategoría();
		}
	}

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

	public void list() throws SQLException {
		Categoría categoría;
		String sql = "select * from categoría ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			categoría = new Categoría(resultSet.getInt("codCategoría"), resultSet.getString("nombre"),
					resultSet.getString("descripción"));
			System.out.println(categoría);
		}
	}

	public void listProducts() throws NoExisteCategoría, SQLException, NoExisteProducto {
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
		double precio;
		int codProducto;

		sql = "select * from producto where codCategoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			while (resultSet.next()) {
				codProducto = resultSet.getInt("codProducto");
				nombre = resultSet.getString("nombre");
				descripción = resultSet.getString("descripción");
				precio = resultSet.getDouble("precio");
				producto = new Producto(codProducto, nombre, descripción, precio, codCategoría);
				System.out.println(producto);
			}
		} else {
			throw new NoExisteProducto();
		}
	}
}
