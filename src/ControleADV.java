import java.util.Scanner;

public class ControleADV extends ControladorDeBatalha{
	public void OutraRodada(Treinador t1, Treinador t2, Mapa map) {
		Scanner c = new Scanner(System.in);
		int escolha;
		Evento e1, e2;
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		map.imprimeMapa();
		while(true) {
			System.out.println(">> [ 1 ] Subir | [ 2 ] Direita | [ 3 ] Baixo | [ 4 ] Esquerda");
			System.out.print(">> ");
			escolha = c.nextInt();
			if(this.Anda(escolha, map)) break;
			System.out.println("Opa! Ta querendo sair do mapa, espertinho. Tente denovo!");
		}
		int lin = map.getPosiLin();
		int col = map.getPosiCol();
		if (map.getMapaPokes(lin, col) == 1) {
			System.out.println("Você encontrou um POKE SELVAGEM!");
			System.out.println("É HORA DO DUELO XD!");
			while (t1.getMortos() < t1.getQtPokemons() && t2.getMortos() < t2.getQtPokemons()) {
				System.out.println("[ 1 ] Fugir da batalha");
				System.out.println("[ 2 ] Trocar Pokemon ativo");
				System.out.println("[ 3 ] Usar item");
				System.out.println("[ 4 ] Atacar");
				System.out.print(">> ");
				escolha = c.nextInt();
				e1 = novoEvento(escolha, t1);
				if (escolha == 4) e1.cadastrarAdv(t2);
				e2 = novoEvento(5, t2);
				e2.cadastrarAdv(t1);
				e1.action();
				e2.action();
			}
			if (t1.getMortos() < t1.getQtPokemons()) System.out.println("Você acaba de CAPTURAR UM POKE SELVAGEM!");
		}
	}
	
	public static void main(String[] args) {
		ControladorDeBatalha c = new ControladorDeBatalha();
		ControleADV controlador = new ControleADV();
		Mapa mapinha = new Mapa(17, 50);
		Treinador t1 = new Treinador("Ash");
		Treinador t2 = new Treinador("Poke Selvagem");
		
		String[] hab1 = {"H1", "H2", "H3", "H4"};
		int[] pow1 = {100, 140, 200, 70};
		Pokemon p1 = new Pokemon(250, "Normal", "Xuletinha", hab1, pow1);
		
		String[] hab2 = {"H1", "H2", "H3", "H4"};
		int[] pow2 = {115, 130, 210, 300};
		Pokemon p2 = new Pokemon(200, "Solo", "Terrinha", hab2, pow2);
		t1.adicionarPokemon(p1);
		t1.adicionarPokemon(p2);
		
		String[] hab3 = {"H1", "H2", "H3", "H4"};
		int[] pow3 = {100, 140, 200, 70};
		Pokemon p3 = new Pokemon(250, "Lutador", "Poke Selvagem", hab3, pow3);
		t2.adicionarPokemon(p3);
		
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("        JOGUINHO PEGUE POKES       ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.println("O objetivo do jogo é andar pelo gramado e capturar pokemons, Boa Sorte!");
		System.out.println("Você será levado para o mapa, PREPARE-SE\n");
		while (c.getTerminou() == false) {
			controlador.OutraRodada(t1, t2, mapinha);
		}
		
	}
}
