import java.util.Scanner;

public class Employee extends User {

  @Override
  public void printMenu() {
    Scanner in = new Scanner(System.in);
    int opcion;

  do {
    System.out.println("Bienvenido");
    System.out.println("Seleccione su opción:");
    System.out.println("1. Crear Cursos");
    System.out.println("2. Crear Docentes");
    System.out.println("3. Crear Estudiantes");
    System.out.println("4. Asignar Estudiante a Curso");
    System.out.println("5. Asignar Catedrático a Curso");
    System.out.println("6. Asignar Pago a Catedrático");
    System.out.println("7. Resumen de Notas de Estudiantes");
    System.out.println("8. Resumen de Pagos de Estudiantes");
    System.out.println("9. Salir");

    opcion = in.nextInt();

    switch (opcion) {
      case 1:
        crearCurso();
        break;
      case 2:
        crearDocente();
        break;
      case 3:
        crearEstudiante();
        break;
      case 4:
        asignarEstudianteACurso();
        break;
      case 5:
        asignarCatedraticoACurso();
        break;
      case 6:
        asignarPagoACatedratico();
        break;
      case 7:
        resumenNotasEstudiantes();
        break;
      case 8:
        resumenPagosEstudiantes();
        break;
      case 9:
        System.out.println("Saliendo del sistema...");
        System.exit(0);
        break;
      default:
        System.out.println("Opción no válida. Intente de nuevo.");
        break;
    }
  } while (opcion != 0);
  in.close();
  }

  // Métodos de  cada opción en el menú

  private void crearCurso() {
    Scanner in = new Scanner(System.in);
    System.out.println("Ingrese el nombre del curso");
  }

  private void crearDocente() {
    // ...
  }

  private void crearEstudiante() {
    // ...
  }

  private void asignarEstudianteACurso() {
    // ...
  }

  private void asignarCatedraticoACurso() {
    // ...
  }

  private void asignarPagoACatedratico() {
    // ...
  }

  private void resumenNotasEstudiantes() {
    // ...
  }

  private void resumenPagosEstudiantes() {
    // ...
  }


}

   


  





