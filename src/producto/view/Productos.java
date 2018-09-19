package producto.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
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

	public void add() throws SQLException {
		Producto producto = RegistroProducto.ingresar(scanner);
		String sql = "Insert into Producto (nombre, descripción, precio, codCategoría) values(?,?,?,?)";
		conexión.consulta(sql);
		conexión.getSentencia().setString(1, producto.getNombre());
		conexión.getSentencia().setString(2, producto.getDescripción());
		conexión.getSentencia().setDouble(3, producto.getPrecio());
		conexión.getSentencia().setInt(4, producto.getCodCategoría());
		conexión.modificacion();
	}

	public void update() throws SQLException, NoExisteProducto {
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
		} else {
			throw new NoExisteProducto();
		}
	}

	public void list() throws NoExisteProducto, SQLException {
		Producto producto;
		String sql = "select * from producto";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				producto = new Producto(resultSet.getInt("codProducto"), resultSet.getString("nombre"),
						resultSet.getString("descripción"), resultSet.getDouble("precio"),
						resultSet.getInt("codCategoría"));
				System.out.println(producto);
			} 
		} else {
			throw new NoExisteProducto();
		}
	}
}