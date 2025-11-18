package dao;

import java.sql.Connection;

import utiles.ConexionBDD;

public class UsuarioDAO {
	public static void insertarUsuario() {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String InsertUsuario = "INSERT INTO usuario(id_usuario, nombre_usuario, contrasenia, nombre_real, email, nacionalidad, perfil) VALUES(?, ?, ?, ?, ?, ?, ?)";
	}
}
