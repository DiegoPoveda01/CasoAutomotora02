package model;

public class Vehiculo {
	private String nombre;
	private String año;
	private String precio;
	private String kmRecorridos;
	private String color;
	private String marca;
	public Vehiculo(String nombre, String año, String precio, String kmRecorridos, String color, String marca){
		this.nombre = nombre;
		this.año = año;
		this.precio = precio;
		this.kmRecorridos = kmRecorridos;
		this.color = color;
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAño() {
		return this.año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getKmRecorridos() {
		return this.kmRecorridos;
	}

	public void setKmRecorridos(String kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}