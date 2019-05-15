import java.util.Random;
import java.util.Scanner;
// clonar objeto pra poder capturar vários pokes
public class ControleADV extends ControladorDeBatalha{
	public void OutraRodada(Treinador t1, Treinador t2, Mapa map, ControladorDeBatalha cb) {
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
			System.out.println("É HORA DO DUELO XD!\n");
			while (t1.getMortos() < t1.getQtPokemons() && t2.getMortos() < t2.getQtPokemons() && t1.getPokebolas() > 0) {
				System.out.println(t1.getNome() +" Pokemon ativo: " + t1.getPokemonAtivo().getNomePokemon() + 
						" [" + t1.getPokemonAtivo().getHPAtual() + "/" + t1.getPokemonAtivo().getHPMax() + "]");
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
				if(escolha == 1) break;
				e1.action();
				if (t2.getMortos() == t2.getQtPokemons()) {
					t1.usarPokebola();
					t1.adicionarPokemon(t2.getPokemonqq(0));
					System.out.println("Você acaba de CAPTURAR UM POKE SELVAGEM!");
					t2.dimMortos();
					t2.getPokemonAtivo().curaHP(100000);
					cb.Terminar(0);
					break;
				}
				e2.action();
				System.out.println("Gostaria de Tentar capturar o Pokemon Selvagem?");
				System.out.println("Digite 1 se sim, 0 caso contrário.");
				System.out.print(">> ");
				escolha = c.nextInt();
				if (escolha == 1) { 
					int cont = 0;
					double vida = t2.getPokemonAtivo().getHPMax();
					double vidaatual = t2.getPokemonAtivo().getHPAtual();
					for (int i = 0; i < 10; i++) {
						double x = Math.random()*vida;
						if (x > vidaatual) cont++;
					}
					if (cont > 6) {
						System.out.println("Parábens você conseguiu prender o Poke Selvagem!");
						t1.adicionarPokemon(t2.getPokemonqq(0));
						t1.usarPokebola();
						t2.getPokemonAtivo().curaHP(100000);
						break;
					}
					else {
						System.out.println("Infelizmente você ainda não conseguiu prender o poke :(\n");
						t1.usarPokebola();
					}
				}
			}
			if (t1.getMortos() == t1.getQtPokemons()) {
				System.out.println("Muito ruim, perdeu todos os pokemons kkkkk");
				cb.Terminar(1);
			}
			if (t1.getPokebolas() == 0) {
				System.out.println("Acabou as pokebolas :(");
				cb.Terminar(1);
			}
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
			controlador.OutraRodada(t1, t2, mapinha, c);
			if (t1.getQtPokemons() == 6) {
				System.out.println("Já tem muito pokemon, vai embora :)");
				break;
			}
		}
		c.finalizaDados();
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("                 CABÔ              ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
	}
}
