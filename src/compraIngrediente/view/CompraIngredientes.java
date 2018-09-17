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
  public void add() throws NoExisteCompraIngrediente {
	  CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
	  String sql = "Insert into compraingrediente (codCompraIng, nombre, cantidad, factura, provedor) " + "values(?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
			conexi�n.getSentencia().setString(2, compraIngrediente.getProveedor());
			conexi�n.getSentencia().setInt(3, compraIngrediente.getCodEmpleado());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		  throw new NoExisteCompraIngrediente();
		}
  }
  
  
  public void delete() throws SQLException {
		int codCompraIngrediente = InputTypes.readInt("C�digo de la compra del Ingrediente: ", scanner);
		String sql = "delete " + "from compraingrediente " + "where codCompraIng = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCompraIngrediente);
		conexi�n.modificacion();
	}
  public void update() throws NoExisteCompraIngrediente, SQLException {
		ResultSet resultSet;
		CompraIngrediente compraIngrediente;
		int codEmpleado;
		String proveedor;
		int codCompraIngrediente = InputTypes.readInt("C�digo de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codEmpleado = resultSet.getInt("codEmpleado");
			proveedor = resultSet.getString("proveedor");
			compraIngrediente = new CompraIngrediente(codCompraIngrediente, proveedor, codEmpleado);
		} else {
			throw new NoExisteCompraIngrediente();
		}

		System.out.println(compraIngrediente);
		Men�.men�Modificar(scanner, compraIngrediente);

		sql = "update compraingrediente set nombre = ?, cantidad = ?, factura = ?, proveedor = ? where codCompraIng = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexi�n.getSentencia().setInt(2, compraIngrediente.getCodEmpleado());
		conexi�n.getSentencia().setString(3, compraIngrediente.getProveedor());
		conexi�n.modificacion();
	}

	
	public void list() throws NoExisteCompraIngrediente {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		try {
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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