import java.util.Scanner;
public class ControleVERSUS extends ControladorDeBatalha{
	private void OutraRodada (Treinador t1, Treinador t2, ControladorDeBatalha cb){
		Scanner c = new Scanner(System.in);
		int escolha;
		Evento e1, e2;
		
		System.out.println("Batalha em andamento!\n");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.println(t1.getNome() +" Pokemo ativo: " + t1.getPokemonAtivo().getNomePokemon() + 
				" [" + t1.getPokemonAtivo().getHPAtual() + "/" + t1.getPokemonAtivo().getHPMax() + "]");
		System.out.println(t2.getNome() +" Pokemo ativo: " + t2.getPokemonAtivo().getNomePokemon() + 
				" [" + t2.getPokemonAtivo().getHPAtual() + "/" + t2.getPokemonAtivo().getHPMax() + "] \n");
		System.out.println(t1.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 1 ] Fugir da batalha");
		System.out.println("[ 2 ] Trocar Pokemon ativo");
		System.out.println("[ 3 ] Usar item");
		System.out.println("[ 4 ] Atacar");
		System.out.print(">> ");
		escolha = c.nextInt();
		e1 = novoEvento(escolha, t1);
		if (escolha == 4) e1.cadastrarAdv(t2);
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.println("Batalha em andamento!");
		System.out.println(t2.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 1 ] Fugir da batalha");
		System.out.println("[ 2 ] Trocar Pokemon ativo");
		System.out.println("[ 3 ] Usar item");
		System.out.println("[ 4 ] Atacar");
		System.out.print(">> ");
		escolha = c.nextInt();
		e2 = novoEvento(escolha, t2);
		if (escolha == 4) e2.cadastrarAdv(t1);
		if(e1.getPrioridade() <= e2.getPrioridade()) {
			e1.action();
			if (e1.getPrioridade() == 1) return;
			e2.action();
		}
		else {
			e2.action();
			if (e2.getPrioridade() == 1) return;
			e1.action();
		}
	}
	
	public static void main(String[] args) {
		ControladorDeBatalha c = new ControladorDeBatalha();
		ControleVERSUS controlador = new ControleVERSUS();
		Treinador t1 = new Treinador("Ash");
		Treinador t2 = new Treinador("Misty");
		
		String[] hab1 = {"H1", "H2", "H3", "H4"};
		int[] pow1 = {100, 140, 200, 70};
		Pokemon p1 = new Pokemon(250, "Grama", "Xuletinha", hab1, pow1);
		
		String[] hab2 = {"H1", "H2", "H3", "H4"};
		int[] pow2 = {115, 130, 210, 300};
		Pokemon p2 = new Pokemon(200, "Terra", "Terrinha", hab2, pow2);
		t1.adicionarPokemon(p1);
		t1.adicionarPokemon(p2);
		
		String[] hab3 = {"H1", "H2", "H3", "H4"};
		int[] pow3 = {100, 140, 200, 70};
		Pokemon p3 = new Pokemon(250, "Normal", "Estranhinho", hab3, pow3);
		
		String[] hab4 = {"H1", "H2", "H3", "H4"};
		int[] pow4 = {115, 130, 210, 300};
		Pokemon p4 = new Pokemon(200, "Terra", "Torretinha", hab4, pow4);
		t2.adicionarPokemon(p3);
		t2.adicionarPokemon(p4);
		
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("          JOGUINHO POKEMONS        ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.println("A batalha já vai começar, PREPAREM-SE");
		while (c.getTerminou() == false) {
			controlador.OutraRodada(t1, t2, c);
		}
		c.finalizaDados();
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("         O JOGO TERMINOU :(        ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
	}
}
