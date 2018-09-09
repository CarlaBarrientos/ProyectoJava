package control;
import java.sql.SQLException;
import java.util.Scanner;

import view.InputTypes;


public class Actualizar {

	public static void main(String[] args) {
		try {
			Scanner scanner= new Scanner(System.in);
			Conexion conexion = new Conexion("root","","f�bricachocolates");
			/*conexion.consulta("INSERT INTO CLIENTE SET "
					+"'NOMBRE'= ?, "
					+"'CI'= ?, "
					+"'TEL�FONO'= ?, "
					+"'CELULAR'= ?, "
					+"'DIRECCI�N'= ?, "
					+"'PUNTOS'= ? ;");*/
			conexion.consulta("INSERT INTO CLIENTE VALUES (0, ?, ?, ?, ?, ?, ?)");
			String nombre= InputTypes.readString("Ingrese el nuevo nombre: ",scanner);
			int CI= InputTypes.readInt("Ingrese el CI del cliente: ", scanner);
			int tel�fono= InputTypes.readInt("Ingrese el n�mero telef�nico: ", scanner);
			int celular= InputTypes.readInt("Ingrese el n�mero de celular: ", scanner);
			String direcci�n= InputTypes.readString("Ingrese la direcci�n: ",scanner);
			int puntos= InputTypes.readInt("Ingrese la cantidad de puntos: ", scanner);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, CI);
			conexion.getSentencia().setInt(3, tel�fono);
			conexion.getSentencia().setInt(4, celular);
			conexion.getSentencia().setString(5, direcci�n);
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
