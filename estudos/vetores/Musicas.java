import java.util.Scanner;

public class Musicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String musica1 = scanner.nextLine();
        String musica2 = scanner.nextLine();
        String musica3 = scanner.nextLine();
        // String musica4 = scanner.nextLine();
        // String musica5 = scanner.nextLine();
        // String musica6 = scanner.nextLine();
        // String musica7 = scanner.nextLine();
        // String musica8 = scanner.nextLine();

        scanner.close();

        System.out.printf("Musica 1: %s\n", musica1);
        System.out.printf("Musica 2: %s\n", musica2);
        System.out.printf("Musica 3: %s\n", musica3);
        // System.out.printf("Musica 4: %s\n", musica4);
        // System.out.printf("Musica 5: %s\n", musica5);
        // System.out.printf("Musica 6: %s\n", musica6);
        // System.out.printf("Musica 7: %s\n", musica7);
        // System.out.printf("Musica 8: %s\n", musica8);
    }
}