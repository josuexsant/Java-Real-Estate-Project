package main;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import tools.Herramientas;
import tools.IOArchivo;

public class Main {
	
	public static void main(String[] args) throws IOException {
		menuPrincipal();
		
		//test();
	}
	
	public static void menuPrincipal() {
		String opciones = "Bienvenido al sistema, escoja una opciÃ³n"
				+ "\n1. Empleados"
				+ "\n2. Inmuebles"
				+ "\n3. Clientes"
				+ "\n4. Crear contrato."
				+ "\n5. Salir.";
		
		try {
			switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
				case 1:
					menuEmpleado();
					break;
				case 2:
					menuInmueble();
					break;
				case 3:
					menuCliente();
					break;
				case 4:
					break;
				case 5:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Compruebe secuencia de teclas.",
							  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					menuPrincipal();
					break;
			}	
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Letras no permitidas",
					  "ERROR", JOptionPane.ERROR_MESSAGE);
			menuPrincipal();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder al archivo",
					  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			menuPrincipal();
		}
	}
	
	public static void subMenuEmpleados() {
		try {
			String opciones = "Qué tipo de empleado desea registrar:"
				+ "\n1. Gerente."
				+ "\n2. Abogado."
				+ "\n3. Agente de ventas."
				+ "\n4. Personal Limpieza."
				+ "\n5. Valuador."
				+ "\n6. Salir.";
		
			switch(Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
				case 1:
					Herramientas.agregarGente(); //agregar gerente
					subMenuEmpleados();
					break;
				case 2:
					Herramientas.agregarAbogado(); //agregar abogado
					subMenuEmpleados();
					break;
				case 3:
					Herramientas.agregarAgenteVentas(); //agregar agente de ventas
					subMenuEmpleados();
					break;
				case 4:
					Herramientas.agregarLimpieza(); //agregar personal limpieza
					subMenuEmpleados();
					break;
				case 5:
					Herramientas.agregarValuador(); //agregar valuador
					subMenuEmpleados();
					break;
				case 6:
					menuEmpleado();
					break;
				default:	
					JOptionPane.showMessageDialog(null, "Compruebe secuencia de teclas",
							  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					subMenuEmpleados();
			}
		}catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Letras no permitidas",
					  "ERROR", JOptionPane.ERROR_MESSAGE);
			subMenuEmpleados();
		}catch(IOException e2) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder al archivo",
					  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			subMenuEmpleados();
		}catch(HeadlessException e3) {
			System.out.print(e3);
		}
	}
	
	public static void menuEmpleado() throws IOException {
		try {
			String id;
			String path = "./ficheros/Empleados_fichero";
			String opciones = "Escoja una opción"
				+ "\n1. Agregar empleado."
				+ "\n2. Buscar empleado."
				+ "\n3. Editar datos."
				+ "\n4. Pagar nómina."
				+ "\n5  Imprimir reporte de empleados."
				+ "\n6. Eliminar empleado."
				+ "\n7. Atrás.";
		
			switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
				case 1:
					subMenuEmpleados();
					menuEmpleado();
					break;
				case 2:
					Herramientas.buscarArchivo(path, JOptionPane.showInputDialog("Escribe el ID a buscar:"));
					menuEmpleado();
					break;
				case 3:
					id = JOptionPane.showInputDialog("Escribe el ID a editar: ");
					String puesto = Herramientas.obtenerPuesto(Herramientas.obtenerPuesto("./ficheros/Empleados_fichero/" + id + ".txt"));
					switch(puesto) {
					case "gerente":
						Herramientas.agregarGente();
						break;
					case "abogado":
						Herramientas.agregarAbogado();
						break;
					case "limpieza":
						Herramientas.agregarLimpieza();
						break;
					case "agente":
						Herramientas.agregarAgenteVentas();
						break;
					case "valuador":
						Herramientas.agregarValuador();
						break;
					}
					break;
				case 4:
					try {
						id = JOptionPane.showInputDialog("Escribe la nómina para pagarle: ");
					double nomina = Herramientas.pagarNomina(id);
					JOptionPane.showMessageDialog(null, "Se ha pagado $" + nomina + " a: " + id + "\nTipo de puesto: " + Herramientas.obtenerPuesto("./ficheros/Empleados_fichero/" + id + ".txt"));
					} catch (Exception e){
						JOptionPane.showMessageDialog(null, "Algo ha salido mal, intenta más tarde");
					}finally {
						menuEmpleado();
					}
					break;
				case 5:
					try {
						IOArchivo.imprimirReporte(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
					menuEmpleado();
					break;
				case 6:
					Herramientas.eliminar(path + "/" + JOptionPane.showInputDialog("Escribe el ID del cliente:") + ".txt");
					menuEmpleado();
					break;
				case 7:
					menuPrincipal();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Compruebe secuencia de teclas",
							  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					menuEmpleado();
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Letras no permitidas",
					  "ERROR", JOptionPane.ERROR_MESSAGE);
			menuEmpleado();
		}catch(IOException e1) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder al archivo",
					  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			menuEmpleado();
		}
	}
	
	public static void menuInmueble() throws IOException {
		String path = "./ficheros/Inmuebles_fichero";
		String opciones = "Escoja una opciÃ³n"
				+ "\n1. Agregar inmueble."
				+ "\n2. Buscar inmueble."
				+ "\n3. Editar datos."
				+ "\n4  Imprimir reporte de un inmueble."
				+ "\n5. Eliminar inmueble."
				+ "\n6. AtrÃ¡s.";	
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			Herramientas.agregarInmueble();
			menuInmueble();
			break;
		case 2:
			Herramientas.buscarArchivo(path, JOptionPane.showInputDialog("Escribe el ID a buscar:"));
			menuEmpleado();
			break;
		case 3:
			break;
		case 4:
			try {
				IOArchivo.imprimirReporte(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			menuInmueble();
			break;
		case 5:
			Herramientas.eliminar(path + "/" + JOptionPane.showInputDialog("Escribe el ID del inmueble:") + ".txt");
			menuEmpleado();
			break;
		case 6:
			menuPrincipal();
			break;
		default: 
			JOptionPane.showMessageDialog(null, "Compruebe secuencia");
				
		}
	}
	
	public static void menuCliente() throws IOException {
		String path = "./ficheros/Clientes_fichero";
		String opciones = "Escoja una opción"
				+ "\n1. Agregar cliente."
				+ "\n2. Buscar cliente."
				+ "\n3. Editar datos."
				+ "\n4  Imprimir reporte de un cliente."
				+ "\n5. Eliminar cliente."
				+ "\n6. Atrás.";
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			Herramientas.agregarCliente();
			menuCliente();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			menuPrincipal();
		case 5:
			break;
		case 6:
			menuPrincipal();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Compruebe secuencia");
		}
	}
	
	public static void crearContrato() throws IOException {
		
	}
	
	public static void test() {
	
	}
}
