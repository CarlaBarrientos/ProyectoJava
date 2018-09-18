package detalleVenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexión;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import producto.entity.NoExisteProducto;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class DetalleVentas {
	private Conexión conexión;
	private Scanner scanner;

	public DetalleVentas(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() throws NoExisteVenta, SQLException, NoExisteProducto {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sqlProducto = "select codProducto from producto where codProducto = ?";
		conexión.consulta(sqlProducto);
		conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
		ResultSet resultSetProducto = conexión.resultado();

		if (resultSetProducto.next()) {
			String sqlVenta = "select numVenta form venta where numVenta = ?";
			conexión.consulta(sqlVenta);
			conexión.getSentencia().setInt(1, detalleVenta.getNumVenta());
			ResultSet resultSet1 = conexión.resultado();
			if (resultSet1.next()) {
				String sql = "Insert into DetalleVenta (codProducto, cantidad, totalVenta, numVenta) " + "values(?,?,?,?)";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
				conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
				conexión.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
				conexión.getSentencia().setInt(4, detalleVenta.getNumVenta());
				conexión.modificacion();
			} else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteProducto();
		}
	}

	public void delete() throws SQLException, NoExisteDetalleVenta {
		int numVenta = InputTypes.readInt("Código del detalle: ", scanner);
		String sql = "delete from detalleVenta where codDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		conexión.modificacion();
	}

	public void update() throws NoExisteDetalleVenta, SQLException, NoExisteVenta, NoExisteProducto {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int codProducto;
		int cantidad;
		double totalVenta;
		int numVenta;
		int codDetalle = InputTypes.readInt("Código del detalle: ", scanner);
		String sql = "select * from detalleVenta where codDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codDetalle);
		resultSet = conexión.resultado();
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

		Menú.menúModificar(scanner, detalleVenta);

		sql = "update detalleVenta set codProducto = ?, cantidad = ?, totalVenta, numVenta where codDetalle = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
		if (resultSet.next()) {
			conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexión.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
			conexión.getSentencia().setInt(4, detalleVenta.getNumVenta());
			if (resultSet.next()) {
				conexión.getSentencia().setInt(5, detalleVenta.getCodDetalle());
				conexión.modificacion();
			} else {
				throw new NoExisteVenta();
			}
		} else {
			throw new NoExisteProducto();
		}
	}
}