package empleado.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import empleado.entity.Empleado;
import empleado.entity.NoExisteEmpleado;
import view.InputTypes;

public class Empleados {

	private Conexi�n conexi�n;
	private Scanner scanner;
	public Empleados(Conexi�n conexi�n, Scanner scanner) {
		super();
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}
	public void add() {
		Empleado empleado = RegistroEmpleado.ingresar(scanner);
		String sql = "Insert into Empleado (codEmpleado, nombre, cI, tel�fono, celular, direcci�n, cargo) values(?,?,?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, empleado.getCodEmpleado());
			conexi�n.getSentencia().setString(2, empleado.getNombre());
			conexi�n.getSentencia().setInt(3, empleado.getcI());
			conexi�n.getSentencia().setInt(4, empleado.getTel�fono());
			conexi�n.getSentencia().setInt(5, empleado.getCelular());
			conexi�n.getSentencia().setString(6, empleado.getDirecci�n());
			conexi�n.getSentencia().setString(7, empleado.getCargo());
			conexi�n.modificacion();
		} catch (SQLException e) {
			//throw new NoExisteCategor�a();
		}

	}
	public void delete() {
		int codEmpleado = InputTypes.readInt("C�digo del empleado: ", scanner);
		String sql = "delete from empleado where codEmpleado = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codEmpleado);
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException, NoExisteEmpleado {
		ResultSet resultSet;
		Empleado empleado=null;
		String nombre;
		int cI;
	    int tel�fono;
		int celular;
		String direcci�n;
		String cargo;
		int codEmpleado = InputTypes.readInt("C�digo del empleado: ", scanner);
		String sql = "select * from empleado where codEmpleado = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codEmpleado);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			cI = resultSet.getInt("CI");
			tel�fono = resultSet.getInt("tel�fono");
			celular = resultSet.getInt("celular");
			direcci�n = resultSet.getString("direcci�n");
			cargo = resultSet.getString("cargo");
			codEmpleado = resultSet.getInt("codEmpleado");
			empleado = new Empleado(codEmpleado, nombre, cI, tel�fono, celular, direcci�n, cargo);
		} else {
			throw new NoExisteEmpleado();
		}

		System.out.println(empleado);
		//Men�.men�Modificar(scanner, producto);

		sql = "update empleado set nombre = ?, CI = ?, tel�fono = ?, celular = ?, direcci�n = ?, cargo = ?  where codEmpleado = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, empleado.getCodEmpleado());
		conexi�n.getSentencia().setString(2, empleado.getNombre());
		conexi�n.getSentencia().setInt(3, empleado.getcI());
		conexi�n.getSentencia().setInt(4, empleado.getTel�fono());
		conexi�n.getSentencia().setInt(5, empleado.getCelular());
		conexi�n.getSentencia().setString(6, empleado.getDirecci�n());
		conexi�n.getSentencia().setString(7, empleado.getCargo());
		conexi�n.modificacion();
	}
	public void list() throws SQLException {
		Empleado empleado;
		String sql = "select * from empleado ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			empleado = new Empleado(resultSet.getInt("codEmpleado"), resultSet.getString("nombre"), resultSet.getInt("CI"),
					resultSet.getInt("tel�fono"), resultSet.getInt("celular"), resultSet.getString("direcci�n"),
					resultSet.getString("cargo"));
			System.out.println(empleado);
		}
	}
}
