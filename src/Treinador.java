public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo;
	private item[] poções = new item[4];
	private static int qtPokemons = 0;
	
	public Treinador(String nome) {
		this.nome = nome;
	}
	
	public void adicionaPokemon(int HP, String tipo, String nome, String[] habilidades, int[] potencia) {
		if (qtPokemons < 6) {
			deck[qtPokemons] = new Pokemon(HP, tipo, nome, habilidades, potencia);
			qtPokemons++;
		}
	}
	
	public void adicionaPoção(String nome, int pontos) {
		int i = 0;
		while (i < 3) {
			if (poções[i] == null) {
				poções[i] = new item(nome, pontos);
				i = 4;
			}else i++;
		}
		if (i == 3) System.out.println("Não pode adicionar poção, limite máximo de 3");
	}
	
	public void removePoção(int x) {
		poções[x] = null;
	}
	
	public void removePokemon(int numeroDoPokemon) {
		deck[numeroDoPokemon] = null;
	}
	
	public void atacarPokemon (int idx, Pokemon inimigo) {
		inimigo.perdeHP(deck[pokemonAtivo].getPotenciaHabilidade(idx));
	}
	
	public void usarItem(int x) {
		deck[pokemonAtivo].curaHP(poções[x].getPontos());
		removePoção(x);
	}
	
	public boolean fugir() {
		return true;
	}
}
