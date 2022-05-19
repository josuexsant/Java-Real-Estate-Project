package empleados;

import java.util.Date;
import javax.swing.JOptionPane;

public class Valuador extends Empleado {
	private int idInmueble;
	private final String puesto = "valuador";

	public Valuador(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion, int nss,
	String email) {
	super(id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
	this.idInmueble = idInmueble;
	}
	
	public int getIdInmueble(){
	return idInmueble;
	}

	// toString
	public String toString () {
		return super.toString() + "\nPuesto: " + puesto;
	}
	
}