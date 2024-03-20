/**
 * HashMap: Los elementos que inserta en el map no tendrán un orden específico. No aceptan claves duplicadas ni valores nulos.
TreeMap: El Mapa lo ordena de forma "natural". Por ejemplo, si la clave son valores enteros (como luego veremos), los ordena de menos a mayor.
LinkedHashMap: Inserta en el Map los elementos en el orden en el que se van insertando; 
es decir, que no tiene una ordenación de los elementos como tal, por lo que esta clase realiza las búsquedas de los 
elementos de forma más lenta que las demás clases.
 */
/**
 * @author Jose Donado
 */

 import java.io.File;

 import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Mostrar opciones de configuración al usuario
        int mapOption = selectMapImplementation();

        // Crear fábrica de mapa
        MapFactory mapFactory = new MapFactory();

        // Seleccionar implementación de mapa
        Map<String, Student> studentMap = mapFactory.getMap(mapOption);

        // Mostrar los datos de los estudiantes
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println("Clave: " + entry.getKey());
            System.out.println("Estudiante: " + entry.getValue());
        }
    }

    private static int selectMapImplementation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación del Map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Opción: ");
        int option = scanner.nextInt();
        scanner.close();
        return option;
    }
}

class MapFactory {
    public Map<String, Student> getMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
}







