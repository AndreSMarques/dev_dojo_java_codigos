package academy.devdojo.maratonajava.introducao;

public class Aula08ArraysMultidimensionais01{
    public static void main(String[] args) {
        //ArraysMultidimensionais, são arrays de arrays,
        //então temos arrays linkados e podemos pecorrer todoos
        //Exemplo um array para os meses de ano e outro array para os dias do mês
        // 1,2,3,4,5,6,7 messes
        // 31, 28, 31, 30 dias 
        
        //Estrutura
        int[][] dias = new int[3][3];
        //atribuindo valor
        dias[0][0] = 31;
        dias[0][1] = 28;
        dias[0][2] = 31;

        dias[1][0] = 31;
        dias[1][1] = 28;
        dias[1][2] = 31;

        for (int i = 0; i < dias.length; i++) {
           for (int j = 0; j < dias[i].length; j++) {
            // o "dias[i]" serve para saber quntas pocisões no primeiro for 
            // ainda têm para pecorrer
            System.out.println(dias[i][j]); 
           }
        }
        System.out.println("-----------------");
        //Usando foreach para interar o ArratMultiDimensional
        for (int[] arrBase : dias) {
            for(int num: arrBase){
                System.out.println(num);
            }
        }
    }
}