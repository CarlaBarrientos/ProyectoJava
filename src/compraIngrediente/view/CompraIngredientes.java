package compraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexión;
import view.InputTypes;

public class CompraIngredientes {
	private Conexión conexión;
	private Scanner scanner;

	public CompraIngredientes(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
		String sql = "Insert into compraingrediente (codCompraIng, proveedor, codEmpleado, nombre) " + "values(?,?,?,?)";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexión.getSentencia().setString(2, compraIngrediente.getProveedor());
		conexión.getSentencia().setInt(3, compraIngrediente.getCodEmpleado());
		conexión.getSentencia().setString(4, compraIngrediente.getNombre());
		conexión.modificacion();
	}

	public void update() throws NoExisteCompraIngrediente, SQLException {
		ResultSet resultSet;
		CompraIngrediente compraIngrediente;
		int codEmpleado;
		String proveedor;
		String nombre;
		int codCompraIngrediente = InputTypes.readInt("Código de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codEmpleado = resultSet.getInt("codEmpleado");
			proveedor = resultSet.getString("proveedor");
			nombre = resultSet.getString("nombre");
			compraIngrediente = new CompraIngrediente(codCompraIngrediente, proveedor, codEmpleado, nombre);

			System.out.println(compraIngrediente);
			Menú.menúModificar(scanner, compraIngrediente);

			sql = "update compraingrediente set proveedor = ?, codEmpleado = ?, nombre = ? where codCompraIng = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setString(1, compraIngrediente.getProveedor());
			conexión.getSentencia().setInt(2, compraIngrediente.getCodEmpleado());
			conexión.getSentencia().setString(3, compraIngrediente.getProveedor());
			conexión.getSentencia().setInt(4, compraIngrediente.getCodCompraIngrediente());
			conexión.modificacion();
		} else {
			throw new NoExisteCompraIngrediente();
		}
	}

	public void list() throws NoExisteCompraIngrediente, SQLException {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				compraIngrediente = new CompraIngrediente(resultSet.getInt("codCompraIng"), resultSet.getString("Proveedor"),
						resultSet.getInt("codEmpleado"), resultSet.getString("nombre"));
				System.out.println(compraIngrediente);
			}
		} else {
			throw new NoExisteCompraIngrediente();
		}
	}
}