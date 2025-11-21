package controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import dao.EspectaculoDAO;
import entidades.Espectaculo;
import vista.Menu;

public class EspectaculoController {
	public void crearEspectaculo() {

        String nombre = Menu.pedirNombreEspectaculo();
        LocalDate fechaInicio = LocalDate.parse(Menu.pedirFechaInicio());
        LocalDate fechaFin = LocalDate.parse(Menu.pedirFechaFin());

        // por ahora no usamos números ni coordinador
        Espectaculo esp = new Espectaculo(nombre, fechaInicio, fechaFin, new HashSet<>());

        Long id = EspectaculoDAO.insertarEspectaculo(esp);

        if (id != null) {
            System.out.println("Espectáculo creado correctamente con ID: " + id);
        } else {
            System.out.println("Error al crear espectáculo.");
        }
    }

    public void listarEspectaculos() {
        List<Espectaculo> lista = EspectaculoDAO.consultarEspectaculos();

        if (lista.isEmpty()) {
            System.out.println("No hay espectáculos registrados.");
            return;
        }

        System.out.println("\n---- LISTA DE ESPECTÁCULOS ----");
        for (Espectaculo e : lista) {
            System.out.println(
                "ID: " + e.getId() +
                " | Nombre: " + e.getNombre() +
                " | Inicio: " + e.getFechaini() +
                " | Fin: " + e.getFechafin()
            );
        }
    }
}
