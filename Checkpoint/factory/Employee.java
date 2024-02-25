/**
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author MAAG
 *
 */
public class Employee extends User {

	@Override
	public void printMenu() {
		System.out.println("Bienvenido");
		System.out.println("Seleccione su opcion");
		System.out.println("1. Clock-in and Clock-out");
		System.out.println("2. Payslip");
	}
    
  public void guardarInformacion(String nombreArchivo) {
  try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
    bw.write(toString());
    bw.flush();
  } catch (IOException e) {
    e.printStackTrace();
  }
}
    
}
