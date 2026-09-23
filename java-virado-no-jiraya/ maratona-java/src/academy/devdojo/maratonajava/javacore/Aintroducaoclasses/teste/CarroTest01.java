package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.teste;
/*
 Crie uma classe carro com os seguintes atributos
    Nome
    Modelo
    Ano
 Em seguida, crie dois obejetos distintos e imprima seus valores
 */

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro uno = new Carro();
        Carro celta = new Carro();

        uno.nome = "Uno Quadrado";
        uno.modelo = "Quadrado Flex";
        uno.ano = 1999;
        
        celta.nome = "Celtinha";
        celta.modelo = "flex";
        celta.ano = 2007;
        
        System.out.println("=======Carro 01=======");
        System.out.println("Carro-"+uno.nome+"\nModelo-"+uno.modelo +"\nAno-" + uno.ano );
        System.out.println("=======Carro 02=======");
        System.out.println("Carro-"+celta.nome+"\nModelo-"+celta.modelo +"\nAno-" + celta.ano );

    }
}
