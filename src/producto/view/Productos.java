package producto.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import categor�a.entity.Categor�a;
import categor�a.entity.NoExisteCategor�a;
import control.Conexi�n;
import producto.entity.NoExisteProducto;
import producto.entity.Producto;
import view.InputTypes;

public class Productos {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public Productos(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add() throws NoExisteCategor�a {
		Producto producto = RegistroProducto.ingresar(scanner);
		String sql = "Insert into Producto (nombre, descripci�n, precio, c�digoCategor�a, codIngrediente) values(?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, producto.getNombre());
			conexi�n.getSentencia().setString(2, producto.getDescripci�n());
			conexi�n.getSentencia().setDouble(3, producto.getPrecio());
			conexi�n.getSentencia().setInt(4, producto.getCodCategor�a());
			conexi�n.getSentencia().setInt(5, producto.getCodIngrediente());
			conexi�n.modificacion();
		} catch (SQLException e) {
			throw new NoExisteCategor�a();
		}

	}

	/****************************
	 * Eliminar productos *
	 ****************************/

	public void delete() {
		int codProducto = InputTypes.readInt("C�digo de producto: ", scanner);
		String sql = "delete from producto where c�digo = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codProducto);
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Modificar categor�as
	 * 
	 * @throws SQLException
	 * @throws NoExisteProducto *
	 ****************************/

	public void update() throws NoExisteCategor�a, SQLException, NoExisteProducto {
		ResultSet resultSet;
		Producto producto;
		String nombre;
		double precio;
		String descripci�n;
		int c�digoCategor�a;
		int c�digoIngrediente;
		int c�digo;
		int codProducto = InputTypes.readInt("C�digo de producto: ", scanner);
		String sql = "select * from producto where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codProducto);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			precio = resultSet.getDouble("precio");
			c�digoCategor�a = resultSet.getInt("c�digoCategor�a");
			c�digoIngrediente = resultSet.getInt("c�digoIngredeinte");
			c�digo = resultSet.getInt("c�digo");
			producto = new Producto(c�digo, nombre, descripci�n, precio, c�digoCategor�a, c�digoIngrediente);
		} else {
			throw new NoExisteProducto();
		}

		System.out.println(producto);
		Men�.men�Modificar(scanner, producto);

		sql = "update producto set nombre = ?, descripci�n = ?, precio = ?, c�digoCategor�a = ?, c�digoIngrediente = ?  where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, producto.getNombre());
		conexi�n.getSentencia().setString(2, producto.getDescripci�n());
		conexi�n.getSentencia().setDouble(3, producto.getPrecio());
		conexi�n.getSentencia().setInt(4, producto.getCodCategor�a());
		conexi�n.getSentencia().setInt(5, producto.getCodIngrediente());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar productos 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Producto producto;
		String sql = "select * from producto ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			producto = new Producto(resultSet.getInt("c�digo"), resultSet.getString("nombre"),
					resultSet.getString("descripci�n"), resultSet.getDouble("precio"),
					resultSet.getInt("C�digoCategor�a"), resultSet.getInt("C�digoIngrediente"));
			System.out.println(producto);
		}
	}

	public void listCatogories() throws NoExisteProducto, SQLException, NoExisteCategor�a {
		ResultSet resultSet;
		Producto producto;
		String nombre;
		String descripci�n;
		Double precio;
		int c�digoCategor�a;
		int c�digoIngrediente;
		int c�digo = InputTypes.readInt("C�digo de producto: ", scanner);
		String sql = "select * from producto where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, c�digo);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			precio = resultSet.getDouble("precio");
			c�digoCategor�a = resultSet.getInt("c�digoCategor�a");
			c�digoIngrediente = resultSet.getInt("c�digoIngrediente");
			producto = new Producto(c�digo,nombre, descripci�n, precio, c�digoCategor�a, c�digoIngrediente);
		} else {
			throw new NoExisteProducto();
		}
		System.out.println(producto);

		Categor�a categor�a;

		sql = "select * from categor�a where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, c�digoCategor�a);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			c�digo = resultSet.getInt("c�digo");
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			categor�a = new Categor�a(c�digo, nombre, descripci�n);
			System.out.println(categor�a);
		} else {
			throw new NoExisteCategor�a();
		}

	}
}
