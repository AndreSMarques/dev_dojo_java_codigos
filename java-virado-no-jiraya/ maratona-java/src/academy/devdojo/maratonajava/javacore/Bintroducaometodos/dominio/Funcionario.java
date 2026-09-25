package academy.devdojo.maratonajava.javacore.Bintroducaometodos.dominio;

public class Funcionario {
    private  String nome;
    private int idade;
    private double[] salarios;
    private double media = 0;

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
        
        if (salarios != null) {
            for (double i : salarios) {
                media += i;
            }
            System.out.println("\nmedia: " + media / salarios.length);
        }
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public double[] getSalarios() {
        return salarios;
    }

    public double getMedia() {
        return media;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarios(double[] salarios) {
        this.salarios = salarios;
    }

}
