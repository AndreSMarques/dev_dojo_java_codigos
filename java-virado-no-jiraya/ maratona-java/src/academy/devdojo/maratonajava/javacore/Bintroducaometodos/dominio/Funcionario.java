package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {
    public String nome;
    public int idade;
    public double[] salarios;

    public void impimirDados() {
        System.out.println("Nome " + this.nome);
        System.out.println("Idade " + this.idade);
        if (salarios != null) {
            for (double i : salarios) {
                System.out.print("Salario:" + i + " ");
            }
        }
        mediaSalarios();
    }

    public void mediaSalarios() {
        double media = 0;
        if (salarios != null) {
            for (double i : salarios) {
                media += i;
            }
            System.out.println("\nmedia: " + media / salarios.length);
        }
    }
}
