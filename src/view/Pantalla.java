package view;

import java.sql.SQLException;
import java.util.Scanner;

public class Pantalla {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			view.Menú.menú(scanner);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
}
