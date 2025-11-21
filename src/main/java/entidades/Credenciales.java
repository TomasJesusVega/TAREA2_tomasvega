package entidades;

public class Credenciales {
	private Long id;
	private String nombre;
	private String contrasenia;
	private Perfil perfil;

	public Credenciales() {
		super();
	}

	public Credenciales(Long id, String nombre, String contrasenia, Perfil perfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.perfil = perfil;
	}

	
	public Credenciales(String nombre, String contrasenia, Perfil perfil) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}