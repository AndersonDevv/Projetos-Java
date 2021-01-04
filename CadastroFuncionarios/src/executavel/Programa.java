package executavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		
		/*
		 * Fa�a um programa que leia um n�mero inteiro N e depois dados (id,nome e salario)
		 *de N funcion�rios. N�o deve haver repeti��o de ID.

		 *Em seguida, efetuar o aumento de X% no salario de um determinado funcionario

		 *Para isso, o programa deve ler um ID e o valor X.
		 *Se o ID n�o existir, mostrar uma mensagem e abortar a opera��o.
		 *Ao final, mostrar a listagem atualziada dos funcionarios.
		 */
		Scanner scanner = new Scanner(System.in);
		
		List <Funcionario> listaFuncionarios = new ArrayList<>();
		
		System.out.println("========CADASTRO DE FUNCION�RIOS========");
		
		System.out.println("Quantos funcion�rios deseja cadastrar?");
		int qtdFuncionarios = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i<qtdFuncionarios; i++) {
			System.out.println("Vamos cadastrar o funcion�rio "+(i+1));
			System.out.print("Digite o nome:");
			String nome = scanner.nextLine();
			
			System.out.print("Digite o ID:");
			int id = scanner.nextInt();
			
			int contadorId;
			do {
				contadorId=0;
				
				for(int j = 0; j<listaFuncionarios.size();j++) {
					if(listaFuncionarios.get(j).getId()==id) {
					contadorId++;
					}
				}
				if(contadorId >0) {
					System.out.println("Id em uso! Adicione um iD diferente");
					id = scanner.nextInt();
					scanner.nextLine();
				}
				
			}while(contadorId >0);
			System.out.print("Digite o salario:");
			double salario = scanner.nextDouble();
				
			Funcionario func = new Funcionario(nome, salario, id);
			
			listaFuncionarios.add(func);
			scanner.nextLine();
			
		}
		
		System.out.print("========MODIFICA��O DE SAL�RIO DE FUNCION�RIOS=======");
		System.out.println("Dados do sistema");
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			System.out.println("Nome: "+listaFuncionarios.get(i).getNome()
					+" ID: "+listaFuncionarios.get(i).getId()
					+" Sal�rio: R$"+listaFuncionarios.get(i).getSalario());
		}
		
		System.out.println("Qual funcion�rio voc� deseja modificar o sal�rio? Digite o respectivo ID");
		int id = scanner.nextInt();
		
		boolean achou = false;
		int posicao = 0;
		
		for(int i = 0; i<listaFuncionarios.size();i++) {
			
			if(listaFuncionarios.get(i).getId()==id){
				achou = true;
				posicao = i;
			}
		}
		
		if(achou) {
			System.out.println("Voc� deseja mudar o sal�rio de "+listaFuncionarios.get(posicao).getNome()+", certo?");
		
			System.out.println("Digite a porcentagem que deseja acrescentar ao sal�rio");
			double porcentagem = scanner.nextDouble();
			listaFuncionarios.get(posicao).setSalario(porcentagem/100);
			System.out.println("Modifica��o realizada com sucesso!");
		}
		else {
			System.out.println("Funcin�rio n�o encontrado! Programa encerrado");
		}
		
		System.out.println("Dados finais do sistema");
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			System.out.println("Nome: "+listaFuncionarios.get(i).getNome()
					+" ID: "+listaFuncionarios.get(i).getId()
					+" Sal�rio: R$"+listaFuncionarios.get(i).getSalario());
		}
		scanner.close();
	}

}
