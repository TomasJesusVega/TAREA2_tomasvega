package controller;

import dao.UsuarioDAO;
import entidades.Perfil;
import entidades.Sesion;
import utiles.CargarProperties;

public class UsuarioController {
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private static Sesion nuevaSesion = new Sesion("Invitado", Perfil.INVITADO);
	
	
	public static Sesion getSesion() {
		return nuevaSesion;
	}
	
	public static boolean validarInicioSesion(String nombreUsuario, String contrasenia) {
		boolean esValido = false;
		if (!nombreUsuario.isEmpty() && nombreUsuario.length() > 2 && nombreUsuario.matches("[a-zA-Z]*")) {
			if (!contrasenia.isEmpty() && contrasenia.length() > 2) {
				esValido = true;
			}
		} else {
			esValido = false;
		}
		return esValido;
	}
	
	public static Sesion verificarInicioSesion(String nombreUsuario, String contrasenia) {
		CargarProperties.cargarPropiedades();
		if (nombreUsuario.equals(CargarProperties.getUsuarioAdmin()) && contrasenia.equals(CargarProperties.getContraseniaAdmin())) {
			nuevaSesion.setNombre("Admin");
			nuevaSesion.setPerfil(Perfil.ADMIN);
			return nuevaSesion;
			
		} else if (usuarioDAO.comprobarCredenciales(nombreUsuario, contrasenia) != null) {
			nuevaSesion = usuarioDAO.comprobarCredenciales(nombreUsuario, contrasenia);
			return nuevaSesion;
		} else{
			System.out.println("Credenciales incorrectas, intentelo de nuevo");
			return null;
		}
		
	}
	
}
