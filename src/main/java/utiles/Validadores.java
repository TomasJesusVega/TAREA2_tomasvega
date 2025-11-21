package utiles;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import entidades.Perfil;
import vista.Menu;

public class Validadores {
	static Scanner sc = new Scanner(System.in);
	public static String validarEmail() {
		String email = Menu.pedirEmail();
		if (email.isEmpty() && email.matches("^^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			return email;
		} else {
			return null;
		}
	}

	public static String validarNombreReal() {
		String nombreReal = Menu.pedirNombreReal();
		if (!nombreReal.isEmpty() && nombreReal.matches("^[a-zA-Z ]+$")) {
			return nombreReal;
		} else {
			return null;
		}
	}

	public static String validarNacionalidad() {
		String nacionalidad = Menu.pedirNacionalidad();
		if (!nacionalidad.isEmpty() && nacionalidad.matches("^[\\p{L}\\p{N}\\s'\\-\\.]+$")) {
			return nacionalidad;
		} else {
			return null;
		}
	}

	public static String validarApodo() {
		String apodo = Menu.pedirApodo();
		if (!apodo.isEmpty()) {
			return apodo;
		} else {
			return null;
		}		
	}

	public static Perfil validarPerfilPersona() {
	    String perfil = Menu.pedirPerfil();

	    if (perfil == null || perfil.isEmpty()) return null;

	    try {
	        Perfil p = Perfil.valueOf(perfil.toUpperCase());
	        if (p == Perfil.COORDINACION || p == Perfil.ARTISTA) {
	            return p;
	        }
	        return null;
	    } catch (IllegalArgumentException ex) {
	        return null;
	    }
	}

	public static String validarEspecialidad() {
		String especialidad = Menu.pedirEspecialidad();
		if (!especialidad.isEmpty() & especialidad.equalsIgnoreCase("ACROBACIA") || especialidad.equalsIgnoreCase("MAGIA") || especialidad.equalsIgnoreCase("HUMOR") || 
				especialidad.equalsIgnoreCase("EQUILIBRISMO") || especialidad.equalsIgnoreCase("MALABARISMO")) {
			return especialidad;
		} else {
			return null;
		}
	}
	
	public static String validarNombreEspectaculo() {
		String nombreEspectaculo = Menu.pedirNombreEspectaculo();
		if (!nombreEspectaculo.isEmpty() & nombreEspectaculo.length() <= 25) {
			return nombreEspectaculo;
		} else {
			return null;
		}
	}
	
	public static void validarFechaEspectaculo() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		boolean esValido = false;
		do {
			try {
				String fechaini = Menu.pedirFechaInicio();				
				LocalDate fechaInicialdtf = LocalDate.parse(fechaini, dtf);
				String fechafin = Menu.pedirFechaFin();
				LocalDate fechaFinaldtf = LocalDate.parse(fechafin, dtf);
				Period duracion = Period.between(fechaInicialdtf, fechaFinaldtf);
				if (fechaFinaldtf.isBefore(fechaInicialdtf)) {
					System.out.println("La fecha final no puede ser anterior a la fecha inicial del espectaculo");				
				} else if (duracion.getYears() >= 1) {
					System.out.println("La duracion del espectaculo no puede exceder el anio");				
				} else {
					esValido = true;					
				}
			} catch (DateTimeParseException e) {
				System.err.println("Error en el formato de las fechas ");
				System.out.println("Asegurese de usar el formato correcto! (dd-mm-aaaa)\n");				
			}	
		} while (!esValido);		
	}
}
