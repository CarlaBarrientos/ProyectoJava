package venta.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import control.Conexión;
import empleado.entity.NoExisteEmpleado;
import envio.entity.NoExisteEnvío;
import venta.entity.NoExisteVenta;
import venta.entity.Venta;
import view.InputTypes;

public class Ventas {
	
	private Conexión conexión;
	private Scanner scanner;
	public Ventas(Conexión conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}
	public void add() throws NoExisteCliente, NoExisteEmpleado, NoExisteEnvío, SQLException{
		Venta venta = RegistroVenta.ingresar(scanner);
		String sql = "Insert into Venta (numVenta, fecha, codEnvío, codCliente, codEmpleado) values(?,?,?,?,?)";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, venta.getNumVenta());
			conexión.getSentencia().setDate(2, new java.sql.Date(venta.getFecha().getTime()));
			conexión.getSentencia().setInt(3, venta.getCodEnvío());
			conexión.getSentencia().setInt(4, venta.getCodCliente());
			conexión.getSentencia().setInt(5, venta.getCodEmpleado());
			conexión.modificacion();
	}
	public void delete() throws NoExisteCliente, NoExisteEmpleado, NoExisteEnvío, NoExisteVenta{
		int numVenta = InputTypes.readInt("Número de venta: ", scanner);
		String sql = "delete from venta where numVenta = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, numVenta);
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException, NoExisteVenta, NoExisteCliente, NoExisteEmpleado, NoExisteEnvío {
		ResultSet resultSet;
		Venta venta=null;
		Date fecha;
		int codEnvío;
		int codCliente;
		int codEmpleado;
		int numVenta = InputTypes.readInt("Número de la venta: ", scanner);
		String sql = "select * from venta where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			fecha = resultSet.getDate("fecha");
			codEnvío = resultSet.getInt("codEnvío");
			codCliente = resultSet.getInt("codCliente");
			codEmpleado = resultSet.getInt("codEmpleado");
			numVenta = resultSet.getInt("numVenta");
			venta = new Venta(fecha, codEnvío, codCliente, codEmpleado);
		} else {
			throw new NoExisteVenta();
		}

		System.out.println(venta);
		//Menú.menúModificar(scanner, producto);

		sql = "update venta set fecha=?, codEnvío = ?, codCliente = ?, codEmpleado = ?  where numVenta = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, venta.getNumVenta());
		conexión.getSentencia().setDate(2,new java.sql.Date(venta.getFecha().getTime()));
		conexión.getSentencia().setInt(3, venta.getCodEnvío());
		conexión.getSentencia().setInt(4, venta.getCodCliente());
		conexión.getSentencia().setInt(5, venta.getCodEmpleado());
		conexión.modificacion();
	}
	public void list() throws SQLException {
		Venta venta;
		String sql = "select * from venta ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			venta = new Venta(resultSet.getDate("fecha"), resultSet.getInt("codEnvío"),
					resultSet.getInt("codCliente"), resultSet.getInt("codEmpleado"));
			System.out.println(venta);
		}
	}

}
