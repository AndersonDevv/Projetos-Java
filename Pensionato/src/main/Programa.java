package main;

import java.util.Scanner;

import entidades.Quarto;

public class Programa {

	public static void main(String[] args) {
		
		/*A dona de um pensionato possui 10 quartos para alugar para estudantes.
		 * Os quartos possuem numera��o de 1 a 10.
		 * 
		 * Fa�a um programa que:
		 * - Inicie os 10 quartos vazios;
		 * - Leia uma quantidade N de quartos que ser�o alugados
		 * - Fa�a o registro de cada aluguel: receber nome e email e quarto escolhido
		 * - Caso n�o se queira mais fazer ocupa��es, imprimir relat�rio dos quartos ocupados
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem-vindo ao Pensionato ABC");
		
		Quarto vet[] = new Quarto[10];
		boolean reservar = true;
		
		do{
			int quartosLivres = verificarQuartosLivres(vet);
			
			if(quartosLivres == 0) {
				reservar = false;
				System.out.println("N�o h� mais quartos livres. O programa ser� encerrado");
			}
			else {
				System.out.println("Estes s�o os quartos livres");
				mostrarQuartos(vet);
				
				System.out.println("\nVoc� deseja fazer reservas? S/N");
				char resposta = scanner.next().charAt(0);
				
				if(resposta=='S' || resposta == 's') {
					System.out.println("Quartos quartos deseja reservar?");
					int quartos = scanner.nextInt();
					
					while(quartos > verificarQuartosLivres(vet)) {
						System.out.println("N�o temos esse total de quartos livres. Por favor,"
								+ "escolha um n�mero menor");
						mostrarQuartos(vet);
						quartos = scanner.nextInt();
					}
					
					for (int i = 0; i < quartos; i++) {
						mostrarQuartos(vet);
						System.out.print("Voc� escolheu reservar "+quartos+" quartos");
						System.out.println("Vamos iniciar a reserva do seu "+(i+1)+"� quarto");
						
						System.out.println("Qual o n�mero do quarto que deseja reservar?");
						int num = scanner.nextInt();
						scanner.nextLine();
						
						System.out.println("Qual o nome do estudante que ir� reservar?");
						String nome = scanner.nextLine();
						
						System.out.println("Qual � o email do estudante "+nome+"?");
						String email = scanner.nextLine();
						
						vet[num-1] = new Quarto(nome, email, num);
						
;					}
					
				}
				else {
					System.out.println("O programa ser� encerrado. Obrigado");
					reservar = false;
				}
			}
			
		}while(reservar);
		
		mostrarRelatorio(vet);

	}

	private static int verificarQuartosLivres(Quarto vetor[]) {
		int contadorNulos =0;
		
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] ==null){
				contadorNulos+=1;
			}
		}
		return contadorNulos;
	}
	
	private static void mostrarQuartos(Quarto quarto[]) {
		for (int i = 0; i < quarto.length; i++) {
			if(quarto[i] == null) {
				System.out.print("Quarto N� "+(i+1) + " |");
			}
		}
	}

	private static void mostrarRelatorio(Quarto vet[]) {
		
		String relatorio ="Relat�rio de ocupa��o de quartos\n";
		
		for (int i = 0; i < vet.length; i++) {
			
			if(vet[i] != null) {
				relatorio+="-------------------------------\n";
				relatorio +="Quarto "+(i+1)+" - ocupado por "+vet[i].getOcupante() + " | email: "+vet[i].getEmail()+"\n";
			}
		}
		System.out.println(relatorio);
	}

}
