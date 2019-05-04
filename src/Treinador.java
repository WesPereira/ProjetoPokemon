public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo;
	private Item[] poções = new Item[4];
	private static int qtPokemons = 0;
	
	public Treinador(String nome) {
		this.nome = nome;
		this.pokemonAtivo = 0;
	}
	
	public void adicionarPokemon(Pokemon Pokemonadd) {
		if (qtPokemons < 6) {
			deck[qtPokemons] = Pokemonadd;
			qtPokemons++;
		}
	}
	
	public void removerPokemon(int numeroDoPokemon) {
		deck[numeroDoPokemon] = null;
	}
	
	public void usarItem(int x) {
		deck[pokemonAtivo].curaHP(poções[x].getCura());
	}
	
	public boolean setPokemonAtivo(int idx) {
		if (deck[idx].estaVivo()) {
			this.pokemonAtivo = idx;
			return true;
		}
		return false;
	}
	
	public Pokemon getPokemonAtivo() {
		return deck[this.pokemonAtivo];
	}
	
	public Pokemon getPokemonqq(int idx) {
		return deck[idx];
	}
}
