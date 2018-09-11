package factura.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import factura.entity.Factura;
import view.InputTypes;

public class Facturas {
	
	private Conexión conexión;
	private Scanner scanner;
	public Facturas(Conexión conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}
	public void add() {
		Factura factura = RegistroFactura.ingresar(scanner);
		String sql = "Insert into Factura (numVenta, NIT, nombre, descripción) values(?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, factura.getNumVenta());
			conexión.getSentencia().setInt(2, factura.getNit());
			conexión.getSentencia().setString(3, factura.getNombre());
			conexión.getSentencia().setString(4, factura.getDescripción());
			conexión.modificacion();
		} catch (SQLException e) {
			//throw new NoExisteCategoría();
		}

	}
	public void delete() {
		int numVenta = InputTypes.readInt("Número de venta: ", scanner);
		String sql = "delete from factura where numVenta = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, numVenta);
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException {
		ResultSet resultSet;
		Factura factura=null;
		int nit;
		String nombre;
		String descripción;
		int numVenta = InputTypes.readInt("Número de la venta: ", scanner);
		String sql = "select * from factura where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nit = resultSet.getInt("NIT");
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			numVenta = resultSet.getInt("numVenta");
			factura = new Factura(numVenta, nit, nombre, descripción);
		} else {
			//throw new NoExisteProducto();
		}

		System.out.println(factura);
		//Menú.menúModificar(scanner, producto);

		sql = "update factura set NIT=?, nombre = ?, descripción = ?  where numVenta = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, factura.getNumVenta());
		conexión.getSentencia().setInt(2, factura.getNit());
		conexión.getSentencia().setString(3, factura.getNombre());
		conexión.getSentencia().setString(4, factura.getDescripción());
		conexión.modificacion();
	}
	public void list() throws SQLException {
		Factura factura;
		String sql = "select * from factura ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			factura = new Factura(resultSet.getInt("numVenta"), resultSet.getInt("NIT"), resultSet.getString("nombre"), resultSet.getString("descripción"));
			System.out.println(factura);
		}
	}

}
