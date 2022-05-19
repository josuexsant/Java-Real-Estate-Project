package empleados;

import java.util.Date;

public class AgenteVentas extends Empleado {
	private double costopropiedad;
	private double salario;
	private final String puesto = "agente";
	
	public AgenteVentas(int id, String nombre, int edad, String rfc, Date fechaContratacion, String direccion,
		int nss, String email){
		super (id, nombre, edad, rfc, fechaContratacion, direccion, nss, email);
		this.costopropiedad = costopropiedad;
		this.salario = costopropiedad*.05; // 5% por el costo de la propiedad (tarifa promedio)	 	
	}
	
	public double getCostopropiedad(){
	return costopropiedad;
	}
	
	public double getSalario(){
	return salario;
	}
	
	public void setNuevocostopropiedad (double nuevoCostopropiedad){ //set
	costopropiedad = nuevoCostopropiedad;
	}
	
	public double calcularPago () { // Cálculo de pago
		return salario;
	}
	
	// toString
	public String toString () {
		return super.toString() + "\nPuesto: " + puesto;
	} 
}
