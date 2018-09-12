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
		String sql = "Insert into DetalleVenta (numVenta, codProducto, cantidad) " + "values(?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, detalleVenta.getNumVenta());
			conexión.getSentencia().setInt(2, detalleVenta.getCodProducto());
			conexión.getSentencia().setInt(3, detalleVenta.getCantidad());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void delete() throws SQLException {
		int codVenta = InputTypes.readInt("Código de venta: ", scanner);
		String sql = "delete " + "from detalleVenta " + "where codoVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codVenta);
		conexión.modificacion();
	}
	
	public void update() throws NoExisteDetalleVenta, SQLException {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int numVenta;
		int codProducto;
		int cantidad;
		int codVenta = InputTypes.readInt("Código de venta: ", scanner);
		String sql = "select * from detalleVenta where codVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			numVenta = resultSet.getInt("numVenta");
			codProducto = resultSet.getInt("codProducto");
			cantidad = resultSet.getInt("cantidad");
			detalleVenta = new DetalleVenta(codVenta, numVenta, codProducto, cantidad);
		} else {
			throw new NoExisteDetalleVenta();
		}

		System.out.println(detalleVenta);
		Menú.menúModificar(scanner, detalleVenta);

		sql = "update detalleVenta set numVenta = ?, codProducto = ?, cantidad = ? where codVenta = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalleVenta.getNumVenta());
		conexión.getSentencia().setInt(2, detalleVenta.getCodProducto());
		conexión.getSentencia().setInt(3, detalleVenta.getCantidad());
		conexión.getSentencia().setInt(4, detalleVenta.getCodVenta());
		conexión.modificacion();
	}
}
