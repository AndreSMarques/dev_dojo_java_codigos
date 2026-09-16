package academy.devdojo.maratonajava.introducao;

public class Aula07Array02 {
    public static void main(String[] args) {
        //valor de inicialização do array, o que cada tipo têm 
        // byte, short, int, long, float e double 0
        //char '\u0000' espaço em branco
        //bolean false
        // String null
        
        // char[] teste1 = new char[1];
        // byte[] teste2 = new byte[1];
        // boolean[] teste3 = new boolean[1];
        // String[] teste4 = new String[1];

        // System.out.println(teste1[0]);
        // System.out.println(teste2[0]);
        // System.out.println(teste3[0]);
        // System.out.println(teste4[0]);


        //Interando no array com o for
        String[] nomes = new String[3];
        nomes[0] = "Goku";
        nomes[1] = "Gokuuu";
        nomes[2] = "Goky";
        

        for (int i = 0; i < 3; i++) {
            System.out.println(nomes[i]);
        }
    }
}
