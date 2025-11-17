package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utiles.Metodos;

public class ConexionBD {

	private static Connection conexion = null;
	
	private static String URL = Metodos.getProperties("urlBdd");
	private static String USUARIO = Metodos.getProperties("usuarioBdd");
	private static String CONTRASENIA = Metodos.getProperties("contraseniaBdd");
	
	public static Connection nuevaConexion() {
		if (conexion == null) {
			try {
				conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
				
				System.out.println("Conexion establecida con exito");
				
			} catch (SQLException ex) {
				System.err.println("Error al conectar con la base de datos");
				
			}
			
		}
			return conexion;
		
	}
	
	public static Connection cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				
				System.out.println("Conexion cerrada");
				
			} catch (SQLException e) {
				System.err.println("Error al cerrar la base de datos");
				
			}
			
		}
		return conexion;
		
	}
	
}
