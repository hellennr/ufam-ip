import java.util.Scanner;

public class MusicasVetor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qtd = 3;
        String[] musicas = new String[qtd];

        // musicas[0] = scanner.nextLine();

        for (int i = 0; i < qtd; i++) {
            musicas[i] = scanner.nextLine();
        }

        // System.out.printf("Musica 1: %s\n", musicas[0]);

        for (int i = 0; i < qtd; i++) {
            System.out.printf("Musica %d: %s\n", i + 1, musicas[i]);
        }
    }

}
