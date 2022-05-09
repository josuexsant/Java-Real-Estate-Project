package empleados;

import java.util.Date;

public class Gerente extends Empleado {

	public Gerente(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion, int nss,
			String email) {
		super(id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
	}

}
