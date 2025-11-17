package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Metodos {
	
	private static Properties propiedad = new Properties();
	
	public static boolean cargarPropiedades() {
		boolean valido = false;

		try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")){
			propiedad.load(input);
			valido = true;
			
		} catch (IOException e) {
			System.err.println("Error al cargar el archivo");
			System.out.println("El archivo application.properties no se cargo");
			
			valido = false;
			
		}
		return valido;
		
	}
	
	public static String getProperties() {
	}
	
}
