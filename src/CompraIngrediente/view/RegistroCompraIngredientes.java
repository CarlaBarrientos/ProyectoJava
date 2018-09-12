package CompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import CompraIngrediente.entity.CompraIngrediente;
import CompraIngrediente.entity.NoExisteCompraIngrediente;
import Ingrediente.entity.Ingrediente;
import Ingrediente.entity.NoExisteIngrediente;
import Ingrediente.view.IngredienteMenú;
import control.Conexión;
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
	  String sql = "Insert into Ingrediente (codCompraIngrediente, nombre, cantidad, proveedor, factura) " + "values(?,?,?,?,?)";
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
		String sql = "delete " + "from compraIngrediente " + "where código = ?";
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
		String sql = "select * from compraIngrediente where código = ?";
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

		sql = "update ingrediente set nombre = ?, descripción = ? where código = ?";

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
		String sql = "select * from compraIngrediente ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			compraIngrediente = new CompraIngrediente(resultSet.getInt("código"), resultSet.getString("nombre"),
					resultSet.getInt("cantidad"), resultSet.getInt("factura"), resultSet.getString("proveedor"));
			System.out.println(compraIngrediente);
		}
	}
  
}
