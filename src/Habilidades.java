public class Habilidades {
	private String[] nome = new String[4];
	private int[] potencia = new int[4];
	
	public Habilidades(String[] nome, int[] potencia) {
		this.nome[0] = nome[0];
		this.potencia[0] = potencia[0];
		this.nome[1] = nome[1];
		this.potencia[1] = potencia[1];
		this.nome[2] = nome[2];
		this.potencia[2] = potencia[2];
		this.nome[3] = nome[3];
		this.potencia[3] = potencia[3];
		
	}
	
	public int getPotencia(int x) {
		return potencia[x];
	}
	
	public String getNome(int x) {
		return nome[x];
	}
}
