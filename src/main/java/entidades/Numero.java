package entidades;

public class Numero {
	private Long id;
	private String nombre;
	private double duracion;
	private int orden;
	
	public Numero() {
		super();
	}

	public Numero(Long id, String nombre, double duracion, int orden) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.orden = orden;
	}

	public Numero(String nombre, double duracion, int orden) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.orden = orden;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

}
