package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasDeRepeticao04 {
    public static void main(String[] args) {
        //Exercicio
        //Dado o valor de um carr, decubra em quantas vezes ele pode ser parcelado
        //condição: valorParcela >=1000

        double valorTotal = 30000;
        for (int i = 1; i <= valorTotal ; i++) {
            double valorParcela = valorTotal / i;
            // if (valorParcela >=1000) {
            //     System.out.println("Parcela " + i + "R$" + valorParcela);
            // }else{
            //     break;
            // }
            if (valorParcela < 1000){
                break;
            }
            System.out.println("Parcela " + i + "R$" + valorParcela);
        }
    }
}
