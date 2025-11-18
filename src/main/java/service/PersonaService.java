package service;

public class PersonaService {
	/**
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validarEmail(String email) {
		boolean esValido = false;
		
		if (email.isEmpty() & email.matches("^^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
	
	/**
	 * 
	 * @param nombreReal
	 * @return
	 */
	public static boolean validarNombreReal(String nombreReal) {
		boolean esValido = false;
		
		if (!nombreReal.isEmpty() & nombreReal.matches("^[a-zA-Z ]+$")) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
	
	/**
	 * 
	 * @param nacionalidad
	 * @return
	 */
	public static boolean validarNacionalidad(String nacionalidad) {
		boolean esValido = false;
		
		if (!nacionalidad.isEmpty() & nacionalidad.matches("^[\\p{L}\\p{N}\\s'\\-\\.]+$")) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
}
