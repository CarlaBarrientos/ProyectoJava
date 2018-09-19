package empleado.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import empleado.entity.Empleado;
import empleado.entity.NoExisteEmpleado;
import view.InputTypes;

public class Empleados {

	private Conexión conexión;
	private Scanner scanner;

	public Empleados(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() {
		Empleado empleado = RegistroEmpleado.ingresar(scanner);
		String sql = "Insert into Empleado (codEmpleado, nombre, cI, teléfono, celular, dirección, cargo) values(?,?,?,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, empleado.getCodEmpleado());
			conexión.getSentencia().setString(2, empleado.getNombre());
			conexión.getSentencia().setInt(3, empleado.getcI());
			conexión.getSentencia().setInt(4, empleado.getTeléfono());
			conexión.getSentencia().setInt(5, empleado.getCelular());
			conexión.getSentencia().setString(6, empleado.getDirección());
			conexión.getSentencia().setString(7, empleado.getCargo());
			conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() throws SQLException, NoExisteEmpleado {
		ResultSet resultSet;
		Empleado empleado=null;
		String nombre;
		int cI;
		int teléfono;
		int celular;
		String dirección;
		String cargo;
		int codEmpleado = InputTypes.readInt("Código del empleado: ", scanner);
		String sql = "select * from empleado where codEmpleado = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codEmpleado);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			cI = resultSet.getInt("CI");
			teléfono = resultSet.getInt("teléfono");
			celular = resultSet.getInt("celular");
			dirección = resultSet.getString("dirección");
			cargo = resultSet.getString("cargo");
			codEmpleado = resultSet.getInt("codEmpleado");
			empleado = new Empleado(codEmpleado, nombre, cI, teléfono, celular, dirección, cargo);

			System.out.println(empleado);
			Menú.menúModificar(scanner, empleado);

			sql = "update empleado set nombre = ?, CI = ?, teléfono = ?, celular = ?, dirección = ?, cargo = ?  where codEmpleado = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(7, empleado.getCodEmpleado());
			conexión.getSentencia().setString(1, empleado.getNombre());
			conexión.getSentencia().setInt(2, empleado.getcI());
			conexión.getSentencia().setInt(3, empleado.getTeléfono());
			conexión.getSentencia().setInt(4, empleado.getCelular());
			conexión.getSentencia().setString(5, empleado.getDirección());
			conexión.getSentencia().setString(6, empleado.getCargo());
			conexión.modificacion();

		} else {
			throw new NoExisteEmpleado();
		}
	}
	public void list() throws NoExisteEmpleado, SQLException{
		Empleado empleado;
		String sql = "select * from empleado ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				empleado = new Empleado(resultSet.getInt("codEmpleado"), resultSet.getString("nombre"), resultSet.getInt("CI"),
						resultSet.getInt("teléfono"), resultSet.getInt("celular"), resultSet.getString("dirección"),
						resultSet.getString("cargo"));
				System.out.println(empleado);
			}
		} else {
			throw new NoExisteEmpleado();
		}	
	}
}
