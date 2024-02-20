import java.io.*;
import java.util.*;

/**
 * @author Jose Donado
 * @carnet 22684
 */
public class Main {

    public static void main(String[] args) {
        // Generar números aleatorios y guardarlos en un archivo
        generarArchivoNumeros();

        // Leer los números del archivo y almacenarlos en un arreglo
        int[] numeros = leerArchivoNumeros("numerosAleatorios.txt");

        // Mostrar Menú al Usuario
        System.out.println("\n------ Eficiencia y Complejidad de los Algoritmos de Ordenamiento ------");
        System.out.println("              ------ Por: José Pablo Donado López ------\n");

        Scanner in = new Scanner(System.in);
            //Imprimir Menu
            

            //Manejar los comandos del Usuario:
            boolean quit = false;
            int itemMenu;
            do {
                System.out.println("Seleccione un Ordenamiento (escriba un número del 1-9).");
                System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Selection Sort");
            System.out.println("6. Shell Sort");
            System.out.println("7. Heap Sort");
            System.out.println("0. Salir del Programa");

                itemMenu = in.nextInt ();
                switch (itemMenu) {
                    case 1:
                    int[] numerosOrdenadosGnome = aplicarAlgoritmoOrdenamiento(new GnomeSort(), numeros.clone());
                        System.out.println("Números ordenados con Gnome Sort: " + Arrays.toString(numerosOrdenadosGnome)); 
                    
                        break;
                    case 2:
                    int[] numerosOrdenadosMerge = aplicarAlgoritmoOrdenamiento(new MergeSort(), numeros.clone());
                        System.out.println("Números ordenados con Merge Sort: " + Arrays.toString(numerosOrdenadosMerge));
        
                        break;
                    case 3:
                    int[] numerosOrdenadosQuick = aplicarAlgoritmoOrdenamiento(new QuickSort(), numeros.clone());
                    System.out.println("Números ordenados con Quick Sort: " + Arrays.toString(numerosOrdenadosQuick));
        
                        break;
                    case 4: 
                        int[] numerosOrdenadosRadix = aplicarAlgoritmoOrdenamiento(new RadixSort(), numeros.clone());
                        System.out.println("Números ordenados con Radix Sort: " + Arrays.toString(numerosOrdenadosRadix));
        
                        break;
                    case 5: 
                        int[] numerosOrdenadosSelection = aplicarAlgoritmoOrdenamiento(new SelectionSort(), numeros.clone());
                        System.out.println("Números ordenados con Selection Sort: " + Arrays.toString(numerosOrdenadosSelection));
        
                        break;
                    case 6:
                        int[] numerosOrdenadosShell = aplicarAlgoritmoOrdenamiento(new ShellSort(), numeros.clone());
                        System.out.println("Números ordenados con Shell Sort: " + Arrays.toString(numerosOrdenadosShell));
                        break;
                    case 7:
                        int[] numerosOrdenadosHeap = aplicarAlgoritmoOrdenamiento(new HeapSort(), numeros.clone());
                        System.out.println("Números ordenados con Heap Sort: " + Arrays.toString(numerosOrdenadosHeap));

                        break;

                    case 0:
                        quit = true;
                        break;
                    
                    default:
                        System.out.println("Opción INVALIDA. ESCOGE OTRA");
                        break;
                }
            } while (!quit);
            System.out.println("Hasta la vista, baby.");
            in.close();

    }

    // Generar números aleatorios y guardarlos en un archivo
    public static void generarArchivoNumeros() {
        try {
            FileWriter fileWriter = new FileWriter("numerosAleatorios.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int numero = random.nextInt(10001); // Límite: 10,000
                bufferedWriter.write(numero + "\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer los números del archivo y almacenarlos en un arreglo
    public static int[] leerArchivoNumeros(String nombreArchivo) {
        List<Integer> numerosList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                numerosList.add(numero);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertir la lista de números a un arreglo
        int[] numeros = new int[numerosList.size()];
        for (int i = 0; i < numerosList.size(); i++) {
            numeros[i] = numerosList.get(i);
        }

        return numeros;
    }

    // Aplicar un algoritmo de ordenamiento y devolver el arreglo ordenado
    public static int[] aplicarAlgoritmoOrdenamiento(SortAlgoritmo sortAlgoritmo, int[] numeros) {
        return sortAlgoritmo.ordenar(numeros);
    }
}

//Interfaz para los Algoritmos de Sorting
interface SortAlgoritmo {
    int[] ordenar(int[] numeros);
}

