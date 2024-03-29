import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Student extends User {
  private Map<String, String> registrosPagos = new HashMap<>();
  private Map<String, Double> cuotasPagadas = new HashMap<>();

  @Override
  public void printMenu() {
      Scanner in = new Scanner(System.in);
      int opcion;
      //Cuotas pagadas
      

      do {
          System.out.println("Bienvenido Alumno");
          System.out.println("Seleccione su opción");
          System.out.println("1. Revisar cursos");
          System.out.println("2. Consultar nota de una clase");
          System.out.println("3. Realizar Pago");
          System.out.println("5. Consultar Pagos");
          System.out.println("0. Salir");

          opcion = in.nextInt();
          in.nextLine(); // Limpiar el buffer del scanner

          switch (opcion) {
              case 1:
                  // Revisar cursos
                  revisarCursos();
                  break;
              case 2:
                  // Consultar nota de una clase
                  System.out.println("Ingrese el nombre de la clase: ");
                  String nombreClase = in.nextLine();
                  consultarNota(nombreClase);
                  break;
              case 3:
                  // Realizar Pago
                  realizarPago();
                  break;
              case 5:
                  // Consultar Pagos
                  consultarCuotasPagadas();
                  break;
              case 0:
                  // Salir
                  System.out.println("¡Hasta la vista, baby!");
                  break;
              default:
                  System.out.println("Opción no válida. Intente nuevamente.");
          }
      } while (opcion != 0);

      in.close();
  }

  public void guardarInformacion(String nombreArchivo) {
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {

          bw.write("Correo electrónico: " + getUsername());
          bw.newLine();
          bw.write("Contraseña: " + getPassword());
          bw.newLine();
          bw.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public void revisarCursos() {
      String cursos[];
      cursos = new String[3];
      cursos[0] = "Math";
      cursos[1] = "Data Science";
      cursos[2] = "Blue Label";

      for (int i = 0; i < cursos.length; i++) {
          System.out.println(cursos[i]);
      }
  }

  // Consultar Notas
  public void consultarNota(String nombreClase) {
      System.out.println("La nota obtenida para cada curso es de: ");
      String notas[];
      notas = new String[3];
      notas[0] = "Math: 90";
      notas[1] = "Data Science: 100";
      notas[2] = "Blue Label: 50";

      
    
    

      for (int i = 0; i < notas.length; i++) {
          System.out.println(notas[i]);
      }
  }

  
// Consultar Pagos
public void consultarPagos(String nombreEstudiante, double monto) {
  registrosPagos.put(nombreEstudiante, String.valueOf(monto));
}

// Método para consultar cuotas pagadas por un estudiante
public void consultarCuotaPagada(String nombreEstudiante) {
  if (cuotasPagadas.containsKey(nombreEstudiante)) {
      System.out.println("Cuota pagada por " + nombreEstudiante + ": " + cuotasPagadas.get(nombreEstudiante));
  } else {
      System.out.println("No se encontró ninguna cuota pagada para " + nombreEstudiante);
  }
}

// Consultar Cuotas Pagadas
public void consultarCuotasPagadas() {
  for (Map.Entry<String, Double> entry : cuotasPagadas.entrySet()) {
      System.out.println("Estudiante: " + entry.getKey() + ", Cuota Pagada: " + entry.getValue());
  }
}


  public void realizarPago() {
      Scanner in = new Scanner(System.in);

      System.out.println("Describa el tipo de pago que va a realizar: ");
      String descripcionPago = in.nextLine();

      System.out.println("Indique el monto del pago (puede incluir números decimales): ");
      String monto = in.nextLine();

      // Aquí podrías agregar lógica adicional, como registrar el pago en algún sistema de contabilidad o base de datos

      System.out.println("Ha pagado " + monto + " por: " + descripcionPago);

      registrosPagos.put(monto, descripcionPago);

      in.close();
  }
}