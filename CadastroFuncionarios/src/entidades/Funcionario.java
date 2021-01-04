package entidades;

public class Funcionario {

	private String nome;
	private double salario;
	private int id;
	
	public Funcionario(String nome, double salario, int id) {
		this.nome = nome;
		this.salario = salario;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double porcentagem) {
		this.salario = salario + salario * porcentagem;
	}
	public int getId() {
		return id;
	}

}
