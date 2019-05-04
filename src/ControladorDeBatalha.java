import java.util.Scanner;

public class ControladorDeBatalha extends Controller{
	public boolean terminou = false;
	
	public void OutraRodada (){
		
		//Criando jogador1
		Treinador jogador1 = new Treinador("Ash");
		
		Pokemon[] deckJogador1 = new Pokemon[4];
		String[][] habilidades = {{"Golpezao", "Tapao", "Socao", "Chutao"}, 
								  {"Pescotapa", "Peba", "Antonio", "Nunes"},
								  {"Pescotapa", "Peba", "Antonio", "Nunes"},
								  {"Pescotapa", "Peba", "Antonio", "Nunes"}};
		int[][] potencias = {{80, 50, 60, 30}, 
							 {80, 50, 60, 30},
							 {80, 50, 60, 30},
							 {80, 50, 60, 30}};
		deckJogador1[0] = new Pokemon(250, "Grama", "Estranhinho1", habilidades[0], potencias[0]);
		deckJogador1[1] = new Pokemon(250, "Grama", "Estranhinho2", habilidades[1], potencias[1]);
		deckJogador1[2] = new Pokemon(250, "Grama", "Estranhinho3", habilidades[2], potencias[2]);
		deckJogador1[3] = new Pokemon(250, "Grama", "Estranhinho4", habilidades[3], potencias[3]);
		jogador1.adicionarPokemon(deckJogador1[0]);
		jogador1.adicionarPokemon(deckJogador1[1]);
		jogador1.adicionarPokemon(deckJogador1[3]);
		jogador1.adicionarPokemon(deckJogador1[4]);
		
		//Criando treinador 2
		Treinador jogador2 = new Treinador("Misty");
		jogador2.adicionarPokemon(deckJogador1[4]);
		jogador2.adicionarPokemon(deckJogador1[3]);
		jogador2.adicionarPokemon(deckJogador1[2]);
		jogador2.adicionarPokemon(deckJogador1[1]);
	}
	
	private class Fugir extends Evento{
		
		public Fugir(Treinador corredor) {
			super(1, corredor);
		}
		
		public void action() {
			System.out.println(getTreinador1() + "desistiu, rs!");
			terminou = true;
		}
	}
	
	private class TrocaPokemon extends Evento{
		boolean trocou = false;
		public TrocaPokemon(Treinador corredor) {
			super(2, corredor);
		}
		
		public void action() {
			Scanner c = new Scanner(System.in);
			int escolha;
			Treinador play = getTreinador1(); 
			while (trocou == false) {
				System.out.println("Seu pokemon atual é: " + play.getPokemonAtivo().getNomeDoPokemon());
				System.out.println("Escolha para qual pokemon deseja trocar: ");
				System.out.println("[]");
				escolha = c.nextInt();
				if (play.getPokemonqq(escolha).estaVivo()) {
					play.setPokemonAtivo(escolha);
					break;
				}
				System.out.println("Opção INVÁLIDA! TENTE OUTRO POKEMON\n");
			}
			System.out.println("Troca realizada com SUCESSO!");
		}
	}
	
	private class UsarItem extends Evento{
		
	}
	public static void main(String[] args) {
		
	}
}
