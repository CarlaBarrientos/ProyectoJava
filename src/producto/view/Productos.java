package producto.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import categoría.entity.NoExisteCategoría;
import control.Conexión;
import producto.entity.NoExisteProducto;
import producto.entity.Producto;
import view.InputTypes;

public class Productos {
	private Conexión conexión;
	private Scanner scanner;

	public Productos(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() throws NoExisteCategoría {
		Producto producto = RegistroProducto.ingresar(scanner);
		String sql = "Insert into Producto (nombre, descripción, precio, codCategoría) values(?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, producto.getNombre());
			conexión.getSentencia().setString(2, producto.getDescripción());
			conexión.getSentencia().setDouble(3, producto.getPrecio());
			conexión.getSentencia().setInt(4, producto.getCodCategoría());
			conexión.modificacion();
		} catch (SQLException e) {
			throw new NoExisteCategoría();
		}
	}

	public void delete() {
		int codProducto = InputTypes.readInt("Código de producto: ", scanner);
		String sql = "delete from producto where codProducto = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codProducto);
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	// aun se puede cambiar de categoría a una que no existe y un problema con el manejo de errores

	public void update() throws NoExisteCategoría, SQLException, NoExisteProducto {
		ResultSet resultSet;
		Producto producto;
		String nombre;
		String descripción;
		double precio;
		int códigoCategoría;
		int código;
		int codProducto = InputTypes.readInt("Código del producto: ", scanner);
		String sql = "select * from producto where codProducto = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codProducto);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			precio = resultSet.getDouble("precio");
			códigoCategoría = resultSet.getInt("codCategoría");
			código = resultSet.getInt("codProducto");
			producto = new Producto(código, nombre, descripción, precio, códigoCategoría);
		} else {
			throw new NoExisteProducto();
		}

		System.out.println(producto);
		Menú.menúModificar(scanner, producto);

		sql = "update producto set nombre = ?, descripción = ?, precio = ?, codCategoría = ? where codProducto = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, producto.getNombre());
		conexión.getSentencia().setString(2, producto.getDescripción());
		conexión.getSentencia().setDouble(3, producto.getPrecio());
		conexión.getSentencia().setInt(4, producto.getCodCategoría());
		conexión.getSentencia().setInt(5, producto.getCodProducto());
		conexión.modificacion();
	}

	public void list() throws SQLException {
		Producto producto;
		String sql = "select * from producto";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			producto = new Producto(resultSet.getInt("codProducto"), resultSet.getString("nombre"),
					resultSet.getString("descripción"), resultSet.getDouble("precio"),
					resultSet.getInt("codCategoría"));
			System.out.println(producto);
		}
	}
}
