package Pokemons;

public class treinador {
	private String nome;
	private Pokemon[] deck;
	private int ativo;
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setDeck(int x, Pokemon pok){
		deck[x] = pok;
	}
	private void Atacar(int habilidade, Pokemon adversario){
		adversario.setHP(adversario.getHP - deck[ativo].getPowerHab[habilidade]);
	}
	private void Item(item x) {
		deck[ativo].setHP(deck[ativo].getHP + x.getPontos);
	}
	private void fugir() {
		
	}
	private 
	
}
