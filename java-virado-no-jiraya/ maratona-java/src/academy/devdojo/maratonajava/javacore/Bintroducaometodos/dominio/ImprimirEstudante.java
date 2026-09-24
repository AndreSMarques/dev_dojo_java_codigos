package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class ImprimirEstudante {
    public void imprime(Estudante estudante){
        System.out.println("-------");

        System.out.println(estudante.nome);
        System.out.println(estudante.sexo);
        System.out.println(estudante.idade);
    }
}
