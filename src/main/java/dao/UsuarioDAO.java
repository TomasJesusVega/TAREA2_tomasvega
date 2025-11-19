package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.ConexionBDD;

public class UsuarioDAO {
	public static void insertarUsuario() {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String InsertUsuario = "INSERT INTO usuario(nombre_usuario, contrasenia, nombre_real, email, nacionalidad, perfil) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(InsertUsuario, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "nombreUsuario");
			stmt.setString(2, "contrasenia");
			stmt.setString(3, "nombreReal");
			stmt.setString(4, "email");
			stmt.setString(5, "nacionalidad");
			
			stmt.executeUpdate();
			//borrar
			System.out.println("usuario insertado");
			
		} catch (SQLException e) {
			e.printStackTrace();
			//brrar
			System.out.println("Error al insertar");
		}
	}
	
	
}
 