import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    public static Map<String, Student> getMap(int option) {
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
