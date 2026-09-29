package academy.devdojo.maratonajava.javacore.Csobrecargametodos.dominio;

public class Anime {
    private String nome;
    private String tipo;
    private int episodios;
    private String genero;

    public void init(String nome, String tipo, int episodios, String genero){
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
        this.genero = genero;
    }

    public void imprimir(){
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setEpisodios(int episodios){
        this.episodios = episodios;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome(){
        return  this.nome;
    }

    public String getTipo(){
        return this.tipo;
    }

    public  int getEpisodios(){
        return this.episodios;
    }

    public String getGenero() {
        return genero;
    }

}
