import java.util.Random;
import java.util.Scanner;

public class ControladorDeBatalha{
	private boolean terminou = false;
	
	public boolean getTerminou() {
		return terminou;
	}
	
	public Evento novoEvento(int qual, Treinador t) {
		switch(qual) {
		case(0):
			return new Fugir(t);
		case(1):
			return new TrocaPokemon(t);
		case(2):
			return new UsarItem(t);
		case(3):
			return new Atacar(t);
		}
		return null;
	}
	
	private class Fugir extends Evento{
		
		public Fugir(Treinador corredor) {
			super(1, corredor);
		}
		
		public void action() {
			System.out.println(getTreinador1() + " desistiu, rs!");
			terminou = true;
		}
	}
	
	private class TrocaPokemon extends Evento{
		public TrocaPokemon(Treinador corredor) {
			super(2, corredor);
		}
		
		public void action() {
			Scanner c = new Scanner(System.in);
			int escolha;
			Treinador p = getTreinador1(); 
			while (true) {
				int k = 0;
				System.out.println("Seu pokemon atual é: " + p.getPokemonAtivo().getNomePokemon());
				System.out.println("Escolha para qual pokemon deseja trocar: ");
				for (int i = 0; i < 4; i++) {
					if (p.getPokemonAtivo() != p.getPokemonqq(i)) {
						System.out.println("[ " + k + "] " + p.getPokemonqq(i).getNomePokemon());
						k++;
					}
				}
				escolha = c.nextInt();
				if (p.getPokemonqq(escolha).estaVivo()) {
					p.setPokemonAtivo(escolha);
					break;
				}
				System.out.println("POKEMON SEM VIDA! TENTE OUTRO POKEMON\n");
			}
			System.out.println("Troca realizada com SUCESSO!");
			c.close();
		}
	}
	
	private class UsarItem extends Evento{
	
		public UsarItem(Treinador Treinador1) {
			super(3, Treinador1);
		}
		
		public void action() {
			Treinador p = getTreinador1();
			Random gerador = new Random();
			int x = gerador.nextInt(4);
			p.UsarItem(x);
			System.out.println("Você acaba de usar a poção " + p.getItem(x).getNome());
			System.out.println(p.getPokemonAtivo().getNomePokemon() + "acaba de ser curado em " + p.getItem(x).getNome());
			System.out.println(p.getPokemonAtivo().getNomePokemon() + " [" + p.getPokemonAtivo().getHPAtual() + "/" + p.getPokemonAtivo().getHPMax() + "]");
		}
	}
	
	private class Atacar extends Evento{
		private Treinador atacado;
		public Atacar(Treinador t1) {
			super(4, t1);
		}
		
		public void setAtacado(Treinador t2) {
			atacado = t2;
		}
		
		public void action() {
			Scanner c = new Scanner(System.in);
			int escolha;
			
			while (true) {
				System.out.println("Escolha qual ataque deseja realizar:");
				System.out.println("[ 0 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(0));
				System.out.println("[ 1 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(1));
				System.out.println("[ 2 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(2));
				System.out.println("[ 3 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(3));
				escolha = c.nextInt();
				if (escolha > 0 && escolha < 4) break;
				System.out.println("Ataque inexistente! Tente novamente.");
			}
			c.close();
			int meuHp = atacado.getPokemonAtivo().getHPAtual();
			int potHab = getTreinador1().getPokemonAtivo().getPotHab(escolha);
			if (meuHp > potHab) {
				atacado.getPokemonAtivo().perdeHP(potHab);
			}
			else if (atacado.getMortos() < 4) {
				
			}
			else terminou = true;
		}
	}
}
