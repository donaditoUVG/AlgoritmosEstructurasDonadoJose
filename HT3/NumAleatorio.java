import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


    public class NumAleatorio
    {
        public static void main(String[] args) {
            
            Random rando = new Random();
        //Crear el número aleatorio con ayuda de la clase Random 
        
        int i = 0;
        
        int [] nums = new int[3000]; //Arreglo 
      
        while (i < nums.length) {
            int randomNumber = rando.nextInt(10000);
            nums[i] = randomNumber;
            i++;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("numeros_aleatorios.txt"))) {
  for (int numero : nums) {
    bw.write(numero + "\n");
  }
} catch (IOException e) {
  e.printStackTrace();
}
        }
        
        

        //Imprimir el Número aleatorio 
    }




