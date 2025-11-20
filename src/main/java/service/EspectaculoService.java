package service;

import java.time.LocalDate;
import java.util.Set;

import entidades.Espectaculo;
import entidades.Numero;

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
	
	public static void mostrarListaEspectaculo() {
		
	}
	
	/**
	 * 
	 * @param nombreEspectaculo
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param numeros
	 * @return
	 */
	public Espectaculo crearEspectaculo(String nombreEspectaculo, LocalDate fechaInicial, LocalDate fechaFinal, Set<Numero> numeros) {
		return new Espectaculo(nombreEspectaculo, fechaInicial, fechaFinal, numeros);
		
	}
}
