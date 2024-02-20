class HeapSort implements SortAlgoritmo {
    @Override
    public int[] ordenar(int[] numeros) {
        heapSort(numeros);
        return numeros;
    }

    public void heapSort(int arr[]) {
        int n = arr.length;

        // Construir un heap (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar al método heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializar el más grande como raíz
        int left = 2 * i + 1; // izquierda = 2*i + 1
        int right = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Si el más grande no es raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}
