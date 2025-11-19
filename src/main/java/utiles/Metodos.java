package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Metodos {
	
	private static Properties propiedad = new Properties();
	
	/**
	 * 
	 */
	public static void leerPropiedades() {
		try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")){
			propiedad.load(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	public static String getProperties(String prop) {
		return propiedad.getProperty(prop);
		
	}
	
	public static boolean verificarAdmin(String usuario, String contrasenia) {
		boolean esValido = false;
		
		leerPropiedades();
		
		String usuarioAdmin = propiedad.getProperty("usuarioAdmin").trim();
        String contraseniaAdmin = propiedad.getProperty("contraseniaAdmin").trim();

		if (usuarioAdmin.equals(usuario) && contraseniaAdmin.equals(contrasenia)) {
			esValido = true;
			
		} else {
			esValido = false;
			
		}
		return esValido;
		
	}
	
}