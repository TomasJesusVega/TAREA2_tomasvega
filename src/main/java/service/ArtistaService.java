package service;

public class ArtistaService {
	/**
	 * 
	 * @param apodo
	 * @return
	 */
	public static boolean validarApodo(String apodo) {
		boolean esValido = false;
		
		if (!apodo.isEmpty() & apodo.matches("[a-zA-Z]*") & apodo.length() > 2) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
	
	/**
	 * 
	 * @param especialidad
	 * @return
	 */
	public static boolean validarEspecialidad(String especialidad) {
		boolean esValido = false;
		
		if (especialidad.equalsIgnoreCase("ACROBACIA") || especialidad.equalsIgnoreCase("MAGIA") || 
			especialidad.equalsIgnoreCase("HUMOR") || especialidad.equalsIgnoreCase("EQUILIBRISMO") || 
			especialidad.equalsIgnoreCase("MALABARISMO")) {
			esValido = true;
			} else {
				esValido = false;
				
			}
		return esValido;
		
	}
}
