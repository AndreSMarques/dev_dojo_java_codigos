package academy.devdojo.maratonajava.introducao;

/*
    Crie um programa que filtre dados de um array.
    Declare um array de inteiros pré-definido: 
    int[] numeros = {12, 5, 8, 21, 33, 4, 18, 15, 2};
    Use um laço for para percorrer este array.
    Dentro do laço, use a instrução continue para ignorar os números que forem ímpares.
    Imprima na tela apenas os números pares encontrados no array.
*/

public class ExercicioFiltroDeNumeros {
    public static void main(String[] args) {
        int[] numeros = {12, 5, 8, 21, 33, 4, 18, 15, 2};

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 1) {
                continue;
            }
            System.out.println(numeros[i]);
        }
    }
}
