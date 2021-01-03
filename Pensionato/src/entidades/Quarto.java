package entidades;

public class Quarto {

	private String ocupante,email;
	private int numero;
	
	public Quarto(String ocupante, String email, int numero) {
		
		this.ocupante = ocupante;
		this.email = email;
		this.numero = numero;
	}
	
	public String getOcupante() {
		return ocupante;
	}
	public void setOcupante(String ocupante) {
		this.ocupante = ocupante;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public static String relatorio(Quarto quarto[]) {
		
		String relatorio ="Relatório de ocupação de quartos\n";
		
		for (int i = 0; i < quarto.length; i++) {
			relatorio+="-------------------------------";
			if(quarto[i] != null) {
				relatorio += quarto[i] + " - ocupado por "+quarto[i].ocupante + " email: "+quarto[i].email;
			}
		}
		
		return relatorio;
	}
	
}
