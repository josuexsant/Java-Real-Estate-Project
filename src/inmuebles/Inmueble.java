package inmuebles;

public class Inmueble {
	private int ID;
	private String direccion;
	private float valuacionPrecio;
	private float dimensionesM3;
	private float dimensionesM2;
	
	public Inmueble(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2) {
		this.ID = iD;
		this.direccion = direccion;
		this.valuacionPrecio = valuacionPrecio;
		this.dimensionesM3 = dimensionesM3;
		this.dimensionesM2 = dimensionesM2;
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public float getValuacionPrecio() {
		return valuacionPrecio;
	}


	public void setValuacionPrecio(float valuacionPrecio) {
		this.valuacionPrecio = valuacionPrecio;
	}


	public float getDimensionesM3() {
		return dimensionesM3;
	}


	public void setDimensionesM3(float dimensionesM3) {
		this.dimensionesM3 = dimensionesM3;
	}


	public float getDimensionesM2() {
		return dimensionesM2;
	}


	public void setDimensionesM2(float dimensionesM2) {
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
