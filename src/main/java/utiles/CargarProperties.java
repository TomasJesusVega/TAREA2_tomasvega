package utiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CargarProperties {
	private static Properties propiedad = new Properties();
	
	public static void cargarPropiedades() {
		try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")){
			propiedad.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrlBdd() {
		return propiedad.getProperty("urlBdd");		
	}
	
	public static String getUsuarioBdd() {
		return propiedad.getProperty("usuarioBdd");	
	}	
	public static String getContaseniaBdd() {
		return propiedad.getProperty("contraseniaBdd");		
	}
	
	public static String getUsuarioAdmin() {
		return propiedad.getProperty("usuarioAdmin");
	}
	
	public static String getContraseniaAdmin() {
		return propiedad.getProperty("contraseniaAdmin");
	}
	
}

