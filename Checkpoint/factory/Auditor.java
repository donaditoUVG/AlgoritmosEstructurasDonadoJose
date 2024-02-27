import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Auditor extends User {
    private Map<String, Double> cuotasPagadasEstudiantes = new HashMap<>();
    private Map<String, Double> pagosDocentes = new HashMap<>();

    @Override
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido, Auditor. Escriba su nombre:");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Revisar cuotas pagadas de los estudiantes");
            System.out.println("2. Revisar los pagos para docentes");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    revisarCuotasPagadasEstudiantes();
                    break;
                case 2:
                    revisarPagosDocentes();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema de auditoría...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    public void guardarInformacion(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarCuotaEstudiante(String nombreEstudiante, double monto) {
        cuotasPagadasEstudiantes.put(nombreEstudiante, monto);
    }

    public void agregarPagoDocente(String nombreDocente, double monto) {
        pagosDocentes.put(nombreDocente, monto);
    }

    public void revisarCuotasPagadasEstudiantes() {
        System.out.println("Cuotas pagadas de los estudiantes:");
        for (Map.Entry<String, Double> entry : cuotasPagadasEstudiantes.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Cuota Pagada: " + entry.getValue());
        }
    }

    public void revisarPagosDocentes() {
        System.out.println("Pagos para docentes:");
        for (Map.Entry<String, Double> entry : pagosDocentes.entrySet()) {
            System.out.println("Docente: " + entry.getKey() + ", Pago: " + entry.getValue());
        }
    }
}
