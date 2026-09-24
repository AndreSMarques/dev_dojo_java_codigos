package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        

        estudante01.nome = "Malma";
        estudante01.idade = 21;
        estudante01.sexo = 'F';
        
        estudante02.nome = "Malmo";
        estudante02.idade = 23;
        estudante02.sexo = 'M';

        estudante01.imprime();
        estudante02.imprime();
    }
}
