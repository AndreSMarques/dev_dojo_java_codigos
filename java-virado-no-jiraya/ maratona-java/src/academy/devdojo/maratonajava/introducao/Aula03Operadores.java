package academy.devdojo.maratonajava.introducao;

public class Aula03Operadores {
    public static void main(String[] args) {
        // Operadores aritimeticos
        // " + - / * "
        int number1 = 10;
        int number2 = 20;

        System.out.println(number2 + number1);
        System.out.println(number2 - number1);
        System.out.println(number2 / number1);
        System.out.println(number2 * number1);

        //Operadores Relacionais
        // Resto " % "
        int resto = 21 % 7;
        System.out.println(resto);

        // "< menor"; "> maior"; "<= menor igual"; ">= maior igual"; "== igual"; "!= diferente";
        // eles retornam valores boleanos
        //Dica, quando trabalhos com boolean usamos "is"
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezMaiorIgualQueVinte = 10 >= 20;
        boolean isDezMenorIgualQueVinte = 10 <= 20;
        boolean isDezIgualQueVinte = 10 == 20;
        boolean isDezdDiferenteQueVinte = 10 != 20;
        System.out.println(isDezMaiorQueVinte);
        System.out.println(isDezMenorQueVinte);
        System.out.println(isDezMaiorIgualQueVinte);
        System.out.println(isDezMenorIgualQueVinte);
        System.out.println(isDezIgualQueVinte);
        System.out.println(isDezdDiferenteQueVinte);

        // operadores logicos

        // && (AND)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade > 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario > 3381;

        System.out.println(isDentroDaLeiMaiorQueTrinta);
        System.out.println(isDentroDaLeiMenorQueTrinta);


        // || (OR)
        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlay = 5000F;
        boolean isPlayCompravel =  valorTotalContaCorrente > valorPlay || valorTotalContaPoupanca > valorPlay;
        System.out.println(isPlayCompravel);

        // Operadores de atibuição
        // = += -= /= *=

        //Incremetador ++ se vier primeiro ele adicionar primeiro, se vim depois ele adiciona depois 
        int contador = 0;
        contador += 1;
        contador++;
        contador--;
        ++contador;
        --contador;
        System.out.println(contador);
        int contador2 = 0;
        System.out.println(contador2++);
        System.out.println(contador2);
    }
}
