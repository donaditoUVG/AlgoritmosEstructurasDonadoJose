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
public class Professor extends User {

	@Override
	public void printMenu() {
		System.out.println("Bienvenido Profesor");
		System.out.println("Seleccione su opcion");
		System.out.println("1. Ingresar notas");
		System.out.println("2. Sincronizar contenido");
	}

	//Diferente implementación del método Guardarinfo
	public void guardarInformacion(String nombreArchivo) {
  try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
    bw.write(toString());
    bw.flush();
  } catch (IOException e) {
    e.printStackTrace();
  }
}
}
