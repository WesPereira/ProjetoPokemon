import java.util.Random;

public class Mapa {
	private char[][] mapinha;
	private int tamanhol, tamanhoc, posil, posic;
	private int[][] mapaPokes;
	
	public Mapa(int taml, int tamc) {
		tamanhol = taml;
		tamanhoc = tamc;
		mapinha = new char[taml][tamc];
		mapaPokes = new int[taml][tamc];
		Random gerador = new Random();
		int x;
		for(int i = 0; i < taml; i++) {
			for(int j = 0; j < tamc; j++) {
				x = gerador.nextInt(131071);
				x = x % 9 + 1;
				if(x == 1 || x == 2 || x == 3) mapinha[i][j] = '#';
				else mapinha[i][j] = '.';
				if (mapinha[i][j] == '#') {
					x = gerador.nextInt(8191);
					x = x % 3 + 1;
					if (x == 1 || x == 2) mapaPokes[i][j] = 1;
				}
				else mapaPokes[i][j] = 0;
			}
		}
		x = gerador.nextInt(7333);
		x = x % taml;
		posil = x;
		x = gerador.nextInt(7333);
		x = x % tamc;
		posic = x;
	}
	
	public void imprimeMapa() {
		for(int i = 0; i < tamanhol; i++) {
			for(int j = 0; j < tamanhoc; j++) {
				if (i == posil && j == posic) System.out.print('J');
				else System.out.print(mapinha[i][j]);
			}
			System.out.println();
		}
	}
	
	public int getPosiLin() {
		return posil;
	}
	
	public int getPosiCol() {
		return posic;
	}
	
	public boolean praCima() {
		if (posil > 0) {
			posil -= 1;
			return true;
		}
		return false;
	}
	
	public int getMapaPokes(int lin, int col) {
		return this.mapaPokes[lin][col];
	}
	
	public boolean praBaixo() {
		if (posil < tamanhol - 1) {
			posil += 1;
			return true;
		}
		return false;
	}
	
	public boolean praEsquerda() {
		if (posic > 0) {
			posic -= 1;
			return true;
		}
		return false;
	}
	
	public boolean praDireita() {
		if (posic < tamanhoc - 1) {
			posic += 1;
			return true;
		}
		return false;
	}
}
