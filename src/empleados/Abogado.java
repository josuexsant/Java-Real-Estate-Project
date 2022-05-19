package empleados;

import java.util.Date;

public class Abogado extends Empleado {
	private double horas;
	private double salario;
	private final String puesto = "abogado";
	
	public Abogado(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion,
	int nss, String email){
	super (id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
	thisQQ.horas = horas;
	this.salario = 83.08*horas; // $83.08 por hora (salario promedio)	 	
	}
	
	public double getHoras(){
	return horas;
	}
	
	public double getSalario(){
	return salario;
	}
	
	public void setHoras (double nuevasHoras){ //set
	horas = nuevasHoras;
	}
	
	public double calcularPago () { // Cálculo de pago
		return salario;
	}
	
	// toString
	public String toString () {
		return super.toString()+ "\nPuesto: " + puesto;
	} 
}