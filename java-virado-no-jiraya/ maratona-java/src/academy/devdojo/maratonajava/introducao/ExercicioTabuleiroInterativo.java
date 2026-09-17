package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

/*
    Crie um jogo simples onde o usuário tenta adivinhar um número secreto entre 1 e 20.
    O programa escolhe um número 
    (você pode deixar fixo como int numeroSecreto = 14; por enquanto).
    Use um laço de repetição para pedir os palpites do usuário continuamente.
    A cada palpite errado, o programa deve usar if/else para dizer 
    se o número secreto é maior ou menor que o palpite digitado.
    O laço só deve parar (break) quando o usuário acertar o número. 
    Ao final, exiba "Parabéns, você acertou!".

*/
public class ExercicioTabuleiroInterativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = 11;
        while (true) {
            System.out.println("informe o numero secreto");
            int numeroChute = scanner.nextInt();
            if (numeroSecreto == numeroChute) {
                System.out.println("Parabéns você acertou o numero!");
                break;
            } else if (numeroChute > numeroSecreto && numeroChute <= 20){
                System.out.println("O numero secreto é menor");
            } else if (numeroChute < numeroSecreto && numeroChute >= 1) {
                System.out.println("O numero secreto é maior");
            }else{
                System.out.println("Você deve informar um numero entre 1 e 20");
            }
        }
    }
}
