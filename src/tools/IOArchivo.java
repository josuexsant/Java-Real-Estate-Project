package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import cliente.Cliente;
import empleados.Empleado;
import inmuebles.Inmueble;

public class IOArchivo {
	
	public static void imprimirReporte(String path) throws IOException {
		File f = new File(path);
		String info = "";
		String[] names = f.list();
		for(int i = 0; i < names.length; i++) {
			info = info + (i+1)
					+ ".---------------------------------------------\n"
					+ Herramientas.leerArchivo("./ficheros/Empleados_fichero/" + names[i]) + "\n";
		}
		JOptionPane.showMessageDialog(null, info);
	}
	
	public static void escribe(OutputStream os, String archivo) throws IOException {
		File file = new File(archivo);
		PrintStream ps = new PrintStream(os);
		try {
			FileInputStream is	= new FileInputStream(file);
			InputStreamReader fir = new InputStreamReader(is);
			BufferedReader buffer = new BufferedReader(fir);
		String linea = buffer.readLine();
		while (linea != null) {
			ps.println(linea);
			linea = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Archivo no existente");
		}
	}
	
	public static void imprimirPantalla(String archivo) throws IOException {
			File file = new File(archivo);
			try {
				FileInputStream is	= new FileInputStream(file);
				InputStreamReader fir = new InputStreamReader(is);
				BufferedReader buffer = new BufferedReader(fir);
			String linea = buffer.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = buffer.readLine();
				}
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Archivo no existente");
			}
	}
		
	public void eliminar(String archivo) {
		File file = new File(archivo);
		if(file.delete()) {
			JOptionPane.showMessageDialog(null, "Archivo eliminado");
		}else {
			JOptionPane.showMessageDialog(null, "Archivo no puede ser eliminado");
		}
	}
	
	public static void salvarObjeto(Empleado empleado) throws NumberFormatException, IOException{
		File file = new File("./ficheros/Empleados_fichero/" + empleado.getId() + ".txt");
		FileOutputStream os = new FileOutputStream(file);
		PrintStream ps = new PrintStream(os);
		ps.println(empleado.toString());
	}
	
	public static void salvarObjeto(Cliente cliente) throws FileNotFoundException{
		File file = new File("./ficheros/Empleados_fichero/" + cliente.getIdCliente() + ".txt");
		FileOutputStream os = new FileOutputStream(file);
		PrintStream ps = new PrintStream(os);
		ps.println(cliente.toString());
	}
	
	public static void salvarObjeto(Inmueble inmueble) throws FileNotFoundException{
		File file = new File("./ficheros/Empleados_fichero/" + inmueble.getID() + ".txt");
		FileOutputStream os = new FileOutputStream(file);
		PrintStream ps = new PrintStream(os);
		ps.println(inmueble.toString());
	}
	
}
