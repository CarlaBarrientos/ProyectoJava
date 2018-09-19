package compraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexi�n;
import view.InputTypes;

public class CompraIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;

	public CompraIngredientes(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public void add() throws SQLException {
		CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
		String sql = "Insert into compraingrediente (codCompraIng, proveedor, codEmpleado, nombre) " + "values(?,?,?,?)";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexi�n.getSentencia().setString(2, compraIngrediente.getProveedor());
		conexi�n.getSentencia().setInt(3, compraIngrediente.getCodEmpleado());
		conexi�n.getSentencia().setString(4, compraIngrediente.getNombre());
		conexi�n.modificacion();
	}

	public void update() throws NoExisteCompraIngrediente, SQLException {
		ResultSet resultSet;
		CompraIngrediente compraIngrediente;
		int codEmpleado;
		String proveedor;
		String nombre;
		int codCompraIngrediente = InputTypes.readInt("C�digo de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codEmpleado = resultSet.getInt("codEmpleado");
			proveedor = resultSet.getString("proveedor");
			nombre = resultSet.getString("nombre");
			compraIngrediente = new CompraIngrediente(codCompraIngrediente, proveedor, codEmpleado, nombre);

			System.out.println(compraIngrediente);
			Men�.men�Modificar(scanner, compraIngrediente);

			sql = "update compraingrediente set proveedor = ?, codEmpleado = ?, nombre = ? where codCompraIng = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, compraIngrediente.getProveedor());
			conexi�n.getSentencia().setInt(2, compraIngrediente.getCodEmpleado());
			conexi�n.getSentencia().setString(3, compraIngrediente.getProveedor());
			conexi�n.getSentencia().setInt(4, compraIngrediente.getCodCompraIngrediente());
			conexi�n.modificacion();
		} else {
			throw new NoExisteCompraIngrediente();
		}
	}

	public void list() throws NoExisteCompraIngrediente, SQLException {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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