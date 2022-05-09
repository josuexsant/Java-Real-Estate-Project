package inmuebles;

public class Local extends Inmueble{
	
	private int cajonesDeEstacionamiento;
	private boolean almacen;
	private int contratoCFE;
	
	public Local(int iD, String direccion, float valuacionPrecio, float dimensionesM3, float dimensionesM2,
			int cajonesDeEstacionamiento, boolean almacen, int contratoCFE) {
		super(iD, direccion, valuacionPrecio, dimensionesM3, dimensionesM2);
		this.cajonesDeEstacionamiento = cajonesDeEstacionamiento;
		this.almacen = almacen;
		this.contratoCFE = contratoCFE;
	}

	public int getCajonesDeEstacionamiento() {
		return cajonesDeEstacionamiento;
	}
	
	public void setCajonesDeEstacionamiento(int cajonesDeEstacionamiento) {
		this.cajonesDeEstacionamiento = cajonesDeEstacionamiento;
	}
	
	public boolean isAlmacen() {
		return almacen;
	}
	public void setAlmacen(boolean almacen) {
		this.almacen = almacen;
	}
	public int getContratoCFE() {
		return contratoCFE;
	}
	
	public void setContratoCFE(int contratoCFE) {
		this.contratoCFE = contratoCFE;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ "\nCajones De Estacionamiento = " + cajonesDeEstacionamiento 
				+ "\nCuenta con almacen = " + almacen 
				+ "\nNumero de contrato CFE = "+ contratoCFE ;
	}
}
