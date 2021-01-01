package Main;

import java.util.Locale;
import java.util.Scanner;

import entidades.Conta;

public class Programa {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Entre com o número da conta: ");
		int number = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.println("Entre com o nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Há depósito inicial? S/N");
		char resposta = scanner.next().charAt(0);
		
		Conta conta;
		
		if(resposta=='s' || resposta =='S') {
			System.out.println("Digite o valor inicial de depósito: ");
			double depositoInicial = scanner.nextDouble();
			
			conta = new Conta(number, nome, depositoInicial);
		}
		
		else {
			conta = new Conta(number,nome);
		}
		
		System.out.println("\n=====ACCONT DATA=====");
		System.out.println(conta);
		
		
		// ====== DEPÓSITO =====
		System.out.println();
		System.out.print("Digite um valor para depósito");
		double valorDeposito = scanner.nextDouble();
		conta.deposit(valorDeposito);
		System.out.println(conta);
		
		// ====== SAQUE =====
		System.out.println();
		System.out.print("Digite um valor para saque");
		double valorRetirada = scanner.nextDouble();
		conta.withdraw(valorRetirada);
		System.out.println(conta);
		
		scanner.close();
	}

}


