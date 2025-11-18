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
	
	
	
	
	
	
}