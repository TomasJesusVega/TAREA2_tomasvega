package controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import entidades.Espectaculo;
import service.EspectaculoService;

public class EspectaculoController {
	private EspectaculoService espectaculoService;

	public EspectaculoController(EspectaculoService espectaculoService) {
		this.espectaculoService = espectaculoService;
	}

	public EspectaculoController() {
		super();
	}

	public boolean validarNombreEspectaculo(String nombreEspectaculo) {
		if (!nombreEspectaculo.isEmpty() & nombreEspectaculo.length() <= 25) {
			return true;
		}
		return false;
	}

	public List<Espectaculo> listarEspectaculos() {
		if (espectaculoService.existenEspectaculos()) {
			List<Espectaculo> datoEspectaculoBasico = espectaculoService.listaEspectaculosBasica();
			return datoEspectaculoBasico;
		}
		return null;
	}

	public void crearEspectaculo() {
	}

}

//      System.out.println("\n---- LISTA DE ESPECTÁCULOS ----");
//      for (Espectaculo e : lista) {
//          System.out.println(
//              "ID: " + e.getId() +
//              " | Nombre: " + e.getNombre() +
//              " | Inicio: " + e.getFechaini() +
//              " | Fin: " + e.getFechafin()
//          );
//      }

//
//        String nombre = Menu.pedirNombreEspectaculo();
//        LocalDate fechaInicio = LocalDate.parse(Menu.pedirFechaInicio());
//        LocalDate fechaFin = LocalDate.parse(Menu.pedirFechaFin());
//
//        Espectaculo esp = new Espectaculo(nombre, fechaInicio, fechaFin, new HashSet<>());
//
//        Long id = EspectaculoDAO.insertarEspectaculo(esp);
//
//        if (id != null) {
//            System.out.println("Espectáculo creado correctamente con ID: " + id);
//        } else {
//            System.out.println("Error al crear espectáculo.");
//        }

