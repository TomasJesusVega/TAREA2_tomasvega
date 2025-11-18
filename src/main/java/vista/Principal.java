package vista;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============================================\n");
		System.out.println("	Programa de gestion de circo\n\n");
		System.out.println("	Por Tomas Jesus Vega Leiva\n");
		System.out.println("============================================\n");
	}
	
	public static void menuInvitado() {
		System.out.println("\nIntroduzca el numero al lado de la opcion para seleccionarla\n");
		System.out.println("1. Login");
		System.out.println("2. Ver espectaculos");
		System.out.println("3. Cerrar programa");
	}
}
