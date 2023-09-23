package model;

public class Cliente {
	private String nombre;
	private String direccion;
	private String numeroTelefonico;
	private String email;
	private String rut;
	public Cliente(String nombre, String direccion, String numeroTelefonico, String email, String rut){
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.email = email;
		this.rut = rut;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
}