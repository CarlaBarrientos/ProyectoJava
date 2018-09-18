package detalleCompraIngrediente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import compraIngrediente.entity.NoExisteCompraIngrediente;
import control.Conexi�n;
import detalleCompraIngrediente.entity.DetalleCompraIngrediente;
import detalleCompraIngrediente.entity.NoExisteDetalleCompraIngrediente;
import ingrediente.entity.NoExisteIngrediente;
import view.InputTypes;

public class DetalleCompraIngredientes {
	private Conexi�n conexi�n;
	private Scanner scanner;
	public DetalleCompraIngredientes (Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	public  void add() throws SQLException, NoExisteCompraIngrediente, NoExisteIngrediente {
		DetalleCompraIngrediente detalleCompraIngrediente = RegistroDetalleCompraIngrediente.ingresar(scanner);
		String sqlIngrediente ="Select codIngrediente from ingredientes where codIngrediente = ?";
		conexi�n.consulta(sqlIngrediente);
		conexi�n.getSentencia().setInt(1, detalleCompraIngrediente.getCodIngrediente());
		ResultSet resultSetIng = conexi�n.resultado();
		if(resultSetIng.next()) {
			String sqlComp ="Select codCompraIng from compraingrediente where codCompraIng = ?";
			conexi�n.consulta(sqlComp);
			conexi�n.getSentencia().setInt(1, detalleCompraIngrediente.getCodCompraIng());
			ResultSet resultSetComp = conexi�n.resultado();		
			if(resultSetComp.next()) {
				String sql = "Insert into detallecompraingredientes (codDetalle, codCompraIng, codIngrediente, cantidad, totalCompra) values(?,?,?,?,?)";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, detalleCompraIngrediente.getCodDetalle());
				conexi�n.getSentencia().setInt(2, detalleCompraIngrediente.getCodCompraIng());
				conexi�n.getSentencia().setInt(3, detalleCompraIngrediente.getCodIngrediente() );
				conexi�n.getSentencia().setInt(4, detalleCompraIngrediente.getCantidad());
				conexi�n.getSentencia().setDouble(5, detalleCompraIngrediente.getTotalCompra());
				conexi�n.modificacion();
			}else {
				throw new NoExisteCompraIngrediente();
			}

		} else {
			throw new NoExisteIngrediente();
		}
	}

	public void update() throws  SQLException , NoExisteCompraIngrediente, NoExisteIngrediente, NoExisteDetalleCompraIngrediente{
		ResultSet resultSet;
		DetalleCompraIngrediente detalleCompraIngrediente;
		int cantidad;
		double totalCompra;
		int codDetalle = InputTypes.readInt("C�digo de detalle de compra de Ingrediente: ", scanner);
		String sql = "Select * from detallecompraingredientes where codDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codDetalle);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {		
			String sqlCompraIng = "Select codCompraIng from compraingrediente where codCompraIng = ?";
			int codCompraIng = InputTypes.readInt("Ingresar el nuevo c�digo de compraIngrediente: ", scanner);
			conexi�n.consulta(sqlCompraIng);
			conexi�n.getSentencia().setInt(1, codCompraIng);
			ResultSet resultSetCo = conexi�n.resultado();
			if(resultSetCo.next()) {
				String sqlIngrediente = "Select codIngrediente from ingredientes where codIngrediente = ?";
				int codIng = InputTypes.readInt("Ingresar el nuevo c�digo de compraIngrediente: ", scanner);
				conexi�n.consulta(sqlIngrediente);
				conexi�n.getSentencia().setInt(1, codIng);
				ResultSet resultSetIng = conexi�n.resultado();
				if(resultSetIng.next()) {
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
				} else {
					throw new NoExisteIngrediente();
				}
			}else {
				throw new NoExisteCompraIngrediente();
			}     
		}else {
			throw new NoExisteDetalleCompraIngrediente();
		}
	}

	public void list() throws NoExisteDetalleCompraIngrediente, SQLException {
		
		//asi no muestra el error pero si lista
		
		
		DetalleCompraIngrediente detalleCompraIngrediente;
		String sql = "select * from detallecompraIngredientes";
		try {
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				detalleCompraIngrediente = new DetalleCompraIngrediente(resultSet.getInt("codDetalle"), resultSet.getInt("codCompraIng"), resultSet.getInt("codIngrediente"),
						resultSet.getInt("cantidad"), resultSet.getDouble("totalCompra"));
				System.out.println(detalleCompraIngrediente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//asi muestra un error cuando esta vac�o pero no lista
		
		
		/*
		DetalleCompraIngrediente detalleCompraIngrediente;
		String sql = "select * from detallecompraIngredientes";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			if (resultSet.next()) {
			while (resultSet.next()) {
				detalleCompraIngrediente = new DetalleCompraIngrediente(resultSet.getInt("codDetalle"), resultSet.getInt("codCompraIng"), resultSet.getInt("codIngrediente"),
						resultSet.getInt("cantidad"), resultSet.getDouble("totalCompra"));
				System.out.println(detalleCompraIngrediente);
			}
		} else {
			throw new NoExisteDetalleCompraIngrediente();
		}
		*/
	}
}