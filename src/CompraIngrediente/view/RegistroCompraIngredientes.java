package CompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import CompraIngrediente.entity.CompraIngrediente;
import CompraIngrediente.entity.NoExisteCompraIngrediente;
import Ingrediente.entity.Ingrediente;
import Ingrediente.entity.NoExisteIngrediente;
import Ingrediente.view.IngredienteMen�;
import control.Conexi�n;
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
	  String sql = "Insert into Ingrediente (codCompraIngrediente, nombre, cantidad, proveedor, factura) " + "values(?,?,?,?,?)";
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
		String sql = "delete " + "from compraIngrediente " + "where c�digo = ?";
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
		String sql = "select * from compraIngrediente where c�digo = ?";
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

		sql = "update ingrediente set nombre = ?, descripci�n = ? where c�digo = ?";

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
		String sql = "select * from compraIngrediente ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			compraIngrediente = new CompraIngrediente(resultSet.getInt("c�digo"), resultSet.getString("nombre"),
					resultSet.getInt("cantidad"), resultSet.getInt("factura"), resultSet.getString("proveedor"));
			System.out.println(compraIngrediente);
		}
	}
  
}
