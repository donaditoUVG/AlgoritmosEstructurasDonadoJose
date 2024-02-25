import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Auditor extends User{
    @Override
    public void printMenu() {
        System.out.println("Bienvenido, Auditor. Escriba su nombre:");
        System.out.println("Seleccione una opción");
		System.out.println("1. Revisar notas de estudiantes");
		System.out.println("2. Revisar coutas pagadas de los estudiantes");
        System.out.println("3. Revisar los pagos para docentes");
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
