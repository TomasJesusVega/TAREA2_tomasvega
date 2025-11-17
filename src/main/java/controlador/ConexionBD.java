package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utiles.Metodos;

public class ConexionBD {

	private static Connection conexion = null;
	
	private static boolean cargado = Metodos.cargarPropiedades();
	
	private static JDBC = propiedad.getProperty("urlBdd");
	private static String USUARIO;
	private static String CONTRASENIA;
	
	public static Connection nuevaConexion() {
		
		
		if (cargado) {
			try {
				conexion = DriverManager.getConnection(JDBC, USUARIO, CONTRASENIA);
				
				System.out.println("Conexion establecida con exito");
				
			} catch (SQLException ex) {
				System.err.println("Error al conectar con la base de datos");
				
			}
			return conexion;
			
		} else {
			return conexion;
			
		}
		
	}
	
}
