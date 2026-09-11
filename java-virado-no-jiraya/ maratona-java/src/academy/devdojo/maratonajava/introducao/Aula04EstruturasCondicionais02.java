package academy.devdojo.maratonajava.introducao;

public class Aula04EstruturasCondicionais02 {
    public static void main(String[] args) {
       // else if
       //idade < 15 categoria juvenil
       //idade >= 15 && idade < 18 categoria Juvenil  
       //idade >= 18 categoria adulto

       int idade = 17;
        String categoria;

       if(idade < 15){
        categoria ="Categoria Infantil";
       }else if (idade >= 15 && idade < 18) {
        categoria ="Categoria juvenil";
       }else {
        categoria ="Categoria Aduldo";
       }

       System.out.println(categoria);
    }
}
