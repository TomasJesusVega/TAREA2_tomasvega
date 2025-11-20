package service;

import entidades.Numero;

public class NumeroService {

	public Numero crearNumero(String nombreNumero, int duracion, int orden) {
		return new Numero(nombreNumero, duracion, orden);
		
	}
}
