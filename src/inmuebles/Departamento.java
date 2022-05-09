package inmuebles;

public class Departamento extends Inmueble {
	private int NoHabitaciones;
	private int nobanos;
	private int nivelPlanta;
	private boolean estacionamiento;
	private int noVentanas;
	
	public Departamento(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2,
			int noHabitaciones, int nobanos, int nivelPlanta, boolean estacionamiento, int noVentanas) {
		super(iD, direccion, valuacionPrecio, dimensionesM3, dimensionesM2);
		NoHabitaciones = noHabitaciones;
		this.nobanos = nobanos;
		this.nivelPlanta = nivelPlanta;
		this.estacionamiento = estacionamiento;
		this.noVentanas = noVentanas;
	}

	public int getNoHabitaciones() {
		return NoHabitaciones;
	}

	public void setNoHabitaciones(int noHabitaciones) {
		NoHabitaciones = noHabitaciones;
	}

	public int getNobanos() {
		return nobanos;
	}

	public void setNobanos(int nobanos) {
		this.nobanos = nobanos;
	}

	public int getNivelPlanta() {
		return nivelPlanta;
	}

	public void setNivelPlanta(int nivelPlanta) {
		this.nivelPlanta = nivelPlanta;
	}

	public boolean isEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(boolean estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public int getNoVentanas() {
		return noVentanas;
	}

	public void setNoVentanas(int noVentanas) {
		this.noVentanas = noVentanas;
	}

	@Override
	public String toString() {
		return super.toString()
				+"\nCantidad de habitaciones=" + NoHabitaciones 
				+ "\nCantidad de baños = " + nobanos 
				+ "\nNivel planta = "+ nivelPlanta  
				+ "\nCuenta con estacionamiento = " + estacionamiento 
				+ "\nCantidad de ventanas=" + noVentanas;
	}
	
	
}
