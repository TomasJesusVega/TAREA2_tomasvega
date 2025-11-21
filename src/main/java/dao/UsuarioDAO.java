package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Credenciales;
import entidades.Perfil;
import entidades.Persona;
import entidades.Sesion;
import utiles.ConexionBDD;

public class UsuarioDAO {
	private Connection conexion;
	
    public Sesion comprobarCredenciales(String nombreUsuario, String contrasenia) {
        conexion = ConexionBDD.nuevaConexion();
        
        String selectCredenciales = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasenia = ?";
        
        try {
        	PreparedStatement pstmt = conexion.prepareStatement(selectCredenciales);
        	
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contrasenia);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Sesion(String.valueOf(rs.getString("perfil")), Perfil.valueOf(rs.getString("perfil").toUpperCase()));
            } else {
            	return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        } finally {
        	ConexionBDD.cerrarConexion();
		}
        return null;
    }

    public boolean unicidadNombreUsuario(String nombreUsuario) {
        conexion = ConexionBDD.nuevaConexion();
        
        String selectNombreUsuario = "SELECT id FROM usuario WHERE nombre_usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(selectNombreUsuario)) {
            stmt.setString(1, nombreUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void insertarPersonaYCredenciales(Persona persona, Credenciales cred) {
        conexion = ConexionBDD.nuevaConexion();

        try {
			conexion.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        try {
            // insertar persona
            String insertPersona = "INSERT INTO persona(nombre_real, email, nacionalidad) VALUES (?, ?, ?)";
            PreparedStatement pstmtPersona = conexion.prepareStatement(insertPersona, Statement.RETURN_GENERATED_KEYS);

            pstmtPersona.setString(1, persona.getNombre());
            pstmtPersona.setString(2, persona.getEmail());
            pstmtPersona.setString(3, persona.getNacionalidad());
            pstmtPersona.executeUpdate();

            ResultSet rs = pstmtPersona.getGeneratedKeys();
            rs.next();
            long personaId = rs.getLong(1);

            String insertCredenciales = "INSERT INTO credenciales(nombre_usuario, contrasenia, perfil, persona_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmtCredenciales = conexion.prepareStatement(insertCredenciales);

            pstmtCredenciales.setString(1, cred.getNombre());
            pstmtCredenciales.setString(2, cred.getContrasenia());
            pstmtCredenciales.setString(3, cred.getPerfil().toString());
            pstmtCredenciales.setLong(4, personaId);
            pstmtCredenciales.executeUpdate();

            conexion.commit();

        } catch (SQLException e) {
        	try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
    }
}
