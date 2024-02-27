import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Professor extends User {
    private Map<String, Double> historialPagos = new HashMap<>();
	private Map<String, Map<String, Double>> notasPorClase = new HashMap<>();


    @Override
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido Profesor");
            System.out.println("Seleccione su opción:");
            System.out.println("1. Ingresar notas de los estudiantes en una clase en específico");
            System.out.println("2. Cobrar pago");
            System.out.println("3. Historial de pagos");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    ingresarNotasEstudiantes();
                    break;
                case 2:
                    cobrarPago();
                    break;
                case 3:
                    historialPagos();
                    break;
                case 4:
                    System.out.println("Saliendo del menú del Profesor...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public void ingresarNotasEstudiantes() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de la clase:");
        String nombreClase = scanner.nextLine();

        if (!notasPorClase.containsKey(nombreClase)) {
            notasPorClase.put(nombreClase, new HashMap<>());
        }

        Map<String, Double> notasEstudiantes = notasPorClase.get(nombreClase);

        boolean continuarIngresando = true;
        while (continuarIngresando) {
            System.out.println("Ingrese el nombre del estudiante:");
            String nombreEstudiante = scanner.nextLine();

            System.out.println("Ingrese la nota del estudiante:");
            double notaEstudiante = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            notasEstudiantes.put(nombreEstudiante, notaEstudiante);

            System.out.println("¿Desea ingresar la nota de otro estudiante? (s/n)");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuarIngresando = false;
            }
        }

        System.out.println("Notas ingresadas con éxito.");

        scanner.close();
    }


    // Método para cobrar pago
    public void cobrarPago() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = scanner.nextLine();
        System.out.println("Ingrese el monto del pago:");
        double montoPago = scanner.nextDouble();
        historialPagos.put(nombreEstudiante, montoPago);
        System.out.println("Pago registrado exitosamente.");
        scanner.close();
    }

    // Método para mostrar el historial de pagos
    public void historialPagos() {
        System.out.println("Historial de pagos:");
        for (Map.Entry<String, Double> entry : historialPagos.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + ", Monto: " + entry.getValue());
        }
    }

    // Método de guardado de información
    
    public void guardarInformacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo para guardar la información:");
        String nombreArchivo = scanner.nextLine() + ".txt"; // Asegurarse de agregar la extensión .txt
        scanner.close();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("Historial de Pagos:\n");
            for (Map.Entry<String, Double> entry : historialPagos.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            bw.write("\nNotas por Clase:\n");
            for (Map.Entry<String, Map<String, Double>> entry : notasPorClase.entrySet()) {
                bw.write("Clase: " + entry.getKey() + "\n");
                Map<String, Double> notasEstudiantes = entry.getValue();
                for (Map.Entry<String, Double> nota : notasEstudiantes.entrySet()) {
                    bw.write("Estudiante: " + nota.getKey() + ", Nota: " + nota.getValue() + "\n");
                }
                bw.write("\n");
            }
            bw.flush();
            System.out.println("Información guardada correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
