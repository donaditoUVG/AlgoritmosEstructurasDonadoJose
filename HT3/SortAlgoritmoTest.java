import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//Tests para cada implementación de SortAlgoritmoo
public class SortAlgoritmoTest {

    //La lógica es la misma para cada test: se presenta un array desordenado y es espera un array ordenado. Solamente se trata con valores numéricos 
    //que pertenecen a Z tal que están entre 0 y 10,000.

    @Test
    void testGnomeSort() {
        SortAlgoritmo algoritmo = new GnomeSort();
        int[] numeros = {4, 5, 1};
        int[] expected = {1, 4, 5};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testMergeSort() {
        SortAlgoritmo algoritmo = new MergeSort();
        int[] numeros = {5, 44, 1, 2, 89};
        int[] expected = {1, 2, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testQuickSort() {
        SortAlgoritmo algoritmo = new QuickSort();
        int[] numeros = {5, 44, 1, 2, 89, 4};
        int[] expected = {1, 2, 4, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testRadixSort() {
        SortAlgoritmo algoritmo = new RadixSort();
        int[] numeros = {5, 44, 1, 2, 89, 4};
        int[] expected = {1, 2, 4, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testSelectionSort() {
        SortAlgoritmo algoritmo = new SelectionSort();
        int[] numeros = {5, 44, 1, 2, 89, 4};
        int[] expected = {1, 2, 4, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testShellSort() {
        SortAlgoritmo algoritmo = new ShellSort();
        int[] numeros = {5, 44, 1, 2, 89, 4};
        int[] expected = {1, 2, 4, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }

    @Test
    void testHeapSort() {
        SortAlgoritmo algoritmo = new HeapSort();
        int[] numeros = {5, 44, 1, 2, 89, 4};
        int[] expected = {1, 2, 4, 5, 44, 89};
        assertArrayEquals(expected, algoritmo.ordenar(numeros));
    }
    //Fin de los stest
}
