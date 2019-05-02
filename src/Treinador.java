public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo;
	private int poções;
	private static int qtPokemons = 0;
	
	public Treinador(String nome, int poções) {
		this.nome = nome;
		this.poções = poções;
	}
	
	public void adicionaPokemon(int HP, String tipo, String[] habilidades, int[] potencia) {
		if (qtPokemons < 6) {
			deck[qtPokemons] = new Pokemon(HP, tipo, habilidades, potencia);
			qtPokemons++;
		}
	}
	
	public void atacarPokemon (int idx, Pokemon inimigo) {
		
	}
}
