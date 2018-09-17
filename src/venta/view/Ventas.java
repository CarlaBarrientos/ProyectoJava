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
		String sqlEnvío="Select codEnvío from Envío where codEnvío = ?";
		conexión.consulta(sqlEnvío);
		conexión.getSentencia().setInt(1, venta.getCodEnvío());
		ResultSet resultSetEnv = conexión.resultado();
		if(resultSetEnv.next()) {
			String sqlCliente = "Select codCliente from Cliente where codCliente = ?";
			conexión.consulta(sqlCliente);
			conexión.getSentencia().setInt(1, venta.getCodCliente());
			ResultSet resultSetCli = conexión.resultado();
			if(resultSetCli.next()) {
				String sqlEmpleado="Select codEmpleado from Empleado where codEmpleado = ?";
				conexión.consulta(sqlEmpleado);
				conexión.getSentencia().setInt(1, venta.getCodEmpleado());
				ResultSet resultSetEmp = conexión.resultado();		
				if(resultSetEmp.next()){
					String sql = "Insert into Venta (numVenta, fecha, codEnvío, codCliente, codEmpleado) values(?,?,?,?,?)";
					conexión.consulta(sql);
					conexión.getSentencia().setInt(1, venta.getNumVenta());
					conexión.getSentencia().setDate(2, new java.sql.Date(venta.getFecha().getTime()));
					conexión.getSentencia().setInt(3, venta.getCodEnvío());
					conexión.getSentencia().setInt(4, venta.getCodCliente());
					conexión.getSentencia().setInt(5, venta.getCodEmpleado());
					conexión.modificacion();
					String sqlPuntos = "update cliente set puntos = puntos + 10 where codCliente = ?";
					conexión.consulta(sqlPuntos);
					conexión.getSentencia().setInt(1, venta.getCodCliente());
					conexión.modificacion();
				}else {
					throw new NoExisteEmpleado();
				}
			}else {
				throw new NoExisteCliente();
			}
		}else{
			throw new NoExisteEnvío();
		}
	}
	public void delete()throws NoExisteVenta, SQLException{
		int numVenta = InputTypes.readInt("Número de venta: ", scanner);
		String sql ="delete from factura where numVenta = ?" ;
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		ResultSet resultSet=conexión.resultado();
		if(resultSet.next()) {
			String sql1 ="delete from venta where numVenta = ?" ;
			conexión.consulta(sql1);
			conexión.getSentencia().setInt(1, numVenta);
			conexión.modificacion();
		}else {
			throw new NoExisteVenta();
		}
	}

	public void update() throws SQLException, NoExisteVenta, NoExisteCliente, NoExisteEmpleado, NoExisteEnvío {
		ResultSet resultSet;
		Venta venta=null;
		Date fecha;
		int numVenta = InputTypes.readInt("Número de la venta: ", scanner);
		String sql = "select * from venta where numVenta = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, numVenta);
		resultSet = conexión.resultado();
		if (resultSet.next()) {		
			String sqlEnvío="Select codEnvío from Envío where codEnvío=?";
			int codEnvío = InputTypes.readInt("Ingrear el nuevo código de envio: ", scanner);
			conexión.consulta(sqlEnvío);
			conexión.getSentencia().setInt(1, codEnvío);
			ResultSet resultSetEnv = conexión.resultado();
			if(resultSetEnv.next()) {
				String sqlCliente="Select codCliente from Cliente where codCliente=?";
				int codCliente = InputTypes.readInt("Ingresar el nuevo código del clente: ", scanner);
				conexión.consulta(sqlCliente);
				conexión.getSentencia().setInt(1, codCliente);
				ResultSet resultSetCli = conexión.resultado();
				if(resultSetCli.next()) {
					String sqlEmpleado="Select codEmpleado from Empleado where codEmpleado=?";
					int codEmpleado = InputTypes.readInt("Ingresar el nuevo código del empleado: ", scanner);
					conexión.consulta(sqlEmpleado);
					conexión.getSentencia().setInt(1, codEmpleado);
					ResultSet resultSetEmp = conexión.resultado();		
					if(resultSetEmp.next()){
						fecha = resultSet.getDate("fecha");
						codEnvío = resultSet.getInt("codEnvío");
						codCliente = resultSet.getInt("codCliente");
						codEmpleado = resultSet.getInt("codEmpleado");
						numVenta = resultSet.getInt("numVenta");
						venta = new Venta(numVenta, fecha, codEnvío, codCliente, codEmpleado);
						System.out.println(venta);
						Menú.menúModificar(scanner, venta);

						sql = "update venta set fecha=?, codEnvío = ?, codCliente = ?, codEmpleado = ?  where numVenta = ?";

						conexión.consulta(sql);
						conexión.getSentencia().setDate(1,new java.sql.Date(venta.getFecha().getTime()));
						conexión.getSentencia().setInt(2, venta.getCodEnvío());
						conexión.getSentencia().setInt(3, venta.getCodCliente());
						conexión.getSentencia().setInt(4, venta.getCodEmpleado());
						conexión.getSentencia().setInt(5, venta.getNumVenta());
						conexión.modificacion();
					}else {
						throw new NoExisteEmpleado();
					}
				}else {
					throw new NoExisteCliente();
				}
			}else {
				throw new NoExisteEnvío();
			}
		}
		else {
			throw new NoExisteVenta();
		}
	}
	public void list() throws NoExisteVenta {
		Venta venta;
		String sql = "select * from venta ";
		try {
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				venta = new Venta(resultSet.getInt("numVenta"), resultSet.getDate("fecha"), resultSet.getInt("codEnvío"),
						resultSet.getInt("codCliente"), resultSet.getInt("codEmpleado"));
				System.out.println(venta);
			}
		} catch (SQLException e) {
			throw new NoExisteVenta();
		}
	}
}