package vista;

import controlador.ConexionBD;
import utiles.Metodos;

public class Principal {
	public static void main(String[] args) {
		Metodos.leerPropiedades();
		ConexionBD.nuevaConexion();
		ConexionBD.cerrarConexion();
		
	}
}
