package service;

public class CredencialesService {
	
	
	/**
	 * 
	 * @param nombreUsuario
	 * @return
	 */
	public static boolean validarNombreUsuario(String nombreUsuario) {
		boolean esValido = false;
		
		if (nombreUsuario.matches("[a-zA-Z]*") & !nombreUsuario.isEmpty() & nombreUsuario.length() > 2) {
		esValido = true;
		
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
	
	/**
	 * 
	 * @param contrasenia
	 * @return
	 */
	public static boolean validarContrasenia(String contrasenia) {
		boolean esValido = false;
		
		if(!contrasenia.isEmpty() & contrasenia.length() > 2) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
	}
}
