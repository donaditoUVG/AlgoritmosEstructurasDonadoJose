
class MergeSort implements SortAlgoritmo {
    @Override
    public int[] ordenar(int[] numeros) {
        sort(numeros, 0, numeros.length - 1);
        return numeros;
    }

    private void merge(int[] numeros, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izq = new int[n1];
        int[] der = new int[n2];

        for (int i = 0; i < n1; ++i) {
            izq[i] = numeros[izquierda + i];
        }
        for (int j = 0; j < n2; ++j) {
            der[j] = numeros[medio + 1 + j];
        }

        int i = 0, j = 0;

        int k = izquierda;
        while (i < n1 && j < n2) {
            if (izq[i] <= der[j]) {
                numeros[k] = izq[i];
                i++;
            } else {
                numeros[k] = der[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            numeros[k] = izq[i];
            i++;
            k++;
        }

        while (j < n2) {
            numeros[k] = der[j];
            j++;
            k++;
        }
    }

    private void sort(int[] numeros, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            sort(numeros, izquierda, medio);
            sort(numeros, medio + 1, derecha);

            merge(numeros, izquierda, medio, derecha);
        }
    }
}

