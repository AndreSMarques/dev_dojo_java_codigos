package academy.devdojo.maratonajava.introducao;

public class Aula07Array03 {
    public static void main(String[] args) {
        int[] numeros = new int[3];
        //iniciando um array com valores
        int[] numeros2 = {1,2,3,4,5};
        //outra forma de iniciar com os valores
        int[] numeros3 = new int[]{1,3,4,5}; 

        // for (int i = 0; i <=numeros2.length; i++) {
        //     System.out.println(numeros2[i]);
        // }

        // for (int i = 0; i <=numeros3.length; i++) {
        //     System.out.println(numeros3[i]);
        // }

        //foreach, uma nova forma de imprimir o array
        for(int num: numeros3){
            System.out.println(num);
        }
    }
}
