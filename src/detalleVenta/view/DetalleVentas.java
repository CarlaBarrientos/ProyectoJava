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
	
	public void add() {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sql = "Insert into DetalleVenta (codProducto, cantidad) " + "values(?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
			conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void delete() throws SQLException {
		int numVenta = InputTypes.readInt("Número de venta: ", scanner);
		String sql = "delete from detalleVenta where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		conexión.modificacion();
	}
	
	public void update() throws NoExisteDetalleVenta, SQLException {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int codProducto;
		int cantidad;
		int numVenta = InputTypes.readInt("Número de venta: ", scanner);
		String sql = "select * from detalleVenta where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("codProducto");
			cantidad = resultSet.getInt("cantidad");
			detalleVenta = new DetalleVenta(numVenta, codProducto, cantidad);
		} else {
			throw new NoExisteDetalleVenta();
		}
		System.out.println(detalleVenta);
		
		Menú.menúModificar(scanner, detalleVenta);

		sql = "update detalleVenta set codProducto = ?, cantidad = ? where numVenta = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalleVenta.getCodProducto());
		conexión.getSentencia().setInt(2, detalleVenta.getCantidad());
		conexión.getSentencia().setInt(3, detalleVenta.getNumVenta());
		conexión.modificacion();
	}
}
