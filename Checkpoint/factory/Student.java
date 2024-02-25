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
public class Student extends User {

	@Override
	public void printMenu() {
		System.out.println("Bienvenido Alumno");
		System.out.println("Seleccione su opcion");
		System.out.println("1. Revisar cursos");
		System.out.println("2. Subir tarea");
	}
	public void guardarInformacion(String nombreArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
      bw.write("Correo electrónico: " + getUsername());
      bw.newLine();
      bw.write("Contraseña: " + getUsername());
      bw.newLine();
	  bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

	
}
