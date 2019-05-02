//TEST
public class Pokemon {
	private int MaxHP;
	private String tipoDoPokemon;
	private String nomePokemon;
	private Habilidades Hab;
	private int HP;
	
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
	
	public void perdeHP(int dano) {
		if (this.estaVivo()) {
			if (dano < this.HP) this.HP -= dano;
			else this.HP = 0;
		}
	}
	
	public void curaHP(int HPextra) {
		if (this.HP + HPextra > this.MaxHP) this.HP = this.MaxHP;
		else this.HP += HPextra; 
	}
	
	public int getHPAtual() {
		return this.HP;
	}

	public String getNomeDoPokemon() {
		return nomePokemon;
	}
	
	public String getNomeHabilidade(int num) {
		return Hab.getNome(num);
	}
	
	public int getPotenciaHabilidade(int num) {
		return Hab.getPotencia(num);
	}
	
	public double getMultiplicador(int pokemon1, int pokemon2) {
		return this.tabela[pokemon1][pokemon2];
	}
	
	double[][] tabela = new double[18][18];
	
	public int getTipoDoPokemon (String tipo) {
		if (tipo.compareTo("Normal") == 0) return 0;
		else if (tipo.compareTo("Lutador") == 0) return 1;
		else if (tipo.compareTo("Voador") == 0) return 2;
		else if (tipo.compareTo("Venenoso") == 0) return 3;
		else if (tipo.compareTo("Solo") == 0) return 4;
		else if (tipo.compareTo("Rocha") == 0) return 5;
		else if (tipo.compareTo("Inseto") == 0) return 6;
		else if (tipo.compareTo("Fantasma") == 0) return 7;
		else if (tipo.compareTo("Aço") == 0) return 8;
		else if (tipo.compareTo("Fogo") == 0) return 9;
		else if (tipo.compareTo("Água") == 0) return 10;
		else if (tipo.compareTo("Grama") == 0) return 11;
		else if (tipo.compareTo("Elétrico") == 0) return 12;
		else if (tipo.compareTo("Psíquico") == 0) return 13;
		else if (tipo.compareTo("Gelo") == 0) return 14;
		else if (tipo.compareTo("Dracônico") == 0) return 15;
		else if (tipo.compareTo("Trevas") == 0) return 16;
		else if (tipo.compareTo("Fada") == 0) return 17;
		return -1;
	}
}
