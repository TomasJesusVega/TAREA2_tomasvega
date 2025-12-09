package service;

import java.util.List;

import dao.EspectaculoDAO;
import entidades.Espectaculo;

public class EspectaculoService {
	private EspectaculoDAO espectaculoDAO;
	
	public EspectaculoService(EspectaculoDAO espectaculoDAO) {
		this.espectaculoDAO = espectaculoDAO;
	}
	
	public List<Espectaculo> listaEspectaculosBasica() {
		List<Espectaculo> listaEspectaculosBasica = espectaculoDAO.consultarEspectaculosBasico();
		return listaEspectaculosBasica;
	}
	
	public boolean existenEspectaculos() {
		List<Espectaculo> listaEspectaculosBasica = espectaculoDAO.consultarEspectaculosBasico();
		if (listaEspectaculosBasica != null) {
			return true;
		}
		return false;
	}
}
