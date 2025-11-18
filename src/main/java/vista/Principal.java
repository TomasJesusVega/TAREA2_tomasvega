package vista;

import java.util.Scanner;

import entidades.Perfil;
import entidades.Sesion;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sesion nuevaSesion = new Sesion("Invitado", Perfil.INVITADO);
		
		
		System.out.println("============================================\n");
		System.out.println("	Programa de gestion de circo\n\n");
		System.out.println("	Por Tomas Jesus Vega Leiva\n");
		System.out.println("============================================\n");
		
		
//		do {
//			if (nuevaSesion.getPerfil().equals(Perfil.INVITADO)) {
//				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");
//				System.out.println("\nIntroduzca el numero al lado de la opcion para seleccionarla\n");
//				System.out.println("1. Login");
//				System.out.println("2. Ver espectaculos");
//				System.out.println("3. Cerrar programa");
//
//				boolean usuarioCorrecto = false;
//				boolean contraseniaCorrecta = false;
//				int opcion = sc.nextInt();
//
//				switch (opcion) {
//				case 1: {
//					System.out.println("Introduzca su nombre de usuario");
//
//					String nombreUsuario = sc.nextLine();
//
//					System.out.println("Introduzca su contrasenia");
//
//					String contrasenia = sc.nextLine();
//
//					usuarioCorrecto = CredencialesService.validarNombreUsuario(nombreUsuario);
//					contraseniaCorrecta = CredencialesService.validarContrasenia(contrasenia);
//
//					if (usuarioCorrecto & contraseniaCorrecta) {
//
//						break;
//
//					} else {
//						System.out.println("intentelo de nuevo");
//
//					}
//					break;
//
//				}
//
//				case 2: {
//
//					break;
//
//				}
//
//				case 3: {
//
//					break;
//
//				}
//				default:
//					System.err.println("Como llegaste hasta aqui?");
//
//				}
//			}
//
//			if (nuevaSesion.getPerfil().equals(Perfil.ARTISTA)) {
//				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");
//
//				int opcion = sc.nextInt();
//
//				switch (opcion) {
//				case 1: {
//					Metodos.consumirLinea(sc);
//
//					System.out.println("Ficha del artista...");
//
//					break;
//
//				}
//				case 2: {
//					Metodos.consumirLinea(sc);
//
//					Metodos.validarlogOut(nuevaSesion, sc);
//
//					break;
//
//				}
//				default:
//					System.err.println("Como llegaste hasta aqui?");
//
//				}
//			}
//
//			if (nuevaSesion.getPerfil().equals(Perfil.COORDINACION)) {
//				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");
//
//				opcion = Metodos.menuCoordinacion(sc, opcion);
//
//				switch (opcion) {
//				case 1: {
//					Metodos.consumirLinea(sc);
//
//					segundaOpcion = Metodos.menuCoordinacionGestion(sc, segundaOpcion);
//
//					switch (segundaOpcion) {
//					case 1: {
//
//						break;
//
//					}
//					case 2: {
//
//						break;
//
//					}
//					default:
//						throw new IllegalArgumentException("Unexpected value: " + segundaOpcion);
//					}
//
//				}
//				case 2: {
//					Metodos.consumirLinea(sc);
//
//					Metodos.validarlogOut(nuevaSesion, sc);
//					break;
//
//				}
//				default:
//					System.err.println("Como llegaste hasta aqui?");
//
//				}
//			}
//
//			if (nuevaSesion.getPerfil().equals(Perfil.ADMIN)) {
//
//				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");
//
//				opcion = Metodos.menuAdmin(sc, opcion);
//
//				switch (opcion) {
//				case 1: {
//					Metodos.consumirLinea(sc);
//
//					Metodos.menuAdminRegistraPersona(sc);
//
//					Metodos.mostrarCredenciales();
//
//					break;
//				}
//				case 2: {
//					Metodos.consumirLinea(sc);
//
//					Metodos.menuAdminGestionaEspectaculo(sc);
//
//					break;
//				}
//
//				case 3: {
//					Metodos.consumirLinea(sc);
//
//					Metodos.validarlogOut(nuevaSesion, sc);
//
//					break;
//				}
//				default:
//					System.err.println("Como llegaste hasta aqui?");
//
//				}
//			}
//
//		} while (ejecucion);
//
//		sc.close();
		
		
	}
	

}
