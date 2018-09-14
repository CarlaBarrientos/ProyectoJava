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
	
	public void add() {
		DetalleVenta detalleVenta = RegistroDetalleVenta.ingresar(scanner);
		String sql = "Insert into DetalleVenta (codProducto, cantidad) " + "values(?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
			conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void delete() throws SQLException {
		int numVenta = InputTypes.readInt("N�mero de venta: ", scanner);
		String sql = "delete from detalleVenta where numVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		conexi�n.modificacion();
	}
	
	public void update() throws NoExisteDetalleVenta, SQLException {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int codProducto;
		int cantidad;
		int numVenta = InputTypes.readInt("N�mero de venta: ", scanner);
		String sql = "select * from detalleVenta where numVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("codProducto");
			cantidad = resultSet.getInt("cantidad");
			detalleVenta = new DetalleVenta(numVenta, codProducto, cantidad);
		} else {
			throw new NoExisteDetalleVenta();
		}
		System.out.println(detalleVenta);
		
		Men�.men�Modificar(scanner, detalleVenta);

		sql = "update detalleVenta set codProducto = ?, cantidad = ? where numVenta = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalleVenta.getCodProducto());
		conexi�n.getSentencia().setInt(2, detalleVenta.getCantidad());
		conexi�n.getSentencia().setInt(3, detalleVenta.getNumVenta());
		conexi�n.modificacion();
	}
}
