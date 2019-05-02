

public class ControladorDeBatalha extends Controller{
	public boolean terminou = false;
	
	public void InicioBatalha (){
		private Treinador Treinador1 = new Treinador("Ash");
		
		private String[] habilidades2 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias2 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades2, potencias2);
		
		private String[] habilidades3 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias3 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades3, potencias3);
		
		private String[] habilidades4 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias4 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades4, potencias4);
		
		//Criando o primeiro Treinador 
		private Treinador Treinador2 = new Treinador("Brock");
		
		private String[] habilidades5 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias5 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades1, potencias1);
		
		private String[] habilidades6 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias6 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades2, potencias2);
		
		private String[] habilidades7 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias7 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades3, potencias3);
		
		private String[] habilidades8 = {"Habilidade 1", "Habilidade 2", "Habilidade 3", "Habilidade 4"};
		private int[] potencias8 = {100, 150, 130, 200};
		Treinador1.adicionaPokemon(100, "Grama", "Bulbassauro", habilidades4, potencias4);
	}
	
	public static void main(String[] args) {
		ControladorDeBatalha cb = new ControladorDeBatalha();
		long tm  = System.currentTimeMillis();
		cb.addEvent(cb.new ChecaBatalha(tm));
		while (!cb.terminou) {
			cb.addEvent(cb.new OutraRodada(tm));
			cb.run();
		}
	}
}
