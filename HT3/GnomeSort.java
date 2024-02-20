class GnomeSort implements SortAlgoritmo {
    @Override
    public int[] ordenar(int[] numeros) {
        int posicion = 1;
        while (posicion < numeros.length) {
            if (numeros[posicion] >= numeros[posicion - 1]) {
                posicion++;
            } else {
                int temp = numeros[posicion];
                numeros[posicion] = numeros[posicion - 1];
                numeros[posicion - 1] = temp;
                if (posicion > 1) {
                    posicion--;
                }
            }
        }
        return numeros;
    }
}