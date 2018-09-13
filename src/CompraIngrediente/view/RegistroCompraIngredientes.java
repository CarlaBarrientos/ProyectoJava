package compraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexi�n;
import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import ingrediente.view.IngredienteMen�;
import view.InputTypes;

public class RegistroCompraIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;
	
	public RegistroCompraIngredientes(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}
  public void add() {
	  CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
	  String sql = "INSERT INTO compraingrediente (codCompraIng, nombre, cantidad, factura, provedor) VALUES,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
			conexi�n.getSentencia().setString(2, compraIngrediente.getNombre());
			conexi�n.getSentencia().setInt(3, compraIngrediente.getCantidad());
			conexi�n.getSentencia().setString(4, compraIngrediente.getProveedor());
			conexi�n.getSentencia().setInt(5, compraIngrediente.getCantidad());
			conexi�n.modificacion();			
		} catch (SQLException e) {
			System.out.println(e.getSQLState());	  
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
		String nombre;
		int cantidad;
		int factura;
		String proveedor;
		int codCompraIngrediente = InputTypes.readInt("C�digo de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			cantidad = resultSet.getInt("cantidad");
			factura = resultSet.getInt("factura");
			proveedor = resultSet.getString("proveedor");
			compraIngrediente = new CompraIngrediente(codCompraIngrediente,nombre , cantidad, factura, proveedor);
		} else {
			throw new NoExisteCompraIngrediente();
		}

		System.out.println(compraIngrediente);
		CompraIngredienteMen�.men�Modificar(scanner, compraIngrediente);

		sql = "update compraingrediente set nombre = ?, cantidad = ?, factura = ?, proveedor = ? where codCompraIng = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexi�n.getSentencia().setString(2, compraIngrediente.getNombre());
		conexi�n.getSentencia().setInt(3, compraIngrediente.getCantidad());
		conexi�n.getSentencia().setInt(4, compraIngrediente.getFactura());
		conexi�n.getSentencia().setString(5, compraIngrediente.getProveedor());
		conexi�n.modificacion();
	}

	
	public void list() throws SQLException {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			compraIngrediente = new CompraIngrediente(resultSet.getInt("codCompraIng"), resultSet.getString("nombre"),
					resultSet.getInt("cantidad"), resultSet.getInt("factura"), resultSet.getString("proveedor"));
			System.out.println(compraIngrediente);
		}
	}
  
}
