import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Implementación de user: Personal Administrativo (Employee)

public class Employee extends User {
  //Se utilizaran hashmap puesto que almacena en pares la información. Con ello se facilita relacionar cursos con docentes, por ejemplo.
    private Map<String, String> cursos = new HashMap<>();
    private Map<String, String> docentes = new HashMap<>();
    private Map<String, String> estudiantes = new HashMap<>();
    private Map<String, String> asignacionesEstudiantes = new HashMap<>();
    private Map<String, String> asignacionesCatedraticos = new HashMap<>();
    private Map<String, Double> pagosCatedraticos = new HashMap<>();
    private Map<String, String> resumenNotasEstudiantes = new HashMap<>();
    private Map<String, Double> resumenPagosEstudiantes = new HashMap<>();

    @Override
    public void printMenu() {
        Scanner in = new Scanner(System.in);
        int opcion;
//Menu
        do {
            System.out.println("Bienvenido");
            System.out.println("Seleccione su opción:");
            System.out.println("1. Asignar Cursos");
            System.out.println("2. Registrar Docentes");
            System.out.println("3. Registrar Estudiantes");
            System.out.println("4. Asignar Estudiante a Curso");
            System.out.println("5. Asignar Catedrático a Curso");
            System.out.println("6. Registrar un Pago al Catedrático");
            System.out.println("7. Resumen de Notas de Estudiantes");
            System.out.println("8. Resumen de Pagos de Estudiantes");
            System.out.println("9. Salir");

            opcion = in.nextInt();
            in.nextLine(); // lin

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
                  registrarPagoACatedratico();
                    break;
                case 7:
                    resumenNotasEstudiantes();
                    break;
                case 8:
                    resumenPagosEstudiantes();
                    break;
                case 9:
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 9);
        in.close();
    }

    //Métodos Auxiliares

    /**
     * @param
     * añadir un curso
     */
    private void crearCurso() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del curso:");
        String nombreCurso = in.nextLine();
        System.out.println("Ingrese la descripción del curso:");
        String descripcionCurso = in.nextLine();
        cursos.put(nombreCurso, descripcionCurso);
        System.out.println("Curso añadido.");
        in.close();
    }

    /**
     * registrar a un profesor
     */
    private void crearDocente() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del docente:");
        String nombreDocente = in.nextLine();
        System.out.println("Ingrese el departamento del docente:");
        String departamentoDocente = in.nextLine();
        docentes.put(nombreDocente, departamentoDocente);
        System.out.println("Docente creado con éxito.");
        in.close();
    }

    /**
     * registrar a un estudiante
     */
    private void crearEstudiante() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = in.nextLine();
        System.out.println("Ingrese la carrera del estudiante:");
        String carreraEstudiante = in.nextLine();
        estudiantes.put(nombreEstudiante, carreraEstudiante);
        System.out.println("Estudiante creado con éxito.");
        in.close();
    }

    /**
     * asignación del estudiante
     */
    private void asignarEstudianteACurso() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = in.nextLine();
        System.out.println("Ingrese el nombre del curso:");
        String nombreCurso = in.nextLine();
        asignacionesEstudiantes.put(nombreEstudiante, nombreCurso);
        System.out.println("Estudiante asignado al curso con éxito.");
        in.close();
    }

    /**
     * asignación del profe
     */

    private void asignarCatedraticoACurso() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del catedrático:");
        String nombreCatedratico = in.nextLine();
        System.out.println("Ingrese el nombre del curso:");
        String nombreCurso = in.nextLine();
        asignacionesCatedraticos.put(nombreCatedratico, nombreCurso);
        System.out.println("Catedrático asignado al curso con éxito.");
        in.close();
    }

    /**
     * Registrar el pago del Catedrático
     */
    private void registrarPagoACatedratico() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del catedrático:");
        String nombreCatedratico = in.nextLine();
        System.out.println("Ingrese el monto del pago:");
        double montoPago = in.nextDouble();
        pagosCatedraticos.put(nombreCatedratico, montoPago);
        System.out.println("Pago asignado al catedrático con éxito.");
        in.close();
    }

    /**
     * Métodos de resumen
     */
    private void resumenNotasEstudiantes() {
        System.out.println("Resumen de Notas de Estudiantes:");
        for (Map.Entry<String, String> entry : resumenNotasEstudiantes.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Nota: " + entry.getValue());
        }
    }

    private void resumenPagosEstudiantes() {
        System.out.println("Resumen de Pagos de Estudiantes:");
        for (Map.Entry<String, Double> entry : resumenPagosEstudiantes.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Pago: " + entry.getValue());
        }
    }
}
