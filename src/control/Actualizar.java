package control;
import java.sql.SQLException;
import java.util.Scanner;

import view.InputTypes;


public class Actualizar {

	public static void main(String[] args) {
		try {
			Scanner scanner= new Scanner(System.in);
			Conexion conexion = new Conexion("root","","fábricachocolates");
			/*conexion.consulta("INSERT INTO CLIENTE SET "
					+"'NOMBRE'= ?, "
					+"'CI'= ?, "
					+"'TELÉFONO'= ?, "
					+"'CELULAR'= ?, "
					+"'DIRECCIÓN'= ?, "
					+"'PUNTOS'= ? ;");*/
			conexion.consulta("INSERT INTO CLIENTE VALUES (0, ?, ?, ?, ?, ?, ?)");
			String nombre= InputTypes.readString("Ingrese el nuevo nombre: ",scanner);
			int CI= InputTypes.readInt("Ingrese el CI del cliente: ", scanner);
			int teléfono= InputTypes.readInt("Ingrese el número telefónico: ", scanner);
			int celular= InputTypes.readInt("Ingrese el número de celular: ", scanner);
			String dirección= InputTypes.readString("Ingrese la dirección: ",scanner);
			int puntos= InputTypes.readInt("Ingrese la cantidad de puntos: ", scanner);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, CI);
			conexion.getSentencia().setInt(3, teléfono);
			conexion.getSentencia().setInt(4, celular);
			conexion.getSentencia().setString(5, dirección);
			conexion.getSentencia().setInt(6, puntos);
			conexion.modificacion();
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
