/*
 *  */
//TESTANDO
public class Pokemons {
	private int MaxHP;
	private int tipoDoPokemon;
	private String nomePokemon;
	private Habilidades Hab;
	private int HP;
	
	public Pokemons(int HP, int tipoDoPokemon, String nomePokemon, String[] hab, int[] powerHab) {
		this.HP = HP;
		this.tipoDoPokemon = tipoDoPokemon;
		this.nomePokemon = nomePokemon;
		hab = new Habilidades (hab, powerHab);
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int HP) {
		this.HP = HP;
	}
	public int gettipoDoPokemon() {
		return tipoDoPokemon;
	}
	public String getnomeDoPokemon() {
		return nomePokemon;
	}
	
}
