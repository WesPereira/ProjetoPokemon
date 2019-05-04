
public class ListaDeEventos {
	private Evento[] eventos = new Evento[100];
	private int idx = 0;
	private int next = 0;
	
	public void adicionar(Evento e) {
		if (idx >= eventos.length)
			return;
		eventos[idx++] = e;
	}
	
	public Evento pegarPróximo() {
		boolean loop = false;
		int start = next;
		do {
			next = (next + 1) % eventos.length;
			if(start == next) loop = true;
			if((next == (start + 1) % eventos.length) && loop)
				return null;
		} while (eventos[next] == null);
		return eventos[next];
	}
	
	public void removeAtual() {
		eventos[next] = null;
	}
}
