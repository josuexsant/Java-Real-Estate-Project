package tools;

import javax.swing.JOptionPane;

public class MyExceptions {
	
	public static int esInt(String str) {
		
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(null, str));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Letras no permitidas",
					  "ERROR", JOptionPane.ERROR_MESSAGE);
			esInt(JOptionPane.showInputDialog(null, str));
		}
		return 0;
	}
}
