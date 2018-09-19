package venta.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexi�n;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Ventas {

	private Conexi�n conexi�n;
	private Scanner scanner;

	public Ventas(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		Venta venta = RegistroVenta.ingresar(scanner);
		String sql = "Insert into Venta (numVenta, fecha, codCliente, codEmpleado) values(?,?,?,?)";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, venta.getNumVenta());
		conexi�n.getSentencia().setDate(2, new java.sql.Date(venta.getFecha().getTime()));
		conexi�n.getSentencia().setInt(3, venta.getCodCliente());
		conexi�n.getSentencia().setInt(4, venta.getCodEmpleado());
		conexi�n.modificacion();
		String sqlPuntos = "update cliente set puntos = puntos + 10 where codCliente = ?";
		conexi�n.consulta(sqlPuntos);
		conexi�n.getSentencia().setInt(1, venta.getCodCliente());
		conexi�n.modificacion();
	}

	public void update() throws SQLException, NoExisteVenta {
		ResultSet resultSet;
		Venta venta;
		Date fecha;
		int codCliente;
		int codEmpleado;
		int numVenta = InputTypes.readInt("N�mero de la venta: ", scanner);
		String sql = "select * from venta where numVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			numVenta = resultSet.getInt("numVenta");	
			fecha = resultSet.getDate("fecha");
			codCliente = resultSet.getInt("codCliente");
			codEmpleado = resultSet.getInt("codEmpleado");
			venta = new Venta(numVenta, fecha, codCliente, codEmpleado);
			System.out.println(venta);
			Men�.men�Modificar(scanner, venta);

			sql = "update venta set fecha=?, codCliente = ?, codEmpleado = ?  where numVenta = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setDate(1,new java.sql.Date(venta.getFecha().getTime()));
			conexi�n.getSentencia().setInt(2, venta.getCodCliente());
			conexi�n.getSentencia().setInt(3, venta.getCodEmpleado());
			conexi�n.getSentencia().setInt(4, venta.getNumVenta());
			conexi�n.modificacion();
		}
		else {
			throw new NoExisteVenta();
		}
	}

	public void list() throws NoExisteVenta, SQLException {
		Venta venta;
		String sql = "select * from venta ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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