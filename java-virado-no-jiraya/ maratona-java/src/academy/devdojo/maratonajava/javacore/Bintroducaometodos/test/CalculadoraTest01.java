package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.somaDoisNumeros();
        calculadora.subtraiDoisNumeros();
        calculadora.MultiplicaDoisNumeros(20, 10);
        System.out.println(calculadora.divideDoisNumeros(1, 0));
        calculadora.imprimirDivisaoDeDoisNuemros(30, 0);
    }
}
