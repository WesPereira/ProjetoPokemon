/*
 *  */
//TESTANDO
public class Pokemon {
	private int MaxHP;
	private int tipoDoPokemon;
	private String nomePokemon;
	private Habilidades Hab;
	private int HP;
	
	public Pokemon(int HP, int tipoDoPokemon, String nomePokemon, String[] hab, int[] powerHab) {
		this.HP = HP;
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
	
	public int gettipoDoPokemon() {
		return tipoDoPokemon;
	}
	
	public String getnomeDoPokemon() {
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
		
	}
}
