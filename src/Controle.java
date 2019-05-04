import java.util.Scanner;

public class Controle extends ControladorDeBatalha{
	private void OutraRodada (Treinador t1, Treinador t2, ControladorDeBatalha cb){
		Scanner c = new Scanner(System.in);
		int escolha;
		Evento e1, e2;
		
		System.out.println("Batalha em andamento!");
		System.out.println(t1.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 1 ] Fugir da batalha");
		System.out.println("[ 2 ] Trocar Pokemon ativo");
		System.out.println("[ 3 ] Usar item");
		System.out.println("[ 4 ] Atacar");
		System.out.println(">> ");
		escolha = c.nextInt();
		e1 = novoEvento(escolha, t1);
		System.out.println("Batalha em andamento!");
		System.out.println(t2.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 1 ] Fugir da batalha");
		System.out.println("[ 2 ] Trocar Pokemon ativo");
		System.out.println("[ 3 ] Usar item");
		System.out.println("[ 4 ] Atacar");
		System.out.println(">> ");
		escolha = c.nextInt();
		e2 = novoEvento(escolha, t2);
		if(e1.getPrioridade() <= e2.getPrioridade()) {
			e1.action();
			e2.action();
		}
		else {
			e2.action();
			e1.action();
		}
	}
	
	public static void main(String[] args) {
		ControladorDeBatalha c = new ControladorDeBatalha();
		Controle controlador = new Controle();
		Treinador t1 = new Treinador("Ash");
		Treinador t2 = new Treinador("Misty");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("          JOGUINHO POKEMONS        ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("A batalha já vai começar, PREPAREM-SE");
		while (!c.getTerminou()) {
			controlador.OutraRodada(t1, t2, c);
		}
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("         O JOGO TERMINOU :(        ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
	}
}
