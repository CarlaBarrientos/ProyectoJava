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
		String sql = "Insert into DetalleVenta (numVenta, codProducto, cantidad) " + "values(?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, detalleVenta.getNumVenta());
			conexi�n.getSentencia().setInt(2, detalleVenta.getCodProducto());
			conexi�n.getSentencia().setInt(3, detalleVenta.getCantidad());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void delete() throws SQLException {
		int codVenta = InputTypes.readInt("C�digo de venta: ", scanner);
		String sql = "delete " + "from detalleVenta " + "where codoVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codVenta);
		conexi�n.modificacion();
	}
	
	public void update() throws NoExisteDetalleVenta, SQLException {
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int numVenta;
		int codProducto;
		int cantidad;
		int codVenta = InputTypes.readInt("C�digo de venta: ", scanner);
		String sql = "select * from detalleVenta where codVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codVenta);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			numVenta = resultSet.getInt("numVenta");
			codProducto = resultSet.getInt("codProducto");
			cantidad = resultSet.getInt("cantidad");
			detalleVenta = new DetalleVenta(codVenta, numVenta, codProducto, cantidad);
		} else {
			throw new NoExisteDetalleVenta();
		}

		System.out.println(detalleVenta);
		Men�.men�Modificar(scanner, detalleVenta);

		sql = "update detalleVenta set numVenta = ?, codProducto = ?, cantidad = ? where codVenta = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalleVenta.getNumVenta());
		conexi�n.getSentencia().setInt(2, detalleVenta.getCodProducto());
		conexi�n.getSentencia().setInt(3, detalleVenta.getCantidad());
		conexi�n.getSentencia().setInt(4, detalleVenta.getCodVenta());
		conexi�n.modificacion();
	}
}
