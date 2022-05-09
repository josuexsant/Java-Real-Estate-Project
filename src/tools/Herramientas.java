package tools;

import java.awt.HeadlessException;
import java.io.*;
import java.util.Date;

import javax.swing.JOptionPane;

import cliente.Cliente;
import empleados.Empleado;

public class Herramientas {
	
	
	public static int obtenerID(String path) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		String[] lineas = entradaToArreglo(fis, 1);
		return Integer.parseInt(lineas[0]);
	}
	
	public static void actualizarFolioDe(String path, int valor) throws FileNotFoundException {
		File file = new File(path);
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		ps.println(valor+1);
	}
	
	public static void mostrarLista(String path) {
		File f = new File(path);
		String[] names = f.list();
		for(int i = 0; i < names.length; i++) {
			names[i] = names[i].substring(0, names[i].length()-4);
		}
		JOptionPane.showMessageDialog(null, names);
	}
	
	public static int contarLineas(String archivo) throws IOException {
		File file = new File(archivo);
		int contador = 0;
		try {
			FileInputStream is	= new FileInputStream(file);
			InputStreamReader fir = new InputStreamReader(is);
			BufferedReader buffer = new BufferedReader(fir);
		String linea = buffer.readLine();
		while (linea != null) {
			contador++;
			linea = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Archivo no existente");
		}
		return contador;
	}
	
	public static String[] entradaToArreglo(InputStream is, int n) throws IOException {			//Dada una entrada, convierte una linea a un elemento de un arreglo n-veces 
		String[] cadena = new String[n];
		InputStreamReader isReader = new InputStreamReader(is);
		BufferedReader buffer = new BufferedReader(isReader);
		for(int i = 0; i<cadena.length; i++) {
			cadena[i] = buffer.readLine();
		}
		return cadena;
	}
	
	public static Empleado borrarEmpleado(Empleado[] registro, int ID) {
		for(int i = 0; i<registro.length; i++) {
			if(registro[i].getId() == ID)
				registro[i] = registro[i+1];
		}
		
		return null;
		
	}
	
	public static void agregarEmpleado() throws IOException {
		Date fecha = new Date();
		Empleado[] registro = new Empleado[20];
		Empleado empleado = new Empleado(
				Integer.parseInt(Herramientas.leerArchivo("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog("Nombre:"),
				Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
				JOptionPane.showInputDialog("RFC:"),
				fecha,
				JOptionPane.showInputDialog("Dirección"),
				Integer.parseInt(JOptionPane.showInputDialog("NSS:")),
				JOptionPane.showInputDialog("E-mail:")
				);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", Integer.parseInt(Herramientas.leerArchivo("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, empleado);
		IOArchivo.salvarObjeto(empleado);
	}
	
	public static void agregarCliente() throws IOException {
			int idCliente = 000;
			Cliente[] registro = new Cliente[20];
			Cliente cliente = new Cliente(
					idCliente,
					JOptionPane.showInputDialog("Nombre:"),
					Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
					Integer.parseInt(JOptionPane.showInputDialog("Telefono:")),
					JOptionPane.showInputDialog("Dirección"),
					JOptionPane.showInputDialog("E-mail:")
					);
			idCliente++;
					
			JOptionPane.showMessageDialog(null, cliente);
			IOArchivo.salvarObjeto(cliente);
			
	}
	
	public static void buscarArchivo(String path, String archivo) {
		File f = new File(path);
		String[] names = f.list();
		String info = "";
		for(int i = 0;i<names.length;i++) {
			if(names[i].equals(archivo + ".txt")) {
				System.out.println("Encontrado");
				try {
					JOptionPane.showMessageDialog(null, leerArchivo("./ficheros/Empleados_fichero/" + archivo + ".txt"));
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null, "Error");
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Archivo no encontrado");
				}
				break;
			}
		}
	}
	
	public static void eliminar(String archivo) {
		File file = new File(archivo);
		file.delete();
		JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
	}
	
	public static String leerArchivo(String archivo) throws IOException{
		FileReader reader = new FileReader(archivo);
		BufferedReader buffer = new BufferedReader(reader);
		String linea = buffer.readLine();
		String info = "";
		while (linea != null) {
			info = info + linea + "\n";
			linea = buffer.readLine();
		}
		return info;
	}
}
