package vista;

public class Menu {
	
	public static void menuInvitado() {
		System.out.println("1. Login");
		System.out.println("2. Ver espectaculos");
		System.out.println("0. Cerrar programa");
		
	}
	
	public static void menuAdminInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Gestionar personas y credenciales");
		System.out.println("2. Gestionar espectaculos");
		System.out.println("0. Logout");
		
	}
	
	public static void menuArtistaInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Ver ficha");
		System.out.println("0. Logout");
		
	}
	
	public static void menuCoordinacionInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Gestionar Espectaculos");
		System.out.println("2. Logout");
		
	}
	
	public static void menuGestionEspectaculo() {
		System.out.println("Gestion de espectaculos\n");
		System.out.println("1. Crear espectaculo nuevo");
		System.out.println("2. Modificar espectaculo existente");
		System.out.println("3. Crear numero nuevo");
		System.out.println("4. Modificar numero existente");
		System.out.println("5. Asignar artista a numero existente");
		
	}
	
	public static void menuGestionUsuario() {
		System.out.println("Gestion de usuarios\n");
		System.out.println("1. Registrar usuario nuevo");
		System.out.println("2. Modificar usuario existente");
	}
}
