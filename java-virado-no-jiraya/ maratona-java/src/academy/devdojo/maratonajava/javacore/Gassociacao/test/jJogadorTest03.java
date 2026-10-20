package academy.devdojo.maratonajava.javacore.Gassociacao.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Jogador;
import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Time;

public class jJogadorTest03 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Pelé");
        Time time = new Time("Brasil");
        Jogador[] jogadores = {jogador1};
        
        jogador1.setTime(time);

        time.setJogadores(jogadores);

        System.out.println("---jogador---");
        jogador1.imprimir();
        System.out.println("---time---");
        time.imprime();
    }
}
