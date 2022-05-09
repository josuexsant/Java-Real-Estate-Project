package inmuebles;

public class Vivienda extends Inmueble {
	
	private int noBanos;
	private int noHbaitacones;
	private int noPisos;
	private int metrosConstruidos;
	private float metrosPatio;
	private int noCocheras;
	private int noVentanas;
	
	public Vivienda(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2,
			int noBaños, int noHbaitacones, int noPisos, int metrosConstruidos, float metrosPatio, int noCocheras,
			int noVentanas) {
		super(iD, direccion, valuacionPrecio, dimensionesM3, dimensionesM2);
		this.noBanos = noBaños;
		this.noHbaitacones = noHbaitacones;
		this.noPisos = noPisos;
		this.metrosConstruidos = metrosConstruidos;
		this.metrosPatio = metrosPatio;
		this.noCocheras = noCocheras;
		this.noVentanas = noVentanas;
	}

	public int getNoBaños() {
		return noBanos;
	}

	public void setNoBaños(int noBaños) {
		this.noBanos = noBaños;
	}

	public int getNoHbaitacones() {
		return noHbaitacones;
	}

	public void setNoHbaitacones(int noHbaitacones) {
		this.noHbaitacones = noHbaitacones;
	}

	public int getNoPisos() {
		return noPisos;
	}

	public void setNoPisos(int noPisos) {
		this.noPisos = noPisos;
	}

	public int getMetrosConstruidos() {
		return metrosConstruidos;
	}

	public void setMetrosConstruidos(int metrosConstruidos) {
		this.metrosConstruidos = metrosConstruidos;
	}

	public float getMetrosPatio() {
		return metrosPatio;
	}

	public void setMetrosPatio(float metrosPatio) {
		this.metrosPatio = metrosPatio;
	}

	public int getNoCocheras() {
		return noCocheras;
	}

	public void setNoCocheras(int noCocheras) {
		this.noCocheras = noCocheras;
	}

	public int getNoVentanas() {
		return noVentanas;
	}

	public void setNoVentanas(int noVentanas) {
		this.noVentanas = noVentanas;
	}

	@Override
	public String toString() {
		return super.toString() +
				"Cantidad de baños = " + noBanos
				+ "\nCantidad de habitaciones = " + noHbaitacones 
				+ "\nNumero de pisos = " + noPisos
				+ "\nMetros construidos = " + metrosConstruidos 
				+ "\nMetros de patio = " + metrosPatio 
				+ "\nNúmero de cocheras = "+ noCocheras 
				+ "\nNúmero de ventanas = " + noVentanas;
	}
	
	
	
}
