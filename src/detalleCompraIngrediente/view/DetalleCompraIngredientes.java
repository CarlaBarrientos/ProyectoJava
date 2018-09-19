package detalleCompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexión;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import view.InputTypes;

public class DetalleCompraIngredientes {
	private Conexión conexión;
	private Scanner scanner;

	public DetalleCompraIngredientes (Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	public  void add() throws SQLException {
		DetalleCompraIngrediente detalleCompraIngrediente = RegistroDetalleCompraIngrediente.ingresar(scanner);
		String sql = "Insert into detallecompraingredientes (codDetalle, codCompraIng, codIngrediente, cantidad, totalCompra) values(?,?,?,?,?)";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalleCompraIngrediente.getCodDetalle());
		conexión.getSentencia().setInt(2, detalleCompraIngrediente.getCodCompraIng());
		conexión.getSentencia().setInt(3, detalleCompraIngrediente.getCodIngrediente() );
		conexión.getSentencia().setInt(4, detalleCompraIngrediente.getCantidad());
		conexión.getSentencia().setDouble(5, detalleCompraIngrediente.getTotalCompra());
		conexión.modificacion();
	}

	public void update() throws NoExisteDetalleCompraIngrediente, SQLException{
		ResultSet resultSet;
		DetalleCompraIngrediente detalleCompraIngrediente;
		int cantidad;
		double totalCompra;
		int codCompraIng;
		int codIng;
		int codDetalle = InputTypes.readInt("Código de detalle de compra de Ingrediente: ", scanner);
		String sql = "Select * from detallecompraingredientes where codDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codDetalle);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codCompraIng = resultSet.getInt("CodCompraIng");
			codIng = resultSet.getInt("codIngrediente");
			codDetalle = resultSet.getInt("codDetalle");
			cantidad = resultSet.getInt("cantidad");
			totalCompra = resultSet.getDouble("totalCompra");
			detalleCompraIngrediente = new DetalleCompraIngrediente(codDetalle,codCompraIng, codIng, cantidad, totalCompra);
			Menú.menúModificar(scanner, detalleCompraIngrediente);

			sql = "update detallecompraingredientes set codCompraIng = ?, codIngrediente = ?, cantidad = ?, totalCompra = ?  where codDetalle = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, detalleCompraIngrediente.getCodCompraIng());
			conexión.getSentencia().setInt(2, detalleCompraIngrediente.getCodIngrediente());
			conexión.getSentencia().setInt(3, detalleCompraIngrediente.getCantidad());
			conexión.getSentencia().setDouble(4, detalleCompraIngrediente.getTotalCompra());
			conexión.getSentencia().setInt(5, detalleCompraIngrediente.getCodDetalle());
			conexión.modificacion();     
		}else {
			throw new NoExisteDetalleCompraIngrediente();
		}
	}

	public void list() throws NoExisteDetalleCompraIngrediente, SQLException {
		DetalleCompraIngrediente detalleCompraIngrediente;
		String sql = "select * from detallecompraIngredientes";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		if (resultSet.next()) {
			resultSet.previous();
			while (resultSet.next()) {
				detalleCompraIngrediente = new DetalleCompraIngrediente(resultSet.getInt("codDetalle"), resultSet.getInt("codCompraIng"), resultSet.getInt("codIngrediente"),
						resultSet.getInt("cantidad"), resultSet.getDouble("totalCompra"));
				System.out.println(detalleCompraIngrediente);
			}
		} else {
			throw new NoExisteDetalleCompraIngrediente();
		}
	}
}