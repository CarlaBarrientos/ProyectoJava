package venta.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import control.Conexi�n;
import empleado.entity.NoExisteEmpleado;
import envio.entity.NoExisteEnv�o;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Ventas {
	
	private Conexi�n conexi�n;
	private Scanner scanner;
	public Ventas(Conexi�n conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}
	public void add() throws NoExisteCliente, NoExisteEmpleado, NoExisteEnv�o, SQLException{
		Venta venta = RegistroVenta.ingresar(scanner);
		String sql = "Insert into Venta (numVenta, fecha, codEnv�o, codCliente, codEmpleado) values(?,?,?,?,?)";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, venta.getNumVenta());
			conexi�n.getSentencia().setDate(2, new java.sql.Date(venta.getFecha().getTime()));
			conexi�n.getSentencia().setInt(3, venta.getCodEnv�o());
			conexi�n.getSentencia().setInt(4, venta.getCodCliente());
			conexi�n.getSentencia().setInt(5, venta.getCodEmpleado());
			conexi�n.modificacion();
	}
	public void delete() throws NoExisteCliente, NoExisteEmpleado, NoExisteEnv�o, NoExisteVenta{
		int numVenta = InputTypes.readInt("N�mero de venta: ", scanner);
		String sql = "delete from venta where numVenta = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, numVenta);
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException, NoExisteVenta, NoExisteCliente, NoExisteEmpleado, NoExisteEnv�o {
		ResultSet resultSet;
		Venta venta=null;
		Date fecha;
		int codEnv�o;
		int codCliente;
		int codEmpleado;
		int numVenta = InputTypes.readInt("N�mero de la venta: ", scanner);
		String sql = "select * from venta where numVenta = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, numVenta);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			fecha = resultSet.getDate("fecha");
			codEnv�o = resultSet.getInt("codEnv�o");
			codCliente = resultSet.getInt("codCliente");
			codEmpleado = resultSet.getInt("codEmpleado");
			numVenta = resultSet.getInt("numVenta");
			venta = new Venta(fecha, codEnv�o, codCliente, codEmpleado);
		} else {
			throw new NoExisteVenta();
		}

		System.out.println(venta);
		//Men�.men�Modificar(scanner, producto);

		sql = "update venta set fecha=?, codEnv�o = ?, codCliente = ?, codEmpleado = ?  where numVenta = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, venta.getNumVenta());
		conexi�n.getSentencia().setDate(2,new java.sql.Date(venta.getFecha().getTime()));
		conexi�n.getSentencia().setInt(3, venta.getCodEnv�o());
		conexi�n.getSentencia().setInt(4, venta.getCodCliente());
		conexi�n.getSentencia().setInt(5, venta.getCodEmpleado());
		conexi�n.modificacion();
	}
	public void list() throws SQLException {
		Venta venta;
		String sql = "select * from venta ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			venta = new Venta(resultSet.getDate("fecha"), resultSet.getInt("codEnv�o"),
					resultSet.getInt("codCliente"), resultSet.getInt("codEmpleado"));
			System.out.println(venta);
		}
	}

}
