package inmuebles;

public class Terreno extends Inmueble {

	private boolean serviciosBasicos;
	private float terrenoConstruibleM2;
	
	public Terreno(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2,
			boolean serviciosBasicos, float terrenoConstruibleM2) {
		super(iD, direccion, valuacionPrecio, dimensionesM3, dimensionesM2);
		this.serviciosBasicos = serviciosBasicos;
		this.terrenoConstruibleM2 = terrenoConstruibleM2;
	}

	public boolean isServiciosBasicos() {
		return serviciosBasicos;
	}

	public void setServiciosBasicos(boolean serviciosBasicos) {
		this.serviciosBasicos = serviciosBasicos;
	}

	public float getTerrenoConstruibleM2() {
		return terrenoConstruibleM2;
	}

	public void setTerrenoConstruibleM2(float terrenoConstruibleM2) {
		this.terrenoConstruibleM2 = terrenoConstruibleM2;
	}
	
}
