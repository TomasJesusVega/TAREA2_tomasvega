package utiles;

import java.util.Scanner;

public class Metodos {
	private static Scanner sc = new Scanner(System.in);
	public static int validarOpcion() {
		String opcion = sc.nextLine().trim();
		return Integer.parseInt(opcion);
	}
	
}
