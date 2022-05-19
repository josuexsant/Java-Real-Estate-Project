package cliente;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private int edad;
	private int telefono;
	private String direccion;
	private String email;

	//Constructor
	public Cliente(int idCliente, String nombre, int edad, int telefono, String direccion, String email) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "\nID Cliente: " + idCliente 
				+ "\nNombre: " + nombre
				+ "Direccion: " + direccion 
				+ "\nEdad: " + edad 
				+ "\nE-mail: "  + email;
	}	
}
