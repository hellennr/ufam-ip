public class Vetor{
	private int[] vet;
	private int tamanho;

	Vetor(int novoTamanho){
		this.setTamanho(novoTamanho);
		vet = new int[this.getTamanho()];
	}

	public int getTamanho(){
		return this.tamanho;
	}
	public void setTamanho(int novoValor){
		this.tamanho = novoValor;
	}
	public int getElemento(int index){
		return this.vet[index];
	}
	public void setElemento(int index, int novoValor){
		this.vet[index] = novoValor;
	}
	// método que insere valores ao vetor
	public void insereValores(){
		int num = 3;
		int cont;

		for(cont=0; cont<this.getTamanho(); cont++){
			this.setElemento(cont, num);
			num = num + 2;
		}
	}
}