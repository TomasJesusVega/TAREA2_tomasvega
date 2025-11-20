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
	
	public static void consumirLinea(Scanner sc) {
		if (sc.hasNextLine()) {
			sc.nextLine();
			
		}
	}
	
	public static boolean cerrarPrograma(Scanner sc) {
		boolean ejecucion = true;
		System.out.println("Desea cerrar el programa? si/no");
		
		String opcionSalir = sc.nextLine().toUpperCase().trim();
		
		switch (opcionSalir) {
		case "SI": {
			System.out.println("Saliendo...");
			
			ejecucion = false;
			
			break;
			
		}
		case "NO": {
			ejecucion = true;
			
			break;
			
		}
		case " ": {
			System.err.println("Error al introducir una opcion");
			System.out.println("Asegurese de no dejar en blanco el campo\n");
			
			ejecucion = true;
			
			break;
			
		}
		default:
			System.err.println("Error al seleccionar una opcion");
			System.out.println("Asegurese de escribir solo si o no \n");
			
			ejecucion = true;
			
		}
		
		return ejecucion;
	}
	
}