package academy.devdojo.maratonajava.introducao;

public class Aula04EstruturasCondicionais01 {
    public static void main(String[] args) {
        //Vendo o funcionamento do if
        int idade = 15;
        boolean isAutorizadoComprarBebida = idade >= 18;

        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado");
        }
        
        //Usando operador de negação "!"
        if (!isAutorizadoComprarBebida) {
            System.out.println("Negado");
        }

        boolean c = false;
        if (c == true) {
            System.out.println("Dentro de algo que nunca deve ser feito");
        }
        System.out.println("Fora dos if");

        //if e else
        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado");
        }else {
            System.out.println("Negado com ELSE");
        }

        //else if
        

    }
}
