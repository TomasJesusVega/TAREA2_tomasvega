package entidades;

import java.time.LocalDate;

public class Socio extends Persona{
	private LocalDate fechaInscripcion;

	public Socio(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	
}
