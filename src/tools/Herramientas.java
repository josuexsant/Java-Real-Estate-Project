package tools;

import java.awt.HeadlessException;
import java.io.*;
import java.util.Date;

import javax.swing.JOptionPane;

import cliente.Cliente;
import empleados.Abogado;
import empleados.AgenteVentas;
import empleados.Empleado;
import empleados.Gerente;
import empleados.PersonalLimpieza;
import empleados.Valuador;
import inmuebles.Inmueble;
import main.Main;

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
	
	public static void mostrarLista(String path) throws IOException {
		File file;
		FileInputStream fis;
		File f = new File(path);
		String[] names = f.list();
		for(int i = 0; i < names.length; i++) {
			file = new File(path + names[i]);
			fis = new FileInputStream(file);
			String[] data = entradaToArreglo(fis, 2);
			System.out.println(obtenerID(names[i]) + " " + data[1]);
			
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
	
	public static void agregarGente(){
		Date fecha = new Date();
		try {
			Gerente gerente = new Gerente(
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog(null, "Nombre completo: "),
				MyExceptions.esInt("Edad: "),
				JOptionPane.showInputDialog(null, "RFC: "),
				fecha,
				JOptionPane.showInputDialog(null, "Direcci贸n completa: "),
				MyExceptions.esInt("NSS: "),
				JOptionPane.showInputDialog(null, "Email: ")
			);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, gerente);
		IOArchivo.salvarObjeto(gerente);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo acceder al archivo",
					  "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			try {
				Main.menuEmpleado();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	//Abogado
	public static void agregarAbogado() throws NumberFormatException, HeadlessException, IOException {
		Date fecha = new Date();
		Abogado abogado = new Abogado (
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog(null, "Nombre completo: "),
				MyExceptions.esInt("Edad: "),
				JOptionPane.showInputDialog(null, "RFC: "),
				fecha,
				JOptionPane.showInputDialog(null, "Direcci贸n completa: "),
				MyExceptions.esInt("NSS: "),
				JOptionPane.showInputDialog(null, "Email: ")
			);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, abogado);
		IOArchivo.salvarObjeto(abogado);
	}
	
	//AgenteVentas
	public static void agregarAgenteVentas() throws NumberFormatException, HeadlessException, IOException {
		Date fecha = new Date();
		AgenteVentas agenteventas = new AgenteVentas (
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog(null, "Nombre completo: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "Edad: ")),
				JOptionPane.showInputDialog(null, "RFC: "),
				fecha,
				JOptionPane.showInputDialog(null, "Direcci贸n completa: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "NSS: ")),
				JOptionPane.showInputDialog(null, "Email: ")
			);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, agenteventas);
		IOArchivo.salvarObjeto(agenteventas);
	}
	
	public static void agregarLimpieza() throws NumberFormatException, HeadlessException, IOException {
		Date fecha = new Date();
		PersonalLimpieza personalLimpieza = new PersonalLimpieza (
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog(null, "Nombre completo: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "Edad: ")),
				JOptionPane.showInputDialog(null, "RFC: "),
				fecha,
				JOptionPane.showInputDialog(null, "Direcci贸n completa: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "NSS: ")),
				JOptionPane.showInputDialog(null, "Email: ")
			);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, personalLimpieza);
		IOArchivo.salvarObjeto(personalLimpieza);
	}

	//Valuador
	public static void agregarValuador() throws NumberFormatException, HeadlessException, IOException {
		Date fecha = new Date();
		Valuador valuador = new Valuador (
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog(null, "Nombre completo: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "Edad: ")),
				JOptionPane.showInputDialog(null, "RFC: "),
				fecha,
				JOptionPane.showInputDialog(null, "Direcci贸n completa: "),
				Integer.parseInt(JOptionPane.showInputDialog(null, "NSS: ")),
				JOptionPane.showInputDialog(null, "Email: ")
			);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, valuador);
		IOArchivo.salvarObjeto(valuador);
	}
	
	public static void agregarEmpleado() throws IOException {
		Date fecha = new Date();
		Empleado empleado = new Empleado(
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")),
				JOptionPane.showInputDialog("Nombre:"),
				Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
				JOptionPane.showInputDialog("RFC:"),
				fecha,
				JOptionPane.showInputDialog("Direcci贸n"),
				Integer.parseInt(JOptionPane.showInputDialog("NSS:")),
				JOptionPane.showInputDialog("E-mail:")
				);
		Herramientas.actualizarFolioDe("./ficheros/FolioEmpleados.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioEmpleados.txt")));
		JOptionPane.showMessageDialog(null, empleado);
		IOArchivo.salvarObjeto(empleado);
	}
	
	public static void agregarInmueble() throws IOException {
		Inmueble inmueble = new Inmueble(
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioInmueble.txt")),
				JOptionPane.showInputDialog("Direcci贸n:"),
				Float.parseFloat(JOptionPane.showInputDialog("Valuacion:")),
				Float.parseFloat(JOptionPane.showInputDialog("Dimensiones en metros cubicos:")),
				Float.parseFloat(JOptionPane.showInputDialog("Dimensiones en metros cuadrados:"))
				);
		Herramientas.actualizarFolioDe("./ficheros/FolioInmueble.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioInmuebles.txt")));
		JOptionPane.showMessageDialog(null, inmueble);
		IOArchivo.salvarObjeto(inmueble);
	}
	
	public static void agregarCliente() throws IOException {
		Cliente cliente = new Cliente(
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioClientes.txt")),
				JOptionPane.showInputDialog("Nombre:"),
				Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
				Integer.parseInt(JOptionPane.showInputDialog("Telefono:")),
				JOptionPane.showInputDialog("Direcci贸n"),
				JOptionPane.showInputDialog("E-mail:")
				);
		Herramientas.actualizarFolioDe("./ficheros/FolioClientes.txt", 
				Integer.parseInt(Herramientas.obtenerFolio("./ficheros/FolioClientes.txt")));
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
		if(file.delete()) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
		}else {
			JOptionPane.showMessageDialog(null, "Error al eliminar el archivo.");
		}
		
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
	
	public static String obtenerFolio(String archivo) throws IOException{
		FileReader reader = new FileReader(archivo);
		BufferedReader buffer = new BufferedReader(reader);
		String linea = buffer.readLine();
		return linea;
	}
	
	public static double calcularAvaluo(double metros) { //Calcular el salario valuador
		double valor = 0;
		if (metros>=0 && metros<=40) {
			valor = 1050;
			}
			else if (metros>=41 && metros<=60) {
				valor = 1155;
				}
			else if (metros>=61 && metros<=100) {
				valor = 1208;
				}
			else if (metros>=100) {
				valor = 1305;
			}
		return valor;
	}
	
	public static String obtenerPuesto(String archivo) throws IOException {
		File file = new File(archivo);
		FileInputStream fis = new FileInputStream(file);
		String[] contenido = entradaToArreglo(fis, contarLineas(archivo));
		String[] puesto = contenido[contarLineas(archivo)-1].split(" ");
		return puesto[1];
	}
	
	public static double pagarNomina(String ID) throws IOException {
		return calcularSalario(obtenerPuesto("./ficheros/Empleados_fichero/" + ID + ".txt"));
	}
	
	public static double calcularSalario(String puesto) {
		double pago = 0;
		int salario = 0;
		switch(puesto) {
		case "gerente":
			salario = 500;
			pago = salario * Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias trabajo?"));
			break;
		case "abogado":
			salario = 172;
			pago = salario * Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias trabajo?"));
			break;
		case "limpieza":
			salario = 120;
			pago = salario * Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias trabajo?"));
			break;
		case "agente":
			pago = Double.parseDouble(JOptionPane.showInputDialog("Cu醠 es el costo de la propiedad?"))*0.05;
			break;
		case "valuador":
			pago = calcularAvaluo(Double.parseDouble(JOptionPane.showInputDialog("Dime el tama帽o de la propiedad")));
			break;
		}
		return pago;
	}
	
	public static void editar(String archivo) throws IOException {
		File file = new File(archivo);
		FileInputStream fis = new FileInputStream(file);
		String[] lineas = entradaToArreglo(fis, contarLineas(archivo));
		for(int i = 1; i<lineas.length; i++) {
			lineas[i] = JOptionPane.showInputDialog("Dato anterior:\n" + lineas[i] + "Dato nuevo:");
		}
		
		
	}
}
