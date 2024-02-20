class QuickSort implements SortAlgoritmo {
    @Override
    public int[] ordenar(int[] numeros) {
        sort(numeros, 0, numeros.length - 1);
        return numeros;
    }

    private int partition(int[] numeros, int bajo, int alto) {
        int pivot = numeros[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (numeros[j] < pivot) {
                i++;

                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }

        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[alto];
        numeros[alto] = temp;

        return i + 1;
    }

    private void sort(int[] numeros, int bajo, int alto) {
        if (bajo < alto) {
            int pi = partition(numeros, bajo, alto);

            sort(numeros, bajo, pi - 1);
            sort(numeros, pi + 1, alto);
        }
    }
}
