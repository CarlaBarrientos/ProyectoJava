package detalleCompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import control.Conexi�n;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import view.InputTypes;

public class DetalleCompraIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;

	public DetalleCompraIngredientes (Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public  void add() throws SQLException {
		DetalleCompraIngrediente detalleCompraIngrediente = RegistroDetalleCompraIngrediente.ingresar(scanner);
		String sql = "Insert into detallecompraingredientes (codDetalle, codCompraIng, codIngrediente, cantidad, totalCompra) values(?,?,?,?,?)";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalleCompraIngrediente.getCodDetalle());
		conexi�n.getSentencia().setInt(2, detalleCompraIngrediente.getCodCompraIng());
		conexi�n.getSentencia().setInt(3, detalleCompraIngrediente.getCodIngrediente() );
		conexi�n.getSentencia().setInt(4, detalleCompraIngrediente.getCantidad());
		conexi�n.getSentencia().setDouble(5, detalleCompraIngrediente.getTotalCompra());
		conexi�n.modificacion();
	}

	public void update() throws NoExisteDetalleCompraIngrediente, SQLException{
		ResultSet resultSet;
		DetalleCompraIngrediente detalleCompraIngrediente;
		int cantidad;
		double totalCompra;
		int codCompraIng;
		int codIng;
		int codDetalle = InputTypes.readInt("C�digo de detalle de compra de Ingrediente: ", scanner);
		String sql = "Select * from detallecompraingredientes where codDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codDetalle);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codCompraIng = resultSet.getInt("CodCompraIng");
			codIng = resultSet.getInt("codIngrediente");
			codDetalle = resultSet.getInt("codDetalle");
			cantidad = resultSet.getInt("cantidad");
			totalCompra = resultSet.getDouble("totalCompra");
			detalleCompraIngrediente = new DetalleCompraIngrediente(codDetalle,codCompraIng, codIng, cantidad, totalCompra);
			Men�.men�Modificar(scanner, detalleCompraIngrediente);

			sql = "update detallecompraingredientes set codCompraIng = ?, codIngrediente = ?, cantidad = ?, totalCompra = ?  where codDetalle = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, detalleCompraIngrediente.getCodCompraIng());
			conexi�n.getSentencia().setInt(2, detalleCompraIngrediente.getCodIngrediente());
			conexi�n.getSentencia().setInt(3, detalleCompraIngrediente.getCantidad());
			conexi�n.getSentencia().setDouble(4, detalleCompraIngrediente.getTotalCompra());
			conexi�n.getSentencia().setInt(5, detalleCompraIngrediente.getCodDetalle());
			conexi�n.modificacion();     
		}else {
			throw new NoExisteDetalleCompraIngrediente();
		}
	}

	public void list() throws NoExisteDetalleCompraIngrediente, SQLException {
		DetalleCompraIngrediente detalleCompraIngrediente;
		String sql = "select * from detallecompraIngredientes";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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