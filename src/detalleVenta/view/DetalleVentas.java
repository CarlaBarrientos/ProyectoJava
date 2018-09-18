package detalleVenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexi�n;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import producto.entity.NoExisteProducto;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class DetalleVentas {
	private Conexi�n conexi�n;
	private Scanner scanner;

	public DetalleVentas(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void add() throws NoExisteVenta, SQLException, NoExisteProducto {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sqlProducto = "select codProducto from producto where codProducto = ?";
		conexi�n.consulta(sqlProducto);
		conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
		ResultSet resultSetProducto = conexi�n.resultado();

		if (resultSetProducto.next()) {
			String sqlVenta = "select numVenta form venta where numVenta = ?";
			conexi�n.consulta(sqlVenta);
			conexi�n.getSentencia().setInt(1, detalleVenta.getNumVenta());
			ResultSet resultSet1 = conexi�n.resultado();
			if (resultSet1.next()) {
				String sql = "Insert into DetalleVenta (codProducto, cantidad, totalVenta, numVenta) " + "values(?,?,?,?)";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
				conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
				conexi�n.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
				conexi�n.getSentencia().setInt(4, detalleVenta.getNumVenta());
				conexi�n.modificacion();
			} else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteProducto();
		}
	}

	public void delete() throws SQLException, NoExisteDetalleVenta {
		int numVenta = InputTypes.readInt("C�digo del detalle: ", scanner);
		String sql = "delete from detalleVenta where codDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		conexi�n.modificacion();
	}

	public void update() throws NoExisteDetalleVenta, SQLException, NoExisteVenta, NoExisteProducto {
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
		} else {
			throw new NoExisteDetalleVenta();
		}
		System.out.println(detalleVenta);

		Men�.men�Modificar(scanner, detalleVenta);

		sql = "update detalleVenta set codProducto = ?, cantidad = ?, totalVenta, numVenta where codDetalle = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
		if (resultSet.next()) {
			conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexi�n.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
			conexi�n.getSentencia().setInt(4, detalleVenta.getNumVenta());
			if (resultSet.next()) {
				conexi�n.getSentencia().setInt(5, detalleVenta.getCodDetalle());
				conexi�n.modificacion();
			} else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteProducto();
		}
	}
}