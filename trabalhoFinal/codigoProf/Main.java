class Main {

	public static void main(String[] args) {
		Matriz mat1, mat2;
		int det;
		long inicio, fim, resultado;

		mat1 = new Matriz(5, 5);
		mat1.inicializaRandomico(9);
		mat1.imprime();
		inicio = System.currentTimeMillis();
		det = mat1.determinante();
		fim = System.currentTimeMillis();
		resultado = fim - inicio;
		System.out.println(det);
		System.out.println(resultado);

	}

}
