package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputTypes {

	public static int readInt(String msg, Scanner scanner) {
		int valor = 0;

		while (true) {
			try {
				System.out.print(msg);
				System.out.print(" ");
				valor = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Debe ingresar solo números ");
				scanner.nextLine();
			}
		}
		return valor;
	}

	public static double readDouble(String msg, Scanner scanner) {
		double valor = 0;

		while (true) {
			try {
				System.out.print(msg);
				System.out.print(" ");
				valor = scanner.nextDouble();
				scanner.nextLine();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Debe ingresar solo números ");
				scanner.nextLine();
			}
		}
		return valor;
	}

	public static String readString(String msg, Scanner scanner) {
		String cadena = "";

		System.out.print(msg);
		System.out.print(" ");
		cadena = scanner.nextLine();
		return cadena;
	}
	public static Date readDate(String msg, Scanner scanner) {
		Date fecha=null;
		
		while(true) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				System.out.print(msg);
				System.out.print(" ");

				fecha = sdf.parse(scanner.nextLine());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return fecha;
		}
	}
}
