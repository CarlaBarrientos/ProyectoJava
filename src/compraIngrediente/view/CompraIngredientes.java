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
  public void add() throws NoExisteCompraIngrediente {
	  CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
	  String sql = "Insert into compraingrediente (codCompraIng, nombre, cantidad, factura, provedor) " + "values(?,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
			conexión.getSentencia().setString(2, compraIngrediente.getProveedor());
			conexión.getSentencia().setInt(3, compraIngrediente.getCodEmpleado());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		  throw new NoExisteCompraIngrediente();
		}
  }
  
  
  public void delete() throws SQLException {
		int codCompraIngrediente = InputTypes.readInt("Código de la compra del Ingrediente: ", scanner);
		String sql = "delete " + "from compraingrediente " + "where codCompraIng = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCompraIngrediente);
		conexión.modificacion();
	}
  public void update() throws NoExisteCompraIngrediente, SQLException {
		ResultSet resultSet;
		CompraIngrediente compraIngrediente;
		int codEmpleado;
		String proveedor;
		int codCompraIngrediente = InputTypes.readInt("Código de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codEmpleado = resultSet.getInt("codEmpleado");
			proveedor = resultSet.getString("proveedor");
			compraIngrediente = new CompraIngrediente(codCompraIngrediente, proveedor, codEmpleado);
		} else {
			throw new NoExisteCompraIngrediente();
		}

		System.out.println(compraIngrediente);
		Menú.menúModificar(scanner, compraIngrediente);

		sql = "update compraingrediente set nombre = ?, cantidad = ?, factura = ?, proveedor = ? where codCompraIng = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexión.getSentencia().setInt(2, compraIngrediente.getCodEmpleado());
		conexión.getSentencia().setString(3, compraIngrediente.getProveedor());
		conexión.modificacion();
	}

	
	public void list() throws NoExisteCompraIngrediente {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		try {
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			compraIngrediente = new CompraIngrediente(resultSet.getInt("codCompraIng"), resultSet.getString("Proveedor"),
					resultSet.getInt("codEmpleado"));
			
			System.out.println(compraIngrediente);
		}
	} catch (SQLException e) {
		throw new NoExisteCompraIngrediente();
	 }
	}
}