import java.util.Random;

public class Matrizes {
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;

	Matrizes() {
		mat = new int[3][3];
		this.setTamLinha(3);
		this.setTamColuna(3);
	}

	Matrizes(int i, int j) {
		mat = new int[i][j];
		this.setTamLinha(i);
		this.setTamColuna(j);
	}

	public int getTamLinha() {
		return this.tamLinha;
	}

	public void setTamLinha(int valor) {
		this.tamLinha = valor;
	}

	public int getTamColuna() {
		return this.tamColuna;
	}

	public void setTamColuna(int valor) {
		this.tamColuna = valor;
	}

	public int getElemento(int i, int j) {
		return this.mat[i][j];
	}

	public void setElemento(int i, int j, int valor) {
		this.mat[i][j] = valor;
	}

	public int retorneOrdem() {
		int lin = this.getTamLinha();
		int col = this.getTamColuna();
		int ordem = -1;

		if (lin == col) {
			ordem = lin;
		}
		return ordem;

	}

	public void preencheMatriz() {
		Random random = new Random();
		for (int i = 0; i < this.retorneOrdem(); i++) {
			for (int j = 0; j < this.retorneOrdem(); j++) {
				this.setElemento(i, j, random.nextInt(100));
			}
		}
	}

	public void imprimeMatriz() {
		for (int i = 0; i < this.retorneOrdem(); i++) {
			for (int j = 0; j < this.retorneOrdem(); j++) {
				System.out.printf("%2d ", this.getElemento(i, j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Matrizes matriz = new Matrizes(5, 5);
		matriz.preencheMatriz();
		matriz.imprimeMatriz();
	}
}
