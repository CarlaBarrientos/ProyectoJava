package detalleVenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexión;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import view.InputTypes;

public class DetalleVentas {
	private Conexión conexión;
	private Scanner scanner;

	public DetalleVentas(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sql = "Insert into DetalleVenta (codProducto, cantidad, totalVenta, numVenta) " + "values(?,?,?,?)";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
		conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
		conexión.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
		conexión.getSentencia().setInt(4, detalleVenta.getNumVenta());
		conexión.modificacion();
	}

	public void delete() throws SQLException, NoExisteDetalleVenta {
		int numVenta = InputTypes.readInt("Código del detalle de venta: ", scanner);
		String sql1 = "select * from detalleVenta where codDetalle = ?";
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, numVenta);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			String sql = "delete from detalleVenta where codDetalle = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, numVenta);
			conexión.modificacion();
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

			System.out.println(detalleVenta);
			Menú.menúModificar(scanner, detalleVenta);

			sql = "update detalleVenta set codProducto = ?, cantidad = ?, totalVenta, numVenta where codDetalle = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
			conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexión.getSentencia().setDouble(3, detalleVenta.getTotalVenta());
			conexión.getSentencia().setInt(4, detalleVenta.getNumVenta());
			conexión.getSentencia().setInt(5, detalleVenta.getCodDetalle());
			conexión.modificacion();
		} else {
			throw new NoExisteDetalleVenta();
		}
	}

	public void list () throws SQLException, NoExisteDetalleVenta {
		DetalleVenta detalleVenta;
		String sql = "select * from detalleVenta";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
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