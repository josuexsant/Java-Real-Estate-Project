package empleados;

import java.util.Date;

public class Valuador extends Empleado {
	
	private int idInmueble;

	public Valuador(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion, int nss,
			String email, int idInmueble) {
		super(id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
		this.idInmueble = idInmueble;
	}
}
