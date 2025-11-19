package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.ConexionBDD;

public class EspectaculoDAO {
	public static void insertarEspectaculo() {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String InsertEspectaculo = "INSERT INTO espectaculo(nombre_espectaculo, fecha_inicio, fecha_fin, id_coordinacion) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(InsertEspectaculo, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, "nombreEspectaculo");
			stmt.setString(2, "fechaInicio");
			stmt.setString(3, "fechaFin");
			stmt.setString(4, "idCoord");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void consultarEspectaculo() {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String selectEspectaculo = "SELECT * FROM espectaculo";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(selectEspectaculo, Statement.RETURN_GENERATED_KEYS);
			
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
