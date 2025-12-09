package vista;

import java.util.List;
import java.util.Scanner;

import controller.EspectaculoController;
import controller.UsuarioController;
import dao.EspectaculoDAO;
import dao.UsuarioDAO;
import entidades.Espectaculo;
import entidades.Perfil;
import entidades.Sesion;
import service.EspectaculoService;
import service.UsuarioService;
import utiles.ConexionBDD;
import utiles.Metodos;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Sesion nuevaSesion = new Sesion();
		ConexionBDD conexionBDD = new ConexionBDD();

		UsuarioDAO usuarioDAO = new UsuarioDAO(conexionBDD);
		UsuarioService usuarioService = new UsuarioService(usuarioDAO);
		UsuarioController usuarioController = new UsuarioController(nuevaSesion, usuarioService);

		EspectaculoDAO espectaculoDAO = new EspectaculoDAO(conexionBDD);
		EspectaculoService espectaculoService = new EspectaculoService(espectaculoDAO);
		EspectaculoController espectaculoController = new EspectaculoController(espectaculoService);

		boolean ejecucion = true;

		System.out.println("============================================\n");
		System.out.println("	Programa de gestion de circo\n\n");
		System.out.println("	Por Tomas Jesus Vega Leiva\n");
		System.out.println("============================================\n");
		do {
			switch (nuevaSesion.getPerfil()) {
			case INVITADO:
				do {
					System.out.println("\nSesion actual: " + nuevaSesion.getPerfil()
							+ "\n\nIntroduzca el numero al lado de la opcion para seleccionarla\n" + "1. Login\n"
							+ "2. Ver espectaculos\n" + "0. Cerrar programa\n");
					try {
						int opcionInvitado = Metodos.validarOpcion();
						switch (opcionInvitado) {
						case 0:
							System.out.println("Desea cerrar el programa? si/no");
							String opcionCerrarPrograma = sc.nextLine().toUpperCase().trim();

							switch (opcionCerrarPrograma) {
							case "SI": {
								System.out.println("Saliendo...");
								System.exit(0);
								break;
							}
							case "NO": {
								break;
							}
							default:
								System.out.println("Error al introducir una opcion, introduzca valores validos");
							}
							break;
						case 1:
							System.out.println("Introduzca su nombre de usuario:");
							String nombreUsuario = sc.nextLine().trim();
							System.out.println("Introduzca su contrasenia:");
							String contrasenia = sc.nextLine().trim();

							boolean sesionIniciada = usuarioController.AsignarSesion(nombreUsuario, contrasenia);

							if (!sesionIniciada) {
								System.out.println("Error al iniciar sesion, intentelo de nuevo sif");
							}
							break;
						case 2:
							System.out.println("Lista de espectaculos");
							List<Espectaculo> listaEspectaculosBasica = espectaculoController.listarEspectaculos();
							for (Espectaculo esp : listaEspectaculosBasica) {
								System.out.println("ID: " + esp.getId() + " | Nombre: " + esp.getNombre()
										+ " | Inicio: " + esp.getFechaini() + " | Fin: " + esp.getFechafin());
							}
							break;
						default:
							System.out.println("Error al introducir una opcion, introduzca valores validos");
						}
						break;
					} catch (NumberFormatException e) {
						e.getStackTrace();
						System.out.println("Error al introducir una opcion, introduzca valores validos");
					}
				} while (nuevaSesion.getPerfil().equals(Perfil.INVITADO));
				break;

			case ADMIN:
				do {
					try {
						System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
						System.out.println("Introduzca el numero al lado de la opcion para seleccionarla\n"
								+ "1. Gestionar personas y credenciales\n" + "2. Gestionar espectaculos\n"
								+ "0. Logout");
						int opcionAdmin = Metodos.validarOpcion();

						switch (opcionAdmin) {
						case 0:
							System.out.println("Desea cerrar la sesion? si/no");
							String opcionCerrarSesion = sc.nextLine().toUpperCase().trim();
							switch (opcionCerrarSesion) {
							case "SI": {
								usuarioController.cerrarSesion();
								break;
							}
							case "NO": {
								break;
							}
							case " ": {
								System.err.println("Error al introducir la opcion");
								System.out.println("Asegurese de no dejar en blanco el campo\n");
								break;
							}
							default:
								System.out.println("Opcion Invalida, solo se admite Y o N. \n");
							}
							break;
						case 1:
							System.out.println("Gestion de usuarios\n" + "1. Registrar usuario nuevo\n"
									+ "2. Modificar usuario existente\n");
							String opcionGestionUsuario = sc.nextLine().trim();

							int opcGesUsuInt = Integer.parseInt(opcionGestionUsuario);

							switch (opcGesUsuInt) {
							case 1:
								System.out.println("Introduzca el nombre real: ");
								String nombreReal = sc.nextLine().trim();
								if (!usuarioController.validarNombreReal(nombreReal)) {
									System.out.println("Caracteres invalidos, interrumpiendo proceso de registro");
									break;
								}
								
								System.out.println("Introduzca el email: ");
								String email = sc.nextLine().trim();
								if (!usuarioController.validarEmail(email)) {
									System.out.println("Caracteres invalidos, interrumpiendo proceso de registro");
									break;
								}
								
								System.out.println("Introduzca la nacionalidad: ");
								String nacionalidad = sc.nextLine().trim();
								if (!usuarioController.validarNacionalidad(nacionalidad)) {
									System.out.println("Caracteres invalidos, interrumpiendo proceso de registro");
									break;
								}
								
								System.out.println("Introduzca el perfil: ");
								String perfil = sc.nextLine().trim();
								
								if (usuarioController.validarPerfilPersona(perfil) == null) {
									System.out.println("Caracteres invalidos, interrumpiendo proceso de registro");
									break;
								} else {
									switch (perfil.toUpperCase()) {
									case "ARTISTA":
										
										break;
									case "COORDINACION":
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
				} while (nuevaSesion.getPerfil().equals(Perfil.ADMIN));
				break;

			case ARTISTA:
				do {
					try {
						System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
						System.out.println("Introduzca el numero al lado de la opcion para seleccionarla\n"
								+ "1. Ver ficha\n" + "0. Logout\n");
						String opcionArtista = sc.nextLine().trim();

						int opcArtInt = Integer.parseInt(opcionArtista);

						switch (opcArtInt) {
						case 0:
							System.out.println("Desea cerrar la sesion? si/no");
							String opcionCerrarSesion = sc.nextLine().toUpperCase().trim();
							switch (opcionCerrarSesion) {
							case "SI": {
								nuevaSesion.setNombre("Invitado");
								nuevaSesion.setPerfil(Perfil.INVITADO);
								break;
							}
							case "NO": {
								break;
							}
							case " ": {
								System.err.println("Error al introducir la opcion");
								System.out.println("Asegurese de no dejar en blanco el campo\n");
								break;
							}
							default:
								System.out.println("Opcion Invalida, solo se admite Y o N. \n");
								break;
							}

						case 1:
							System.out.println("Ficha de artista\n");

							break;

						default:
							System.err.println("Error al seleccionar una opcion");
							System.out.println("Asegurese de introducir caracteres validos! (digitos del 0 al 2)");

							break;

						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error al introducir una opcion, introduzca entradas validas");
					}
				} while (nuevaSesion.getPerfil().equals(Perfil.ARTISTA));
				break;

			case COORDINACION:
				do {
					try {

					} catch (Exception e) {

					}
				} while (nuevaSesion.getPerfil().equals(Perfil.INVITADO));
				System.out.println("\nSesion actual: " + nuevaSesion.getPerfil() + "\n");
				System.out.println("Introduzca el numero al lado de la opcion para seleccionarla"
						+ "1. Gestionar Espectaculos" + "0. Logout");
				String opcionCoord = sc.nextLine().trim();

				int opcCooInt = Integer.parseInt(opcionCoord);

				switch (opcCooInt) {
				case 0:
					System.out.println("Desea cerrar la sesion? si/no");
					String opcionCerrarSesion = sc.nextLine().toUpperCase().trim();
					switch (opcionCerrarSesion) {
					case "SI": {
						nuevaSesion.setNombre("Invitado");
						nuevaSesion.setPerfil(Perfil.INVITADO);
						break;
					}
					case "NO": {
						break;
					}
					case " ": {
						System.err.println("Error al introducir la opcion");
						System.out.println("Asegurese de no dejar en blanco el campo\n");
						break;
					}
					default:
						System.out.println("Opcion Invalida, solo se admite Y o N. \n");
						break;
					}

				case 1:
					System.out.println("Gestion de espectaculos\n" + "1. Crear espectaculo nuevo\n"
							+ "2. Modificar espectaculo existente\n" + "3. Crear numero nuevo\n"
							+ "4. Modificar numero existente\n" + "5. Asignar artista a numero existente\n"
							+ "0. Cancelar Operacion\n");

					String opcionGestionEsp = sc.nextLine().trim();
					int opcionGestionEspInt = Integer.parseInt(opcionGestionEsp);

					switch (opcionGestionEspInt) {
					case 0:
						usuarioController.cerrarSesion();
						break;
					case 1:
						System.out.println("Introduzca un nombre para el espectaculo entre 1 y 25 caracteres:");
						String nombreEspectaculo = sc.nextLine().trim();
						
						System.out.println("Introduzca la fecha de inicio del espectaculo:");
						String fechaInicial = sc.nextLine().trim();
						
						System.out.println("Introduzca la fecha final del espectaculo:");
						String fechaFinal = sc.nextLine();

						break;

					case 2:
						System.out.println("Lista de espectaculos:\n"
								+ "Seleccione el campo que desee editar\n"
								+ "1. Nombre\n"
								+ "2. Fecha inicial\n"
								+ "3. Fecha fin"
								+ "4. Coordinador del espectaculo\n"
								+ "0. Cancelar\n");

						int opcionEditarEspectaculo = Metodos.validarOpcion();

						switch (opcionEditarEspectaculo) {
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
						System.out.println("Seleccione el campo que desee editar");
						System.out.println("1. Nombre");
						System.out.println("2. Duracion");
						System.out.println("3. Orden");
						System.out.println("4. Espectaculo");
						System.out.println("0. Cancelar");
						int opcionEditarNumero = Metodos.validarOpcion();

						switch (opcionEditarNumero) {
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
