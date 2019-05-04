import java.util.Random;
import java.util.Scanner;

public class ControladorDeBatalha{
	private static boolean terminou = false;
	Scanner c = new Scanner(System.in);
	
	public boolean getTerminou() {
		return terminou;
	}
	
	public Evento novoEvento(int qual, Treinador t) {
		switch(qual) {
		case(1):
			return new Fugir(t);
		case(2):
			return new TrocaPokemon(t);
		case(3):
			return new UsarItem(t);
		case(4):
			return new Atacar(t);
		}
		return null;
	}
	
	private class Fugir extends Evento{
		
		public Fugir(Treinador corredor) {
			super(1, corredor);
		}
		
		public void action() {
			System.out.println(getTreinador1().getNome() + " desistiu, rs!");
			terminou = true;
		}
		
		public void cadastrarAdv(Treinador adv) {};
	}
	
	private class TrocaPokemon extends Evento{
		public TrocaPokemon(Treinador corredor) {
			super(2, corredor);
		}
		
		public void action() {
			int escolha;
			Treinador p = getTreinador1(); 
			while (true) {
				int k = 0;
				System.out.println(p.getNome() + " seu pokemon atual é: " + p.getPokemonAtivo().getNomePokemon());
				System.out.println("Escolha para qual pokemon deseja trocar: ");
				for (int i = 0; i < p.getQtPokemons(); i++) {
					System.out.println("[ " + k + " ] " + p.getPokemonqq(i).getNomePokemon());
					k++;
				}
				System.out.print(">> ");
				escolha = c.nextInt();
				if (p.getPokemonqq(escolha).estaVivo()) {
					p.setPokemonAtivo(escolha);
					break;
				}
				System.out.println("POKEMON SEM VIDA! TENTE OUTRO POKEMON\n");
			}
			System.out.println("Troca realizada com SUCESSO!\n");
		}
		
		public void cadastrarAdv(Treinador adv) {};
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
			System.out.println(getTreinador1().getNome() + " acaba de usar a poção " + p.getItem(x).getNome());
			System.out.println(p.getPokemonAtivo().getNomePokemon() + " acaba de ser curado em " + p.getItem(x).getCura());
			System.out.println(p.getPokemonAtivo().getNomePokemon() + " [" + p.getPokemonAtivo().getHPAtual() + "/" + p.getPokemonAtivo().getHPMax() + "]\n");
		}
		
		public void cadastrarAdv(Treinador adv) {};
	}
	
	private class Atacar extends Evento{
		private Treinador atacado;
		public Atacar(Treinador t1) {
			super(4, t1);
		}
		
		public void action() {
			Scanner c = new Scanner(System.in);
			int escolha;
			
			while (true) {
				System.out.println(getTreinador1().getNome() + " escolha qual ataque deseja realizar:");
				System.out.println("[ 0 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(0) + " DANO: " + getTreinador1().getPokemonAtivo().getPotHab(0));
				System.out.println("[ 1 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(1) + " DANO: " + getTreinador1().getPokemonAtivo().getPotHab(1));
				System.out.println("[ 2 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(2) + " DANO: " + getTreinador1().getPokemonAtivo().getPotHab(2));
				System.out.println("[ 3 ] " + getTreinador1().getPokemonAtivo().getNomeHabilidade(3) + " DANO: " + getTreinador1().getPokemonAtivo().getPotHab(3));
				System.out.print(">> ");
				escolha = c.nextInt();
				if (escolha >= 0 && escolha < 4) break;
				System.out.println("Ataque inexistente! Tente novamente.");
			}
			int meuHp = atacado.getPokemonAtivo().getHPAtual();
			int potHab = getTreinador1().getPokemonAtivo().getPotHab(escolha);
			if (meuHp > potHab) {
				atacado.getPokemonAtivo().perdeHP(potHab);
				System.out.println(getTreinador1().getPokemonAtivo().getNomePokemon() + " usou " + getTreinador1().getPokemonAtivo().getNomeHabilidade(escolha) + "!");
				System.out.println(atacado.getPokemonAtivo().getNomePokemon() + " [" + atacado.getPokemonAtivo().getHPAtual() + "/" + atacado.getPokemonAtivo().getHPMax() + "] \n");  
			}
			else {
				atacado.aumentaMortos();
				atacado.getPokemonAtivo().perdeHP(10000);
				if (atacado.getMortos() < atacado.getQtPokemons()) {
					for (int i = 0; i < atacado.getQtPokemons(); i++) {
						if (atacado.getPokemonqq(i).getHPAtual() > 0) {
							System.out.println("Oh Não! "+ atacado.getPokemonAtivo().getNomePokemon() + " MORREU!");
							System.out.println(atacado.getNome() + " seu pokemon ativo agora é: " + atacado.getPokemonqq(i).getNomePokemon());
							System.out.println("");
							atacado.setPokemonAtivo(i);
							break;
						}
					}
				}
				else {
					System.out.println("TODOS OS POKEMONS DE " + atacado.getNome() + " MORRERAM!");
					terminou = true;
				}
			}
		}
		
		public void cadastrarAdv(Treinador adv) {
			atacado = adv;
		}
	}
	
	public void finalizaDados() {
		c.close();
	}
}