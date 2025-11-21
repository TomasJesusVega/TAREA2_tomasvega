package vista;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

import controller.EspectaculoController;
import controller.UsuarioController;
import entidades.Artista;
import entidades.Coordinacion;
import entidades.Credenciales;
import entidades.Especialidad;
import entidades.Espectaculo;
import entidades.Numero;
import entidades.Perfil;
import entidades.Persona;
import entidades.Sesion;
import utiles.Validadores;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	private static Sesion nuevaSesion = new Sesion("Invitado", Perfil.INVITADO);
	
	static EspectaculoController espectaculoController = new EspectaculoController();
	
	public static Perfil getPefilSesion() {
		return nuevaSesion.getPerfil();
	}
	

	public static String menuInvitado() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Login");
		System.out.println("2. Ver espectaculos");
		System.out.println("0. Cerrar programa");
		return sc.nextLine();
	}

	public static String menuAdminInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Gestionar personas y credenciales");
		System.out.println("2. Gestionar espectaculos");
		System.out.println("0. Logout");
		return sc.nextLine();
	}

	public static String menuArtistaInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Ver ficha");
		System.out.println("0. Logout");
		return sc.nextLine();
	}

	public static String menuCoordinacionInicial() {
		System.out.println("Introduzca el numero al lado de la opcion para seleccionarla");
		System.out.println("1. Gestionar Espectaculos");
		System.out.println("0. Logout");
		return sc.nextLine();
	}

	public static String menuGestionEspectaculo() {
		System.out.println("Gestion de espectaculos\n");
		System.out.println("1. Crear espectaculo nuevo");
		System.out.println("2. Modificar espectaculo existente");
		System.out.println("3. Crear numero nuevo");
		System.out.println("4. Modificar numero existente");
		System.out.println("5. Asignar artista a numero existente");
		return sc.nextLine();
	}

	public static String menuGestionUsuario() {
		System.out.println("Gestion de usuarios\n");
		System.out.println("1. Registrar usuario nuevo");
		System.out.println("2. Modificar usuario existente");
		return sc.nextLine();
	}

	public static String menuEditarEspectaculo() {
		System.out.println("Seleccione el campo que desee editar\n");
		System.out.println("1. Nombre");
		System.out.println("2. Fecha inicial");
		System.out.println("3. Fecha fin");
		System.out.println("4. Coordinador del espectaculo");
		System.out.println("0. Cancelar");
		return sc.nextLine();
	}

	public static String menuEditarNumero() {
		System.out.println("Seleccione el campo que desee editar");
		System.out.println("1. Nombre");
		System.out.println("2. Duracion");
		System.out.println("3. Orden");
		System.out.println("4. Espectaculo");
		System.out.println("0. Cancelar");
		return sc.nextLine();
	}

	// metodos pedir
	public static String pedirPerfil() {
		System.out.println("Introduzca el perfil");
		return sc.nextLine().trim();
	}

	public static String pedirNombreEspectaculo() {
		System.out.println("Introduzca un nombre para el espectaculo entre 1 y 25 caracteres:");
		return sc.nextLine().trim();
	}

	public static String pedirFechaInicio() {
		System.out.println("Introduzca la fecha de inicio del espectaculo:");
		return sc.nextLine().trim();
	}

	public static String pedirFechaFin() {
		System.out.println("Introduzca la fecha final del espectaculo:");
		return sc.nextLine().trim();
	}

	public static String pedirIdEspectaculo() {
		System.out.println("Introduzca el id del espectaculo buscado:");
		return sc.nextLine().trim();
	}

	public static String pedirIdNumero() {
		System.out.println("Introduzca el id del numero buscado:");
		return sc.nextLine().trim();
	}

	public static String pedirIdPersona() {
		System.out.println("Introduzca el id de la persona buscada:");
		return sc.nextLine().trim();
	}

	public static String pedirNombreReal() {
		System.out.println("Introduzca el nombre real:");
		return sc.nextLine().trim();
	}
	
	public static String pedirEmail() {
		System.out.println("Introduzca el email");
		return sc.nextLine().trim();
	}

	public static String pedirNacionalidad() {
		System.out.println("Introduzca la nacionalidad");
		return sc.nextLine().trim();
	}
	
	public static String pedirNombreNumero() {
		System.out.println("Introduzca un nombre para el numero entre 1 y 25 caracteres:");
		return sc.nextLine().trim();
	}
	
	public static String pedirOrdenNumero() {
		System.out.println("Introduzca un nombre para el numero entre 1 y 25 caracteres:");
		return sc.nextLine();
	}
	
	public static String pedirApodo() {
		System.out.println("Introduzca un apodo de artista:");
		return sc.nextLine().trim();
	}
	
	public static String pedirEspecialidad() {
		System.out.println("Introduzca las especialidades del artista separadas por comas (ej: magia,humor,acrobacia):");
		return sc.nextLine().trim();
	}
	
	//metodos error
	public static void errorUsuarioExiste() {
		System.out.println("Este nombre de usuario ya existe, intente otro nombre");
	}
	
	public static void errorCredencialesIncorrectas() {
		System.out.println("Error al iniciar sesion, intentelo de nuevo");
	}
	
	public static void errorSeleccionInvalida() {
		System.out.println("Error al seleccionar una opcion introduzca una opcion valida");
	}
	
	public static void errorPerfilInvalido() {
		System.out.println("Error al introducir un perfil");
	}
	
	public static void errorCampoVacio() {
		System.out.println("El campo no puede quedar vacio");
	}
	
	public static void errorCampoIncorrecto() {
		System.out.println("Error al validar el campo, cancelando operacion");
	}
	public Persona registrarDatosPersona(String nombre, String email, String nacionalidad) {
		return new Persona(nombre, email, nacionalidad);
	}
	
	public Credenciales registrarCredendiales(String nombreUsuario, String contrasenia, Perfil perfil) {
		return new Credenciales(nombreUsuario, contrasenia, perfil);
	}
	
	public Espectaculo registrarEspectaculo(String nombreEspectaculo, LocalDate fechaInicial, LocalDate fechaFinal, Set<Numero> numeros) {
		return new Espectaculo(nombreEspectaculo, fechaInicial, fechaFinal, numeros);
	}
	
	public Numero registrarNumero(String nombreNumero, int duracion, int orden) {
		return new Numero(nombreNumero, duracion, orden);
	}
	
	public Artista registrarArtista(String apodo, Set<Especialidad> especialidades) {
		return new Artista(apodo, especialidades);
	}
	
	public Coordinacion registrarCoordinacion(boolean senior, LocalDate fechaSenior) {
		return new Coordinacion(senior, fechaSenior);
	}
	
	public static String tieneApodo() {
		String apodo = null;
		System.out.println("Tiene el artista apodo?");
		String opcionApodo = sc.nextLine().toUpperCase().trim();
		switch (opcionApodo) {
		case "SI": {
			apodo = Validadores.validarApodo();
			break;
		}
		case "NO": {
			apodo = null;
			break;
		}
		case " ": {
			Menu.errorCampoVacio();
			apodo = null;
			break;
		}
		default:
			Menu.errorSeleccionInvalida();
			apodo = null;
			break;
		}
		return apodo;
	}
	/**
	 * 
	 * @return
	 */
	public static boolean cerrarPrograma() {
		boolean ejecucion = true;
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
			System.err.println("Error al introducir una opcion");
			System.out.println("Asegurese de no dejar en blanco el campo\n");
			ejecucion = true;
			break;
		}
		default:
			errorSeleccionInvalida();
			ejecucion = true;
		}
		return ejecucion;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Perfil cerrarSesion() {
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
		}
		return nuevaSesion.getPerfil();
	}
	
	
	
	
}
