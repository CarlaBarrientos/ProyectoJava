package compraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.CompraIngrediente;
import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexión;
import ingrediente.entity.Ingrediente;
import ingrediente.entity.NoExisteIngrediente;
import ingrediente.view.IngredienteMenú;
import view.InputTypes;

public class RegistroCompraIngredientes {
	private Conexión conexión;
	private Scanner scanner;
	
	public RegistroCompraIngredientes(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}
  public void add() {
	  CompraIngrediente compraIngrediente = RegistroCompraIngrediente.Ingresar(scanner);
	  String sql = "INSERT INTO compraingrediente (codCompraIng, nombre, cantidad, factura, provedor) VALUES,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
			conexión.getSentencia().setString(2, compraIngrediente.getNombre());
			conexión.getSentencia().setInt(3, compraIngrediente.getCantidad());
			conexión.getSentencia().setString(4, compraIngrediente.getProveedor());
			conexión.getSentencia().setInt(5, compraIngrediente.getCantidad());
			conexión.modificacion();			
		} catch (SQLException e) {
			System.out.println(e.getSQLState());	  
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
		String nombre;
		int cantidad;
		int factura;
		String proveedor;
		int codCompraIngrediente = InputTypes.readInt("Código de la compra del Ingrediente: ", scanner);
		String sql = "select * from compraingrediente where codCompraIng = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCompraIngrediente);
		resultSet = conexión.resultado();
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
		CompraIngredienteMenú.menúModificar(scanner, compraIngrediente);

		sql = "update compraingrediente set nombre = ?, cantidad = ?, factura = ?, proveedor = ? where codCompraIng = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, compraIngrediente.getCodCompraIngrediente());
		conexión.getSentencia().setString(2, compraIngrediente.getNombre());
		conexión.getSentencia().setInt(3, compraIngrediente.getCantidad());
		conexión.getSentencia().setInt(4, compraIngrediente.getFactura());
		conexión.getSentencia().setString(5, compraIngrediente.getProveedor());
		conexión.modificacion();
	}

	
	public void list() throws SQLException {
		CompraIngrediente compraIngrediente;
		String sql = "select * from compraingrediente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			compraIngrediente = new CompraIngrediente(resultSet.getInt("codCompraIng"), resultSet.getString("nombre"),
					resultSet.getInt("cantidad"), resultSet.getInt("factura"), resultSet.getString("proveedor"));
			System.out.println(compraIngrediente);
		}
	}
  
}
