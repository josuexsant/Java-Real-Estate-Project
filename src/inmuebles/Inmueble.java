package inmuebles;

public class Inmueble {
	private int ID;
	private String direccion;
	private float valuacionPrecio;
	private float dimensionesM3;
	private float dimensionesM2;
	
	public Inmueble(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2) {
		ID = iD;
		this.direccion = direccion;
		this.valuacionPrecio = valuacionPrecio;
		this.dimensionesM3 = dimensionesM3;
		this.dimensionesM2 = dimensionesM2;
	}

	@Override
	public String toString() {
		return "ID Inmueble: " + ID
				+ "\nDireccion: " + direccion 
				+ "\nValuacion Precio: " + valuacionPrecio
				+ "\nEspacio en metros cubicos: " + dimensionesM3 
				+ "\nTamaño en metros cuadrados: " + dimensionesM2;
	}
	
	
	
}
