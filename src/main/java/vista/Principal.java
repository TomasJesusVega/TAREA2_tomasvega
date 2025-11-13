package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {
	public static void main(String[] args) {
		Connection conexion;
		String jdbc = "jdbc:mysql://localhost:3306/circo_tomasvega";
		try {
			conexion = DriverManager.getConnection(jdbc, "usuario", "contrasenia");
		} catch (SQLException sql) {
			
		}
	}
}
