package view;

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
}
