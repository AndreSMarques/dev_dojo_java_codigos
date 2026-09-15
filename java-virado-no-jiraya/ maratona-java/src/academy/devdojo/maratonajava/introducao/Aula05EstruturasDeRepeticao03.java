package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasDeRepeticao03 {
    public static void main(String[] args) {
        //Usando break
        //Imprima os primeiros 25 numeros de um dado valor. Por exemplo 50

        int valorMax = 50;
        int conut = 0;

        while (conut <= valorMax) {
            
            if (conut > 25) {
                break;
            }
            System.out.println("N" + conut);

            conut ++;
        }
    }
}
