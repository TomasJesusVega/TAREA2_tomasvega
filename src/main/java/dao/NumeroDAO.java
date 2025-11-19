package dao;

import java.sql.Connection;

import utiles.ConexionBDD;

public class NumeroDAO {
	public static void insertarNumero() {
		Connection conexion = ConexionBDD.nuevaConexion();
		
		String InsertNumero = "INSERT INTO numero(nombre_numero, orden, duracion, id_espectaculo) VALUES(?, ?, ?, ?)";
	}
	/**
	 * while(ResultSet.next) {
	 * Espectaculo esp = new Espectaculo();
	 * esp.setID(rs.getLong("id");
	 * esp.setNombre(rs.getString("nombre");
	 * 
	 * numeroDAO numDAO = new numDAO();
	 * ArrayList<Numero> numeroEsp = numDAO.numeroDelEspectaculo(esp.getId());
	 * esp.setNumeros(numerosEsp);
	 * 
	 * listaEsp.add(esp);
	 * }
	 * 
	 * return 
	 */
	
}
