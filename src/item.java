package Pokemons;

public class item {
	private String nome;
	private int pontos;
	public item(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
}
