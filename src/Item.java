/*Classe de controle dos itens*/
public class Item {
	private String nome;
	private int cura;
	
	public Item(String nome, int cura) {
		this.nome = nome;
		this.cura = cura;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCura() {
		return cura;
	}
}
