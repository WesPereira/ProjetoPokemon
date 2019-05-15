/*Classe de controle dos Pokemons*/
public class Pokemon {
	private double MaxHP;
	private String tipoDoPokemon;
	private String nomePokemon;
	private Habilidades Hab;
	private double HP;
	
	public Pokemon(int HP, String tipoDoPokemon, String nomePokemon, String[] hab, int[] powerHab) {
		this.HP = HP;
		this.MaxHP = HP;
		this.tipoDoPokemon = tipoDoPokemon;
		this.nomePokemon = nomePokemon;
		this.Hab = new Habilidades (hab, powerHab);
	}
	
	public boolean estaVivo() {
		if (HP > 0) return true;
		return false;
	}
	
	public void perdeHP(double dano) {
		if (this.estaVivo()) {
			if (dano < this.HP) this.HP -= dano;
			else this.HP = 0;
		}
	}
	
	public void curaHP(int HPextra) {
		if (this.HP + HPextra > this.MaxHP) this.HP = this.MaxHP;
		else this.HP += HPextra; 
	}
	
	public double getHPAtual() {
		return this.HP;
	}
	
	public double getHPMax() {
		return this.MaxHP;
	}
	
	public String getNomePokemon() {
		return nomePokemon;
	}
	
	public String getNomeHabilidade(int num) {
		return Hab.getNome(num);
	}
	
	public int getPotHab(int num) {
		return Hab.getPotencia(num);
	}
	
	public double getMultiplicador(int pokemon1, int pokemon2) {
		return this.tabela[pokemon1][pokemon2];
	}
	
	//Tabela que possui as vantagens entre os tipos de pokemons
	double[][] tabela = {{1, 1, 1, 1, 1, 0.5, 1, 0, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5},
						 {1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1, 1, 1, 1},
						 {1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1, 1, 1, 2}, 
						 {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1, 1, 1, 1},
						 {1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1, 1, 2, 1, 1, 1},
						 {1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1, 1, 2, 0.5},
						 {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0.5, 1, 1, 0.5, 1},
						 {1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 1, 1, 2},
						 {1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2, 0.5, 1, 1},
						 {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5, 1, 1},
						 {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 0.5, 2, 0.5, 1, 1, 1, 0.5, 1, 1},
						 {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5, 1, 1},
						 {1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 1, 0.5, 1, 1},
						 {1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5, 2, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 1, 1, 2, 1, 0},
						 {1, 0.5, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5},
						 {1, 2, 1, 0.5, 1, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 1, 1, 2, 2, 1}};
	
	public int getTipoDoPokemon () {
		if (tipoDoPokemon.compareTo("Normal") == 0) return 0;
		else if (tipoDoPokemon.compareTo("Lutador") == 0) return 1;
		else if (tipoDoPokemon.compareTo("Voador") == 0) return 2;
		else if (tipoDoPokemon.compareTo("Venenoso") == 0) return 3;
		else if (tipoDoPokemon.compareTo("Solo") == 0) return 4;
		else if (tipoDoPokemon.compareTo("Rocha") == 0) return 5;
		else if (tipoDoPokemon.compareTo("Inseto") == 0) return 6;
		else if (tipoDoPokemon.compareTo("Fantasma") == 0) return 7;
		else if (tipoDoPokemon.compareTo("Aço") == 0) return 8;
		else if (tipoDoPokemon.compareTo("Fogo") == 0) return 9;
		else if (tipoDoPokemon.compareTo("Água") == 0) return 10;
		else if (tipoDoPokemon.compareTo("Grama") == 0) return 11;
		else if (tipoDoPokemon.compareTo("Elétrico") == 0) return 12;
		else if (tipoDoPokemon.compareTo("Psíquico") == 0) return 13;
		else if (tipoDoPokemon.compareTo("Gelo") == 0) return 14;
		else if (tipoDoPokemon.compareTo("Dracônico") == 0) return 15;
		else if (tipoDoPokemon.compareTo("Trevas") == 0) return 16;
		else if (tipoDoPokemon.compareTo("Fada") == 0) return 17;
		return -1;
	}
	
	public double vantagemPoke(int tipo2) {
		return tabela[this.getTipoDoPokemon()][tipo2];
	}
}
