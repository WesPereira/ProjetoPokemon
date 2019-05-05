public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo, pokemonsMortos;
	private Item[] poções = new Item[4];
	private int qtPokemons = 0;
	private int Pokebolas;
	
	public Treinador(String nome) {
		this.nome = nome;
		this.pokemonAtivo = 0;
		this.pokemonsMortos = 0;
		poções[0] = new Item("Curinha", 50);
		poções[1] = new Item("Curinha2", 40);
		poções[2] = new Item("Curinha3", 70);
		poções[3] = new Item("Curinha4", 60);
		this.Pokebolas = 15;
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
		qtPokemons--;
		deck[numeroDoPokemon] = null;
	}
	
	public int getQtPokemons() {
		return qtPokemons;
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
	
	public void usarPokebola() {
		this.Pokebolas--;
	}
	
	public int getPokebolas() {
		return this.Pokebolas;
	}
}
