package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Metodos {
	
	private static Properties propiedad = new Properties();
	
	
	public static void leerPropiedades() {
		try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")){
			propiedad.load(input);
			
			System.out.println("Propiedades leidas");
			
		} catch (IOException e) {
			System.err.println("Error al cargar el archivo");
			System.out.println("El archivo application.properties no se cargo");
			
		}
		
	}
	
	public static String getProperties(String prop) {
		return propiedad.getProperty(prop);
		
	}
	
}
