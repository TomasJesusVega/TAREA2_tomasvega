package controller;

import entidades.Valoracion;
import service.ValoracionService;

public class ValoracionController {
	Valoracion valoracion;
	
	ValoracionService valoracionService;
	
	public ValoracionController(ValoracionService valoracionService) {
		this.valoracionService = valoracionService;
	}

	public ValoracionController() {
		super();
	}

	public boolean validarNota(int nota) {
		if (nota % 5 == 0 && nota <=5) {
			return true;
		}
		return false;
	}
	
	public boolean validarComentario(String comentario) {
		if (comentario.length() < 10 && comentario.length() > 100) {
			return true;
		}
		return false;
	}
	
	
}
