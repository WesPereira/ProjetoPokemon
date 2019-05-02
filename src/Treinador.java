public class Treinador {
	private String nome;
	private Pokemon[] deck = new Pokemon[6];
	private int pokemonAtivo;
	private int poções;
	private static int qtPokemons = 0;
	
	public Treinador(String nome) {
		this.nome = nome;
	}
	
	public void adicionaPokemon(int HP, String tipo, String nome, String[] habilidades, int[] potencia) {
		if (qtPokemons < 6) {
			deck[qtPokemons] = new Pokemon(HP, tipo, habilidades, potencia);
			qtPokemons++;
		}
	}
	
	public void atacarPokemon (int idx, Pokemon inimigo) {
		
	}
}
