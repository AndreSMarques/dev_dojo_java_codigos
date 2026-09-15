package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasDeRepeticao01 {
    public static void main(String[] args) {
        //Estruturas de repitações
        // while, do while, for 
        int count = 0;
        while (count < 10) {
            System.out.println(count);
            count ++;
        }

        count = 0;
        do {
            System.out.println("dentro do do-while" + ++count);
        } while (count < 10);

        for (int i = 0; i < 10; i++) {
            System.out.println("for" + i);
        }
    }
}
