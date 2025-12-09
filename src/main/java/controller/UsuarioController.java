package controller;

import entidades.Credenciales;
import entidades.Perfil;
import entidades.Sesion;
import service.UsuarioService;
import utiles.CargarProperties;
import vista.Menu;

public class UsuarioController {
	private Sesion sesionActual;

	private UsuarioService usuarioService;

	public UsuarioController(Sesion sesionActual, UsuarioService usuarioService) {
		this.sesionActual = sesionActual;
		this.usuarioService = usuarioService;
	}

	public boolean validarNombreReal(String nombreReal) {
		if (!nombreReal.isEmpty() && nombreReal.matches("^[a-zA-Z ]+$")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarEmail(String email) {
		if (email.isEmpty() && email.matches("^^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarNacionalidad(String nacionalidad) {
		if (!nacionalidad.isEmpty() && nacionalidad.matches("^[\\p{L}\\p{N}\\s'\\-\\.]+$")) {
			return true;
		} else {
			return false;
		}
	}
	
	public Perfil validarPerfilPersona(String perfil) {
	    if (perfil == null || perfil.isEmpty()) {
	    	return null;
	    }
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
	
	public boolean validarInicioSesion(String nombreUsuario, String contrasenia) {
		if (nombreUsuario == null || contrasenia == null) {
			return false;
		}
		boolean nombreValido = !nombreUsuario.isEmpty() && nombreUsuario.length() > 2
				&& nombreUsuario.matches("[a-zA-Z]*");
		boolean contraseniaValida = !contrasenia.isEmpty() && contrasenia.length() > 2;
		return nombreValido && contraseniaValida;
	}

	public boolean AsignarSesion(String nombreUsuario, String contrasenia) {
		if (!validarInicioSesion(nombreUsuario, contrasenia)) {
			return false;
		}
		CargarProperties.cargarPropiedades();
		if (nombreUsuario.equals(CargarProperties.getUsuarioAdmin())) {
			if (contrasenia.equals(CargarProperties.getContraseniaAdmin())) {
				sesionActual.setNombre("Admin");
				sesionActual.setPerfil(Perfil.ADMIN);
				return true;
			} else {
				return false;
			}
		}
		Credenciales credencialesBDD = usuarioService.obtenerCredenciales(nombreUsuario, contrasenia);

		if (credencialesBDD != null) {
			sesionActual.setNombre(credencialesBDD.getNombre());
			sesionActual.setPerfil(credencialesBDD.getPerfil());
			return true;
		}

		return false;
	}

	public void cerrarSesion() {
		sesionActual.setNombre("Invitado");
		sesionActual.setPerfil(Perfil.INVITADO);
	}

}
