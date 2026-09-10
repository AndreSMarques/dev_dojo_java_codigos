package academy.devdojo.maratonajava.introducao;

public class Aula01TiposPrimitivos {
    public static void main(String[] args) {
        // Int, double, float, char, byte, short, lang, boolean
        // criação de variavel: tipo nome - int number
        int age;
        // iniciar variavel "int age = 10;" usamos o "=" para atribuir
        int number = 10;
        System.out.println(number);
        //concatenar variaveis "a texto+ variavel+ texto"
        System.out.println("A idade é " + number);
        //tipos 
        double salarioDouble = 2000;
        float salarioFloat = 2000F;
        byte idadeByte = 10;
        short idadeShort = 10;
        boolean verdadeiro = true;
        boolean falso = false;
        long numeroGrande = 1000000 ;     
        char caractere = 'h';

        //casting: é força um tipo aceita o outro. TEnho um Long e quero que ele caiba no meu int, ele corta os bits para caber
        int numeroInt = (int) 100000000000L;
        
        
    }
}