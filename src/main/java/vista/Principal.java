package vista;

import java.util.Scanner;

import controller.UsuarioController;
import entidades.Perfil;
import entidades.Sesion;
import utiles.Validadores;

public class Principal extends Menu {
	public static void main(String[] args) {
		Sesion nuevaSesion = UsuarioController.getSesion();
		Scanner sc = new Scanner(System.in);

		boolean ejecucion = true;
		System.out.println("============================================\n");
		System.out.println("	Programa de gestion de circo\n\n");
		System.out.println("	Por Tomas Jesus Vega Leiva\n");
		System.out.println("============================================\n");

		do {
			switch (nuevaSesion.getPerfil()) {
			case INVITADO:
				boolean sesionInvitado = true;
				do {
					try {
						System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
						System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
						System.out.println("1. Login");
						System.out.println("2. Ver espectaculos");
						System.out.println("0. Cerrar programa");
						String opcionInvitado = sc.nextLine().trim();

						int opcInvInt = Integer.parseInt(opcionInvitado);

						switch (opcInvInt) {
						case 0:
							System.out.println("Desea cerrar el programa? si/no");
							String opcionCerrarPrograma = sc.nextLine().toUpperCase().trim();
							switch (opcionCerrarPrograma) {
							case "SI": {
								System.out.println("Saliendo...");
								ejecucion = false;
								break;
							}
							case "NO": {
								ejecucion = true;
								break;
							}
							case " ": {
								System.out.println("Error al introducir una opcion, introduzca entradas validas");
								ejecucion = true;
								break;
							}
							default:
								System.out.println("Error al introducir una opcion, introduzca entradas validas");
								ejecucion = true;
							}
							break;

						case 1:
							System.out.println("Introduzca su nombre de usuario:");
							String nombreUsuario = sc.nextLine().trim();
							System.out.println("Introduzca su contrasenia:");
							String contrasenia = sc.nextLine().trim();
							boolean esValido = UsuarioController.validarInicioSesion(nombreUsuario, contrasenia);
							if (esValido) {
								if (UsuarioController.verificarInicioSesion(nombreUsuario, contrasenia) != null) {
									nuevaSesion = UsuarioController.verificarInicioSesion(nombreUsuario, contrasenia);
									sesionInvitado = false;
									System.out.println("Sesion iniciada con exito");
								}
							} else {
								sesionInvitado = true;
								System.out.println("Credenciales incorrectas, intentelo de nuevo");
								break;
							}

						case 2:
							espectaculoController.listarEspectaculos();
							break;

						default:
							break;

						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error al introducir una opcion, introduzca entradas validas");
					}
				} while (sesionInvitado);

			case ADMIN:
				try {
					System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
					System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
					System.out.println("1. Gestionar personas y credenciales");
					System.out.println("2. Gestionar espectaculos");
					System.out.println("0. Logout");
					String opcionAdmin = sc.nextLine();

					int opcAdmInt = Integer.parseInt(opcionAdmin);

					switch (opcAdmInt) {
					case 0:
						Menu.cerrarSesion();
						break;

					case 1:
						String opcionGestionUsuario = Menu.menuGestionUsuario();

						int opcGesUsuInt = Integer.parseInt(opcionGestionUsuario);

						switch (opcGesUsuInt) {
						case 1:
							String nombreReal = Validadores.validarNombreReal();
							String email = Validadores.validarEmail();
							String nacionalidad = Validadores.validarNacionalidad();
							Perfil perfil = Validadores.validarPerfilPersona();
							if (perfil == null) {
								Menu.errorCampoIncorrecto();
								break;
							}
							if (Validadores.validarPerfilPersona() != null) {
								switch (perfil.toString()) {
								case "Artista":
									String apodo = Menu.tieneApodo();
									break;

								case "Coordinacion":
									break;

								default:
									break;
								}
							}

							break;

						default:
							break;
						}
						break;

					case 2:
						Menu.menuGestionEspectaculo();

						break;
					default:
						break;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Error al introducir una opcion, introduzca entradas validas");
				}

			case ARTISTA:
				System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");

				String opcionArtista = Menu.menuArtistaInicial();

				int opcArtInt = Integer.parseInt(opcionArtista);

				switch (opcArtInt) {
				case 0:
					Menu.cerrarSesion();
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
				System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
				String opcionCoord = Menu.menuCoordinacionInicial();

				int opcCooInt = Integer.parseInt(opcionCoord);

				switch (opcCooInt) {
				case 0:

					break;

				default:
					break;

				case 1:
					Menu.menuGestionEspectaculo();

					int opcionGestionEsp = sc.nextInt();

					switch (opcionGestionEsp) {
					case 1:
						Menu.pedirNombreEspectaculo();
						Menu.pedirFechaInicio();
						Menu.pedirFechaFin();

						break;

					case 2:
						System.out.println("Lista de espectaculos:");
						String opcionEditarEspectaculo = Menu.menuEditarEspectaculo();

						int opcEdiEspInt = Integer.parseInt(opcionEditarEspectaculo);

						switch (opcEdiEspInt) {
						case 0:

							break;
						case 1:

							break;

						case 2:

							break;

						case 3:

							break;

						case 4:

							break;

						default:
							break;
						}
						break;

					case 3:

						break;

					case 4:
						System.out.println("Lista de numeros existentes:");

						String opcionEditarNumero = Menu.menuEditarNumero();

						int opcEdiNumInt = Integer.parseInt(opcionEditarNumero);

						switch (opcEdiNumInt) {
						case 0:

							break;
						case 1:

							break;

						case 2:

							break;

						case 3:

							break;

						case 4:

							break;

						default:
							break;
						}

						break;

					case 5:

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
		sc.close();
	}
}
