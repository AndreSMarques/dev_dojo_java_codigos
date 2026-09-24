package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        funcionario.nome = "Cabron";
        funcionario.idade = 32;
        funcionario.salarios = new double[] { 1300, 2000, 6000 };

        funcionario.impimirDados();
    }
}
