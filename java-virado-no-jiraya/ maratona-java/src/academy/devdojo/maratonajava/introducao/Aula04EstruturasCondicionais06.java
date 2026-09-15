package academy.devdojo.maratonajava.introducao;

public class Aula04EstruturasCondicionais06 {
    public static void main(String[] args) {
      //Exercicio
      //Dados os valores de 1 a 7, imprima se é dia útil ou final de semana
      //considerando 1 como domigo  
        int dia = 6;
        switch (dia){
            case 1, 7:
                System.out.println("Final Semana");
                break;
            case 2, 3, 4, 5, 6:
                System.out.println("Dia útil");
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}
