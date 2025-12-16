package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import entidades.Espectaculo;
import utiles.ConexionBDD;

public class EspectaculoDAO {
	private ConexionBDD conexionBDD;

	public EspectaculoDAO(ConexionBDD conexionBDD) {
		this.conexionBDD = conexionBDD;
	}

	public List<Espectaculo> consultarEspectaculosBasico() {
		Connection conexion = null;
		
		List<Espectaculo> lista = new ArrayList<>();

		String selectEspectaculo = "SELECT id_espectaculo, nombre_espectaculo, fecha_inicio, fecha_fin, id_coordinacion FROM espectaculo";

		try {
			conexion = conexionBDD.nuevaConexion();
			
			PreparedStatement stmt = conexion.prepareStatement(selectEspectaculo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Espectaculo esp = new Espectaculo(rs.getLong("id_espectaculo"), rs.getString("nombre_espectaculo"), rs.getDate("fecha_inicio").toLocalDate(), rs.getDate("fecha_fin").toLocalDate());
				lista.add(esp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}

//    public static Long insertarEspectaculo(Espectaculo esp) {
//
//        String sql = "INSERT INTO espectaculo(nombre_espectaculo, fecha_inicio, fecha_fin, id_coordinacion) " +
//                     "VALUES (?, ?, ?, ?)";
//
//        try (Connection con = ;
//             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            stmt.setString(1, esp.getNombre());
//            stmt.setDate(2, Date.valueOf(esp.getFechaini()));
//            stmt.setDate(3, Date.valueOf(esp.getFechafin()));
//
//            // puede ser null
//            if (esp.getIdCoord() != null) 
//                stmt.setLong(4, esp.getIdCoord());
//            else 
//                stmt.setNull(4, Types.BIGINT);
//
//            stmt.executeUpdate();
//
//            ResultSet rs = stmt.getGeneratedKeys();
//            if (rs.next()) {
//                Long idGenerado = rs.getLong(1);
//                esp.setId(idGenerado);
//                return idGenerado;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
