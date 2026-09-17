package academy.devdojo.maratonajava.introducao;
import java.util.Scanner;
/*
Crie um programa que simule o menu de um caixa eletrônico.
O programa deve iniciar com um saldo fixo (ex: double saldo = 1000.00;).
Mostre um menu no console com as opções: 
1 - Verificar Saldo, 2 - Depositar, 3 - Sacar, 4 - Sair.
Use Scanner para ler a opção do usuário:
Se escolher 1: Mostre o saldo atual.Se escolher 2: Peça o valor do depósito, 
some ao saldo e mostre o novo saldo.Se escolher 3: Peça o valor do saque. 
Verifique se o usuário tem saldo suficiente. Se tiver, subtraia e mostre o saldo restante;
se não, mostre "Saldo Insuficiente".Se escolher 4: 
Mostre uma mensagem de despedida.Se escolher qualquer outro número: 
Mostre "Opção Inválida".
*/
public class ExercicioSistemaCaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldoCaixa = 1000;
        double valorDeposito = 0;
        double valorSaque = 0;
        int option = 0;

        
        do  {
            System.out.println("Escolha uma opção para continuar: ");
            System.out.print("1 - Verificar Saldo\n2 - Depositar\n3 - Sacar\n4 - Sair\n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(saldoCaixa);
                    break;
                case 2:
                    System.out.println("Informe o valor do deposito: ");
                    valorDeposito = scanner.nextDouble();
                    saldoCaixa += valorDeposito;
                    System.out.println("Valor depositado com sucesso.");
                    break;
                case 3:
                    System.out.println("Informe o valor da retirada:");
                    valorSaque = scanner.nextDouble();
                    if (valorSaque > saldoCaixa) {
                        System.out.println("Saldo Insuficiente");
                    }else {
                        saldoCaixa -= valorSaque;
                        System.out.println("Saque reqalizado, valor restante: " + saldoCaixa);
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (true);
            
        
    }
}
