import java.util.Scanner;

public class Arvore {
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void printArvore() {
        int num = this.numero;
        int acumuladora = 0;
        for (int linhas = 0; linhas < numero; linhas++) {
            for (int colunas = 0; colunas < num + num - 1; colunas++) {
                if (colunas > num - 1 + acumuladora || colunas < num - 1 - acumuladora) {
                    System.out.print(". ");
                } else {
                    System.out.print("* ");
                }
            }
            acumuladora++;
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arvore arvore = new Arvore();

        arvore.setNumero(scanner.nextInt());
        arvore.printArvore();

        scanner.close();
    }

}
