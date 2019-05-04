public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo, pokemonsMortos;
	private Item[] poções = new Item[4];
	private static int qtPokemons = 0;
	
	public Treinador(String nome) {
		this.nome = nome;
		this.pokemonAtivo = 0;
		this.pokemonsMortos = 0;
	}
	
	public void adicionarPokemon(Pokemon Pokemonadd) {
		if (qtPokemons < 6) {
			deck[qtPokemons] = Pokemonadd;
			qtPokemons++;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void removerPokemon(int numeroDoPokemon) {
		deck[numeroDoPokemon] = null;
	}
	
	public void UsarItem(int x) {
		deck[this.pokemonAtivo].curaHP(poções[x].getCura());
	}
	
	public Item getItem(int x) {
		return poções[x];
	}
	
	public void aumentaMortos() {
		pokemonsMortos++;
	}
	
	public int getMortos() {
		return pokemonsMortos;
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
