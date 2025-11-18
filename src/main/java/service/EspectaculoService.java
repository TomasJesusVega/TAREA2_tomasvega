package service;

public class EspectaculoService {
	/**
	 * 
	 * @param nombreEspectaculo
	 * @return
	 */
	public static boolean validarnombreEspectaculo(String nombreEspectaculo) {
		boolean esValido = false;
		
		if (!nombreEspectaculo.isEmpty() & nombreEspectaculo.length() <= 25) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
}
