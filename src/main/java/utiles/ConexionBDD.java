package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDD {
	private static Connection conexion = null;
	
	public Connection nuevaConexion() {
		if (conexion == null) {
			CargarProperties.cargarPropiedades();
			String URL = CargarProperties.getUrlBdd();
			String USUARIO = CargarProperties.getUsuarioBdd();
			String CONTRASENIA = CargarProperties.getContaseniaBdd();
			try {
				conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}
	
	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
