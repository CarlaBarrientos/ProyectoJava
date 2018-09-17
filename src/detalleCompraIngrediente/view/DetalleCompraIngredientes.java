package detalleCompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexión;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;

public class DetalleCompraIngredientes {
	private Conexión conexión;
	private Scanner scanner;
	public DetalleCompraIngredientes (Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}
	
	public  void add() throws SQLException, NoExisteCompraIngrediente, NoExisteIngrediente {
		DetalleCompraIngrediente detalleCompraIngrediente = RegistroDetalleCompraIngrediente.ingresar(scanner);
		String sqlIngrediente ="Select codIngrediente from ingredientes where codIngrediente =?";
        conexión.consulta(sqlIngrediente);
        conexión.getSentencia().setInt(1, detalleCompraIngrediente.getCodIngrediente());
        ResultSet resultSetIng = conexión.resultado();
		if(resultSetIng.next()) {
			String sqlComp ="Select codCompraIng from compraingrediente where codCompraIng =?";
			conexión.consulta(sqlComp);
			conexión.getSentencia().setInt(1, detalleCompraIngrediente.getCodCompraIng());
			ResultSet resultSetComp = conexión.resultado();		
			if(resultSetComp.next()) {
				String sql = "Insert codDetalle from detallecompraingrediente where codDetalle = ?";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, detalleCompraIngrediente.getCodDetalle());
				conexión.getSentencia().setInt(2, detalleCompraIngrediente.getCodCompraIng());
				conexión.getSentencia().setInt(3, detalleCompraIngrediente.getCodIngrediente() );
				conexión.getSentencia().setInt(4, detalleCompraIngrediente.getCantidad());
				conexión.getSentencia().setDouble(5, detalleCompraIngrediente.getTotalCompra());
				conexión.modificacion();
				
			}else {
				throw new NoExisteCompraIngrediente();
			}
			
		} else {
			throw new NoExisteIngrediente();
		}
		
	}
	public void delete() throws SQLException {
		int codDetalle = InputTypes.readInt(" Código de detalle Compra Ingrediente: ", scanner);
		String sql = "delete from detallecompraingrediente where codCompraIng = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codDetalle);
		conexión.modificacion();
	}
	
	public void update() throws  SQLException , NoExisteCompraIngrediente, NoExisteIngrediente, NoExisteDetalleCompraIngrediente{
		ResultSet resultSet;
		DetalleCompraIngrediente detalleCompraIngrediente;
		int cantidad;
		double totalCompra;
		int codDetalle = InputTypes.readInt("código de detalle de compra de Ingrediente: ", scanner);
		String sql = "Select * from detallecompraingrediente where codDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codDetalle);
		resultSet = conexión.resultado();
		if (resultSet.next()) {		
			String sqlCompraIng="Select codCompraIng from compraingrediente where codCompraIng =?";
			int codCompraIng = InputTypes.readInt("Ingrear el nuevo código de compraIngrediente: ", scanner);
			conexión.consulta(sqlCompraIng);
			conexión.getSentencia().setInt(1, codCompraIng);
			ResultSet resultSetCo = conexión.resultado();

			if(resultSetCo.next()) {
				String sqlIngrediente ="Select codIngrediente from ingredientes where codIngrediente =?";
				int codIng = InputTypes.readInt("Ingrear el nuevo código de compraIngrediente: ", scanner);
				conexión.consulta(sqlIngrediente);
				conexión.getSentencia().setInt(1, codIng);
				ResultSet resultSetIng = conexión.resultado();
				
				if(resultSetIng.next()) {
					codCompraIng = resultSet.getInt("CodCompraIng");
					codIng = resultSet.getInt("codIngrediente");
					codDetalle = resultSet.getInt("codDetalle");
					cantidad = resultSet.getInt("cantidad");
					totalCompra = resultSet.getDouble("totalCompra");
					detalleCompraIngrediente = new DetalleCompraIngrediente(codDetalle,codCompraIng, codIng, cantidad, totalCompra);
					System.out.println(detalleCompraIngrediente);
					Menú.menúModificar(scanner, detalleCompraIngrediente);

					sql = "update detallecompraingrediente set codCompraIng=?, codIngrediente = ?, cantidad = ?, totalCompra = ?  where codDetalle = ?";

				} else {
					throw new NoExisteCompraIngrediente();
				}
			}else {
					throw new NoExisteIngrediente();
				}     
			
		
	 }else {
				throw new NoExisteDetalleCompraIngrediente();
			}
	}
	public void list() throws NoExisteDetalleCompraIngrediente {
		DetalleCompraIngrediente detalleCompraIngrediente;
		String sql = "select * from detallecompraingrediente ";
		try {
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				detalleCompraIngrediente = new DetalleCompraIngrediente(resultSet.getInt("codDetalle"), resultSet.getInt("codCompraIng"), resultSet.getInt("codIngrediente"),
						resultSet.getInt("cantidad"), resultSet.getDouble("totalCompra"));
				System.out.println(detalleCompraIngrediente);
			}
		} catch (SQLException e) {
			throw new NoExisteDetalleCompraIngrediente();
		}

	}
}
	

