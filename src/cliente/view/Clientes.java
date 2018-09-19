package cliente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.entity.NoExisteCliente;
import control.Conexión;
import view.InputTypes;

public class Clientes {

	private Conexión conexión;
	private Scanner scanner;

	public Clientes(Conexión conexión, Scanner scanner) {
		super();
		this.conexión = conexión;
		this.scanner = scanner;
	}
	public void add() {
		Cliente cliente = RegistroCliente.ingresar(scanner);
		String sql = "Insert into Cliente (codCliente, nombre, cI, teléfono, celular, dirección, puntos) values(?,?,?,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, cliente.getCodCliente());
			conexión.getSentencia().setString(2, cliente.getNombre());
			conexión.getSentencia().setInt(3, cliente.getCI());
			conexión.getSentencia().setInt(4, cliente.getTeléfono());
			conexión.getSentencia().setInt(5, cliente.getCelular());
			conexión.getSentencia().setString(6, cliente.getDirección());
			conexión.getSentencia().setInt(7, cliente.getPuntos());
			conexión.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() throws SQLException, NoExisteCliente {
		ResultSet resultSet;
		Cliente cliente;
		String nombre;
		int cI;
		int teléfono;
		int celular;
		String dirección;
		int puntos;
		int codCliente = InputTypes.readInt("Código del cliente: ", scanner);
		String sql = "select * from cliente where codCliente = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCliente);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			cI = resultSet.getInt("CI");
			teléfono = resultSet.getInt("teléfono");
			celular = resultSet.getInt("celular");
			dirección = resultSet.getString("dirección");
			puntos = resultSet.getInt("puntos");
			codCliente = resultSet.getInt("codCliente");
			cliente = new Cliente(codCliente, nombre, cI, teléfono, celular, dirección, puntos);
		} else {
			throw new NoExisteCliente();
		}

		System.out.println(cliente);
		Menú.menúModificar(scanner, cliente);

		sql = "update cliente set nombre = ?, CI = ?, teléfono = ?, celular = ?, dirección = ?, puntos = ?  where codCliente = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(7, cliente.getCodCliente());
		conexión.getSentencia().setString(1, cliente.getNombre());
		conexión.getSentencia().setInt(2, cliente.getCI());
		conexión.getSentencia().setInt(3, cliente.getTeléfono());
		conexión.getSentencia().setInt(4, cliente.getCelular());
		conexión.getSentencia().setString(5, cliente.getDirección());
		conexión.getSentencia().setInt(6, cliente.getPuntos());
		conexión.modificacion();
	}
	public void list() throws NoExisteCliente, SQLException{
		Cliente cliente;
		String sql = "select * from cliente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt("codCliente"), resultSet.getString("nombre"), resultSet.getInt("CI"),
						resultSet.getInt("teléfono"), resultSet.getInt("celular"), resultSet.getString("dirección"),
						resultSet.getInt("puntos"));
				System.out.println(cliente);
			}
		} else {
			throw new NoExisteCliente();
		}	
	}
	
	public void ganador () throws SQLException, NoExisteCliente {
		ArrayList<Cliente> sorteados = new ArrayList<Cliente>();
		Cliente cliente;
		String sql = "select * from cliente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt("codCliente"), resultSet.getString("nombre"), resultSet.getInt("CI"),
						resultSet.getInt("teléfono"), resultSet.getInt("celular"), resultSet.getString("dirección"),
						resultSet.getInt("puntos"));
				for (int i = 0; i < resultSet.getInt("puntos"); i++) {
					sorteados.add(cliente);
				}
			}
			int ganador = (int)(Math.random() * sorteados.size()) + 1;
			System.out.println();
			System.out.println("El ganador es: " + sorteados.get(ganador).getNombre());
			System.out.println(sorteados.get(ganador));
		} else {
			throw new NoExisteCliente();
		}
	}
}
