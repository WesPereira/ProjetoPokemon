import java.util.Scanner;

public class Controle {
	private void OutraRodada (Treinador t1, Treinador t2, ControladorDeBatalha cb){
		Scanner c = new Scanner(System.in);
		int escolha1, escolha2;
		System.out.println("Batalha em andamento!");
		System.out.println(t1.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 0 ] Fugir da batalha");
		System.out.println("[ 1 ] Trocar Pokemon ativo");
		System.out.println("[ 2 ] Usar item");
		System.out.println("[ 3 ] Atacar");
		System.out.println(">> ");
		escolha1 = c.nextInt();
		System.out.println();
		System.out.println(t2.getNome() + " escolha uma opção de ação: ");
		System.out.println("[ 0 ] Fugir da batalha");
		System.out.println("[ 1 ] Trocar Pokemon ativo");
		System.out.println("[ 2 ] Usar item");
		System.out.println("[ 3 ] Atacar");
		System.out.println(">> ");
		escolha2 = c.nextInt();
		
	}
	
	public static void main(String[] args) {
		ControladorDeBatalha c = new ControladorDeBatalha();
		Controle controlador;
		Treinador t1 = new Treinador("Ash");
		Treinador t2 = new Treinador("Misty");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("          JOGUINHO POKEMONS        ");
		System.out.println("-=-=--=-=--=-=--=-=--=-=--=-=--=-=-");
		System.out.println("A batalha já vai começar, PREPAREM-SE");
		while (!c.getTerminou()) {
			OutraRodada(t1, t2, c);
		}
	}
}
