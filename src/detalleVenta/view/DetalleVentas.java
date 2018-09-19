package detalleVenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexi�n;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import view.InputTypes;

public class DetalleVentas {
	private Conexi�n conexi�n;
	private Scanner scanner;

	public DetalleVentas(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sql = "Insert into DetalleVenta (codProducto, cantidad, totalVenta, numVenta) " + "values(?,?,?,?)";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
		conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
		conexi�n.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
		conexi�n.getSentencia().setInt(4, detalleVenta.getNumVenta());
		conexi�n.modificacion();
	}

	public void delete() throws SQLException, NoExisteDetalleVenta {
		int numVenta = InputTypes.readInt("C�digo del detalle de venta: ", scanner);
		String sql1 = "select * from detalleVenta where codDetalle = ?";
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, numVenta);
		ResultSet resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			String sql = "delete from detalleVenta where codDetalle = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, numVenta);
			conexi�n.modificacion();
		} else {
			throw new NoExisteDetalleVenta();
		}
	}

	public void update() throws SQLException, NoExisteDetalleVenta {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int codProducto;
		int cantidad;
		double totalVenta;
		int numVenta;
		int codDetalle = InputTypes.readInt("C�digo del detalle: ", scanner);
		String sql = "select * from detalleVenta where codDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codDetalle);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("codProducto");
			cantidad = resultSet.getInt("cantidad");
			totalVenta = resultSet.getDouble("totalVenta");
			numVenta = resultSet.getInt("numVenta");
			detalleVenta = new DetalleVenta(codDetalle, codProducto, cantidad, totalVenta, numVenta);

			System.out.println(detalleVenta);
			Men�.men�Modificar(scanner, detalleVenta);

			sql = "update detalleVenta set codProducto = ?, cantidad = ?, totalVenta, numVenta where codDetalle = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
			conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexi�n.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
			conexi�n.getSentencia().setInt(4, detalleVenta.getNumVenta());
			conexi�n.getSentencia().setInt(5, detalleVenta.getCodDetalle());
			conexi�n.modificacion();
		} else {
			throw new NoExisteDetalleVenta();
		}
	}

	public void list () throws SQLException, NoExisteDetalleVenta {
		DetalleVenta detalleVenta;
		String sql = "select * from detalleVenta";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				detalleVenta = new DetalleVenta(resultSet.getInt("codDetalle"), resultSet.getInt("codProducto"),
						resultSet.getInt("cantidad"), resultSet.getInt("totalVenta"), resultSet.getInt("numVenta"));
				System.out.println(detalleVenta);
			}
		} else {
			throw new NoExisteDetalleVenta();
		}
	}
}