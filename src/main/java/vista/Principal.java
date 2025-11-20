package vista;

import java.util.Scanner;

import entidades.Perfil;
import entidades.Sesion;
import utiles.Metodos;

public class Principal extends Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Sesion nuevaSesion = new Sesion("Invitado", Perfil.INVITADO);

		boolean ejecucion = true;
		System.out.println("============================================\n");
		System.out.println("	Programa de gestion de circo\n\n");
		System.out.println("	Por Tomas Jesus Vega Leiva\n");
		System.out.println("============================================\n");

		do {
			switch (nuevaSesion.getPerfil()) {
			case INVITADO:
				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");

				Menu.menuInvitado();

				int opcionInvitado = sc.nextInt();

				switch (opcionInvitado) {
				case 0:
					Metodos.consumirLinea(sc);

					ejecucion = Metodos.cerrarPrograma(sc);

					break;

				case 1:
					Metodos.consumirLinea(sc);

					System.out.println("Introduzca su nombre de usuario");

					String nombreUsuario = sc.nextLine().trim();

					System.out.println("Introduzca su contrasenia");

					String contrasenia = sc.nextLine().trim();

					nuevaSesion.setNombre("Admin");
					nuevaSesion.setPerfil(Perfil.ADMIN);

					ejecucion = true;

					break;

				case 2:
					Metodos.consumirLinea(sc);

					System.out.println("Lista de espectaculos:");

					ejecucion = true;

					break;

				default:

					break;

				}
				break;

			case ADMIN:
				System.out.println("\nSesion actual: " + nuevaSesion.getNombre() + "\n");

				Menu.menuAdminInicial();

				int opcionAdmin = sc.nextInt();

				switch (opcionAdmin) {
				case 0:
					Metodos.consumirLinea(sc);

					System.out.println("Desea cerrar la sesion? Y para si, N para no");

					String opcionSalir = sc.nextLine().toUpperCase().trim();

					switch (opcionSalir.toUpperCase()) {
					case "si": {
						nuevaSesion.setNombre("Invitado");
						nuevaSesion.setPerfil(Perfil.INVITADO);

						ejecucion = true;

						break;

					}
					case "no": {
						ejecucion = true;

						break;

					}
					case " ": {
						System.err.println("Error al introducir la opcion");
						System.out.println("Asegurese de no dejar en blanco el campo\n");

						ejecucion = true;

						break;

					}
					default:
						System.out.println("Opcion Invalida, solo se admite Y o N. \n");

						ejecucion = true;

					}
					break;

				case 1:
					Metodos.consumirLinea(sc);

					Menu.menuGestionUsuario();

					break;

				case 2:
					Metodos.consumirLinea(sc);

					Menu.menuGestionEspectaculo();

					break;
				default:
					break;
				}
				break;

			case ARTISTA:
				Menu.menuArtistaInicial();

				int opcionArtista = sc.nextInt();

				switch (opcionArtista) {
				case 0:
					System.out.println("Desea cerrar la sesion? Y para si, N para no");

					String opcionSalir = sc.nextLine().toUpperCase().trim();

					switch (opcionSalir.toUpperCase()) {
					case "si": {
						nuevaSesion.setNombre("Invitado");
						nuevaSesion.setPerfil(Perfil.INVITADO);

						ejecucion = true;

						break;

					}
					case "no": {
						ejecucion = true;

						break;

					}
					case " ": {
						System.err.println("Error al introducir la opcion");
						System.out.println("Asegurese de no dejar en blanco el campo\n");

						ejecucion = true;

						break;

					}
					default:
						System.out.println("Opcion Invalida, solo se admite Y o N. \n");

						ejecucion = true;

					}
					break;

				case 1:
					System.out.println("Ficha de artista\n");

					break;

				default:
					System.err.println("Error al seleccionar una opcion");
					System.out.println("Asegurese de introducir caracteres validos! (digitos del 0 al 2)");

					break;

				}
				break;

			case COORDINACION:
				Menu.menuCoordinacionInicial();

				int opcionCoord = sc.nextInt();

				switch (opcionCoord) {
				case 0:
					System.out.println("Desea cerrar la sesion? Y para si, N para no");

					String opcionSalir = sc.nextLine().toUpperCase().trim();

					switch (opcionSalir.toUpperCase()) {
					case "SI": {
						nuevaSesion.setNombre("Invitado");
						nuevaSesion.setPerfil(Perfil.INVITADO);

						ejecucion = true;

						break;

					}
					case "NO": {
						ejecucion = true;

						break;

					}
					case " ": {
						System.err.println("Error al introducir la opcion");
						System.out.println("Asegurese de no dejar en blanco el campo\n");

						ejecucion = true;

						break;

					}
					default:
						System.out.println("Opcion Invalida, solo se admite Y o N. \n");

						ejecucion = true;

					}
					break;

				default:
					break;

				case 1:
					System.out.println();

					Menu.menuGestionEspectaculo();

					int opcionGestion = sc.nextInt();
					switch (opcionGestion) {
					case 1:
						System.out.println("Introduzca un nombre para el espectaculo entre 1 y 25 caracteres:");

						String nombreEspectaculo = sc.nextLine().trim();

						System.out.println("Introduzca la fecha de inicio del espectaculo");

						String fechaInicial = sc.nextLine().trim();

						System.out.println("Introduzca la fecha final del espectaculo");

						String fechaFinal = sc.nextLine().trim();

						break;

					case 2:
						System.out.println("Lista de espectaculos:");
						System.out.println("Introduzca el id del espectaculo buscado:");

						String id_espectaculo = sc.nextLine();
						
						System.out.println("Seleccione el campo que desee editar");
						System.out.println("1. Nombre");
						System.out.println("2. Fecha inicial");
						System.out.println("3. Fecha fin");
						System.out.println("4. Coordinador del espectaculo");
						System.out.println("0. Cancelar");
						break;

					case 3:
						System.out.println("Introduzca un nombre para el numero entre 1 y 25 caracteres:");

						String nombreNumero = sc.nextLine().trim();

						System.out.println("Introduzca la fecha de inicio del espectaculo");

						String duracion = sc.nextLine().trim();

						System.out.println("Introduzca la fecha final del espectaculo");

						int orden = sc.nextInt();

						break;

					case 4:
						System.out.println("Lista de numeros existentes:");
						System.out.println("Introduzca el id del numero buscado:");
						
						String id_numero = sc.nextLine();
						
						System.out.println("Seleccione el campo que desee editar");
						System.out.println("1. Nombre");
						System.out.println("2. Duracion");
						System.out.println("3. Orden");
						System.out.println("4. Espectaculo");
						System.out.println("0. Cancelar");
						
						break;

					case 5:
						System.out.println("Introduzca el id de la persona");
						
						String id_artista = sc.nextLine();
						
						
						break;

					default:
						break;
					}
					break;

				}
				break;

			default:
				break;
			}
		} while (ejecucion);

	}

}
