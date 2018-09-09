package view;


import java.util.Scanner;

public class InputTypes {
	public static int readInt(String msg, Scanner scanner) {
		int valor=0;

		while(true) {
			try {
				System.out.print(msg);
				valor=scanner.nextInt();
				scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Debe ingresar valores numéricos");
				scanner.nextLine();
			}
		}
		return valor;
	}
	public static String readString(String msg, Scanner scanner) {
		String nombre;
		while(true) {
			try {
				System.out.print(msg);
				nombre=scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Debe ingresar letras");
				scanner.nextLine();
			}
		}
		return nombre;
	}
	public static double readDouble(String msg, Scanner scanner) {
		double precio;
		while(true) {
			try {
				System.out.print(msg);
				precio=scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Debe ingresar valores numéricos");
				scanner.nextLine();
			}
		}
		return precio;
	}
}
