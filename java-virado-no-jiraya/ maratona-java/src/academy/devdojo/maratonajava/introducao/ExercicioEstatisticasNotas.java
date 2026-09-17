package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

/*
    Crie um programa que gerencie as notas de uma turma de 5 alunos.
    Declare um array de double com tamanho 5 (ex: double[] notas = new double[5];).
    Use um laço for para pedir ao usuário que digite a nota de cada um dos 5 alunos 
    e guarde-as no array.Em seguida, 
    use outro laço (pode ser o enhanced for / foreach) para somar todas as notas 
    e calcular a média da turma.Ao final, exiba:
    A média da turma.Quantos alunos ficaram acima ou igual à média 7.0.
*/

public class ExercicioEstatisticasNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[5];
        double media = 0;
        int notasMedia = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Informe a nota do aluno:");
            notas[i] = scanner.nextDouble();
            if (notas[i] >= 7) {
                notasMedia ++;
            }
        }
        for (double d : notas) {
            media += d / 5;
        }


        System.out.println("A media de todos alunos foi " + media);
        System.out.println("O numero de alunos que tiraram notas maior ou na media foi " + notasMedia);
    }
}
