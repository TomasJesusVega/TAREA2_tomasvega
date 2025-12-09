package service;

import dao.UsuarioDAO;
import entidades.Credenciales;

public class UsuarioService {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Credenciales obtenerCredenciales(String nombreUsuario, String contrasenia) {
		Credenciales credenciales = usuarioDAO.comprobarCredenciales(nombreUsuario, contrasenia);
		return credenciales;
	}
}
