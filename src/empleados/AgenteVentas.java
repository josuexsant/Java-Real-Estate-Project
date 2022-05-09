package empleados;

import java.util.Date;

public class AgenteVentas extends Empleado {
	private String clientesActivos;

	public AgenteVentas(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion, int nss,
			String email, String clientesActivos) {
		super(id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
		this.clientesActivos = clientesActivos;
	}

	public String getClientesActivos() {
		return clientesActivos;
	}

	public void setClientesActivos(String clientesActivos) {
		this.clientesActivos = clientesActivos;
	}
}
