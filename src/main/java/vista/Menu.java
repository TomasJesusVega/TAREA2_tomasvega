package vista;

import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	
	public static String iniciarSesion() {
		System.out.println("Introduzca un nombre de usuario");
		String nombreUsuario = sc.nextLine();
		return nombreUsuario;
	}
}
