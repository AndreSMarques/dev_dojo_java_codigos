package academy.devdojo.maratonajava.introducao;

public class Aula04EstruturasCondicionais05 {
    public static void main(String[] args) {
        //Switch
        //Imprimir dia da semana, considerando 1 como domingo
        // dados que podem ser usados: "Char, int, byte, short, enum, String"
        int dia = 0;
        switch (dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}
