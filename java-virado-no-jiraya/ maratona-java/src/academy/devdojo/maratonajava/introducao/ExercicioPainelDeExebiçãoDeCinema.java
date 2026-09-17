package academy.devdojo.maratonajava.introducao;

/*
Simule o mapa de assentos de uma pequena sala de cinema usando uma matriz.
Crie uma matriz de inteiros com 3 linhas e 4 colunas 
(int[][] assentos = new int[3][4];). 
O valor 0 representa assento livre e 1 representa ocupado.
Inicialize a matriz ocupando alguns assentos manualmente 
(ex: assentos[0][2] = 1;, assentos[1][1] = 1;).
Use laços for aninhados (um dentro do outro) para desenhar a sala no console 
de forma visual. 
Exemplo de saída esperada:
[ 0 ] [ 0 ] [ 1 ] [ 0 ]
[ 0 ] [ 1 ] [ 0 ] [ 0 ]
[ 0 ] [ 0 ] [ 0 ] [ 0 ]
*/

public class ExercicioPainelDeExebiçãoDeCinema {
    public static void main(String[] args) {
        int[][] assentos = new int[3][4];
        assentos[0][2] = 1;
        assentos[1][1]= 1;

        for (int i = 0; i < assentos.length; i++) {
            
            for (int j = 0; j < assentos[i].length; j++) {
                System.out.print("[" + assentos[i][j] + "]");
            }
            System.out.println(" ");
        }
    }
}
