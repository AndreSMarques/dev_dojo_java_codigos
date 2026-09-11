package academy.devdojo.maratonajava.introducao;

public class Aula04EstruturasCondicionais03 {
    public static void main(String[] args) {
        // Operador ternário
        double salario = 3000;
        String mensagemDoar = "Doar money";
        String mensagemNaoDoat = "SEm condições, mas vou ter!";
        //Operador ternario, guarda o resultado em um lugar, geralmente uma string
        // estrutura do operador ternario  variavel = condição ? verdaeiro : falso
        String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoat;

        System.out.println(resultado);

        //ternario com else if
        int idade = 17;
        String categoria = idade < 15 ? "Categoria Infatil" : idade >= 15 && idade < 18 ? "Categoria Juvenil" : "Categoria Adulto";
        System.out.println(categoria);


    }
}
