package entidades;

import java.util.Set;

public class Artista {

	private Long idArtista;
	private String apodo = null;
	private Set<Especialidad> especialidades;

	public Artista() {
		super();
	}

	public Artista(Long idArtista, String apodo, Set<Especialidad> especialidades) {
		super();
		this.idArtista = idArtista;
		this.apodo = apodo;
		this.especialidades = especialidades;
	}

	public Long getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Long idArtista) {
		this.idArtista = idArtista;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

}