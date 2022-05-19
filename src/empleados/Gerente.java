package empleados;

import java.util.Date;

public class Gerente extends Empleado {
	private double dias;
	private double salario;
	private final String puesto = "gerente";

	public Gerente(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion,
		int nss, String email){
		super (id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
		this.dias = dias;
		this.salario = 172*dias; // $172 por dia (salario minimo)	 	
	}
		
	public double getDias(){
	return dias;
	}
	
	public double getSalario(){
	return salario;
	}
	
	public void setDias (double nuevosDias){ //set
	dias = nuevosDias;
	}
	
	public double calcularPago () { // Cálculo de pago
		return salario;
	}
	
	// toString
	@Override
	public String toString () {
		return super.toString()+ "\nPuesto: " + puesto;
	}	
}