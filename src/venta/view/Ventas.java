package venta.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexión;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Ventas {

	private Conexión conexión;
	private Scanner scanner;

	public Ventas(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		Venta venta = RegistroVenta.ingresar(scanner);
		String sql = "Insert into Venta (numVenta, fecha, codCliente, codEmpleado) values(?,?,?,?)";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, venta.getNumVenta());
		conexión.getSentencia().setDate(2, new java.sql.Date(venta.getFecha().getTime()));
		conexión.getSentencia().setInt(3, venta.getCodCliente());
		conexión.getSentencia().setInt(4, venta.getCodEmpleado());
		conexión.modificacion();
		String sqlPuntos = "update cliente set puntos = puntos + 10 where codCliente = ?";
		conexión.consulta(sqlPuntos);
		conexión.getSentencia().setInt(1, venta.getCodCliente());
		conexión.modificacion();
	}

	public void update() throws SQLException, NoExisteVenta {
		ResultSet resultSet;
		Venta venta;
		Date fecha;
		int codCliente;
		int codEmpleado;
		int numVenta = InputTypes.readInt("Número de la venta: ", scanner);
		String sql = "select * from venta where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			numVenta = resultSet.getInt("numVenta");	
			fecha = resultSet.getDate("fecha");
			codCliente = resultSet.getInt("codCliente");
			codEmpleado = resultSet.getInt("codEmpleado");
			venta = new Venta(numVenta, fecha, codCliente, codEmpleado);
			System.out.println(venta);
			Menú.menúModificar(scanner, venta);

			sql = "update venta set fecha=?, codCliente = ?, codEmpleado = ?  where numVenta = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setDate(1,new java.sql.Date(venta.getFecha().getTime()));
			conexión.getSentencia().setInt(2, venta.getCodCliente());
			conexión.getSentencia().setInt(3, venta.getCodEmpleado());
			conexión.getSentencia().setInt(4, venta.getNumVenta());
			conexión.modificacion();
		}
		else {
			throw new NoExisteVenta();
		}
	}

	public void list() throws NoExisteVenta, SQLException {
		Venta venta;
		String sql = "select * from venta ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				venta = new Venta(resultSet.getInt("numVenta"), resultSet.getDate("fecha"),
						resultSet.getInt("codCliente"), resultSet.getInt("codEmpleado"));
				System.out.println(venta);
			}
		} else {
			throw new NoExisteVenta();
		}
	}
}