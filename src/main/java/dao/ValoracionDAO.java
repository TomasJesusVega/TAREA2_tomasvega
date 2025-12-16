package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Valoracion;
import utiles.ConexionBDD;

public class ValoracionDAO {
	private ConexionBDD conexionBDD;
	
	public ValoracionDAO(ConexionBDD conexionBDD) {
		this.conexionBDD = conexionBDD;
	}
	
	public boolean mostrarValoraciones() {
		Connection conexion = null;
		String selectValoracion = "SELECT puntuacion, comentario, id_socio FROM valoracion";
		
		try {
			conexion = conexionBDD.nuevaConexion();
			PreparedStatement pstmt = conexion.prepareStatement(selectValoracion);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				Valoracion valoracion = new Valoracion(rs.getFloat("puntuacion"), rs.getString("comentario"), rs.getFloat("id_socio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
