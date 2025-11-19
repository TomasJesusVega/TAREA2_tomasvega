package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utiles.ConexionBDD;

public class ArtistaDAO {
	public static void consultarArtista(long idArtista) {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String selectArtista = "SELECT * FROM artista WHERE id_artista = ?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(selectArtista);
			stmt.setLong(1, idArtista);
			ResultSet rs = stmt.executeQuery();
			
			String nombre_espectaculo = rs.getString("nombreEspectaculo");
			String fecha_inicio = rs.getString("fechaInicio");
			String fecha_fin = rs.getString("fechaFin");
			String id_coordinacion = rs.getString("idCoord");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
