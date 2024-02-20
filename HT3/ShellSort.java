class ShellSort implements SortAlgoritmo {
    @Override
    public int[] ordenar(int[] numeros) {
        shellSort(numeros);
        return numeros;
    }

    public void shellSort(int[] arr) {
        int n = arr.length;

        // Comienza con un espacio grande y reduce gradualmente el espacio
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            // Realiza la clasificación usando el método de inserción con el espacio actual
            for (int i = intervalo; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= intervalo && arr[j - intervalo] > temp; j -= intervalo) {
                    arr[j] = arr[j - intervalo];
                }

                arr[j] = temp;
            }
        }
    }
}
