package factura.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import factura.entity.Factura;
import venta.entity.NoExisteVenta;
import view.InputTypes;

public class Facturas {
	
	private Conexi�n conexi�n;
	private Scanner scanner;
	public Facturas(Conexi�n conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}
	public void add() throws NoExisteVenta{
		Factura factura = RegistroFactura.ingresar(scanner);
		String sql = "Insert into Factura (numVenta, NIT, nombre, descripci�n) values(?,?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, factura.getNumVenta());
			conexi�n.getSentencia().setInt(2, factura.getNit());
			conexi�n.getSentencia().setString(3, factura.getNombre());
			conexi�n.getSentencia().setString(4, factura.getDescripci�n());
			conexi�n.modificacion();
			} catch (SQLException e) {
				throw new NoExisteVenta();
			}
			
	}
	public void delete() throws  SQLException {
		int numVenta = InputTypes.readInt("N�mero de venta: ", scanner);
		String sql = "delete from factura where numVenta = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, numVenta);
			conexi�n.modificacion();

	}
	
	public void update() throws SQLException, NoExisteVenta {
		ResultSet resultSet;
		Factura factura=null;
		int nit;
		String nombre;
		String descripci�n;
		int numVenta = InputTypes.readInt("N�mero de la venta: ", scanner);
		String sql = "select * from factura where numVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nit = resultSet.getInt("NIT");
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			numVenta = resultSet.getInt("numVenta");
			factura = new Factura(numVenta, nit, nombre, descripci�n);
		} else {
			throw new NoExisteVenta();
		}

		System.out.println(factura);
		Men�.men�Modificar(scanner, factura);

		sql = "update factura set NIT=?, nombre = ?, descripci�n = ?  where numVenta = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(4, factura.getNumVenta());
		conexi�n.getSentencia().setInt(1, factura.getNit());
		conexi�n.getSentencia().setString(2, factura.getNombre());
		conexi�n.getSentencia().setString(3, factura.getDescripci�n());
		conexi�n.modificacion();
	}
	public void list() throws NoExisteVenta {
		Factura factura;
		String sql = "select * from factura ";
		try {
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			factura = new Factura(resultSet.getInt("numVenta"), resultSet.getInt("NIT"), resultSet.getString("nombre"), resultSet.getString("descripci�n"));
			System.out.println(factura);
		}
		} catch (SQLException e) {
			throw new NoExisteVenta();
		}
		
	}

}
