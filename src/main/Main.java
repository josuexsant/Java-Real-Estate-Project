package main;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JOptionPane;

import Contrato.Venta;
import empleados.Empleado;
import tools.Herramientas;
import tools.IOArchivo;

public class Main {
	
	public static void main(String[] args) throws IOException {
		menuPrincipal();
		//test();
	}
	
	public static boolean menuPrincipal() {
		boolean ejecucion = true;
		String opciones = "Bienvenido al sistema, escoja una opción"
				+ "\n1. Empleados"
				+ "\n2. Inmuebles"
				+ "\n3. Clientes"
				+ "\n4. Crear contrato."
				+ "\n5. Salir.";
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			menuEmpleado();
			break;
		case 2:
			menuInmueble();
		case 3:
			ejecucion = false;
			default:
				JOptionPane.showMessageDialog(null, "Compruebe secuencia de teclas");
				
		}
		return ejecucion;
	}
	
	public static void menuEmpleado() {
		String opciones = "Escoja una opción"
				+ "\n1. Agregar empleado."
				+ "\n2. Mostrar Empleados."
				+ "\n3. Editar datos."
				+ "\n4. Buscar empleado."
				+ "\n5  Imprimir reporte de empleados."
				+ "\n6. Eliminar empleado."
				+ "\n7. Atrás.";	
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			try {
				Herramientas.agregarEmpleado();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				menuEmpleado();
			}
			break;
		case 2:
			Herramientas.mostrarLista("./ficheros/Empleados_fichero");
			menuEmpleado();
			break;
		case 3:
			
			break;
		case 4:
			Herramientas.buscarArchivo("./ficheros/Empleados_fichero", JOptionPane.showInputDialog("Escribe el nombre:"));
			menuEmpleado();
			break;
		case 5:
			try {
				IOArchivo.imprimirReporte("./ficheros/Empleados_fichero");
			} catch (IOException e) {
				e.printStackTrace();
			}
			menuEmpleado();
			break;
		case 6:
			Herramientas.eliminar("./ficheros/Empleados_fichero/" + JOptionPane.showInputDialog("Escribe el nombre:") + ".txt");
			menuEmpleado();
			break;
		case 7:
			menuPrincipal();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Compruebe secuencia");
		}
	}
	
	public static boolean menuInmueble() {
		boolean run = true;
		String opciones = "Escoja una opción"
				+ "\n1. Mostrar Inmuebles."
				+ "\n2. Agregar Inmuebles."
				+ "\n3  Imprimir reporte de inmuebles."
				+ "\n4. Buscar inmueble."
				+ "\n5. Eliminar inmueble."
				+ "\n6. Salir.";
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			menuPrincipal();
			break;
		default: 
			JOptionPane.showMessageDialog(null, "Compruebe secuencia");
				
		}
		
		return run;
	}
	
	public static boolean menuCliente() {
		boolean run = true;
		String opciones = "Escoja una opción"
				+ "\n1. Agregar cliente."
				+ "\n2. Buscar cliente."
				+ "\n3. Eliminar cliente."
				+ "\n4. Atrás.";
		
		switch (Integer.parseInt(JOptionPane.showInputDialog(opciones))) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			menuPrincipal();
		default:
			JOptionPane.showMessageDialog(null, "Compruebe secuencia");
		}
		return run;
	}
	
	public static void crearContrato() throws IOException {
		
	}
	
	public static void test() throws HeadlessException, IOException {
		/**File file = new File("./ficheros/Empleados_fichero/empleado07.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/**File f = new File("./ficheros/Empleados_fichero");
		String[] names = f.list();
		
		String name = "Josue Santamaria Morales";
		String info = "";
		for(int i = 0;i<names.length;i++) {
			if(names[i].equals(name + ".txt")) {
				System.out.println("Encontrado");
				break;
			}
		}
		JOptionPane.showMessageDialog(null, Herramientas.leerArchivo("./ficheros/Empleados_fichero/" + name + ".txt"));
	
		System.out.println(Herramientas.leerArchivo("./ficheros/FolioEmpleados.txt"));
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", Integer.parseInt(Herramientas.leerArchivo("./ficheros/FolioEmpleados.txt")));
		System.out.println(Herramientas.leerArchivo("./ficheros/FolioEmpleados.txt"));
	*/
		
	}

}
