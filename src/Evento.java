abstract public class Evento {
	private Treinador Treinador1;
	private double prioridade;
	
	public Evento(int prioridade, Treinador Treinador1) {
		this.Treinador1 = Treinador1;
		this.prioridade = prioridade;
	}
	
	public double getPrioridade() {
		return prioridade;
	}
	
	public Treinador getTreinador1() {
		return Treinador1;
	}
	
	abstract public void action();
	
	abstract public void cadastrarAdv(Treinador adv);
}