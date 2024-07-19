public class Main {

    public static void main(String[] args) {
        int[] ordemDasMatrizes = { 3, 5, 7, 9, 11 };
        long seed;

        int res;
        long inicio, fim, tempo, tempoMedio, tempoTotal = 0L;

        int resOtim;
        long inicioOtim, fimOtim, tempoOtim, tempoMedioOtim, tempoTotalOtim = 0L;

        for (int j = 0; j < 5; j++) {
            System.out.printf("\n\n\t🧮 Matrizes de ordem %d\n", ordemDasMatrizes[j]);

            tempoTotal = 0L;
            tempoTotalOtim = 0L;

            for (int i = 0; i < 3; i++) {
                Matriz matriz = new Matriz(ordemDasMatrizes[j]);
                Matriz matrizOtim = new Matriz(ordemDasMatrizes[j]);

                // Pega uma seed aleatória baseada no tempo atual
                seed = System.currentTimeMillis();

                // Cria matrizes baseada na mesma seed
                matriz.criaMatrizesComSeed(seed);
                matrizOtim.criaMatrizesComSeed(seed);

                // Calcula determinante sem otimizações
                inicio = System.nanoTime();
                res = matriz.determinante();
                fim = System.nanoTime();
                tempo = fim - inicio;
                tempoTotal += tempo;

                inicioOtim = System.nanoTime();
                resOtim = matriz.determinanteOtimizado();
                fimOtim = System.nanoTime();
                tempoOtim = fimOtim - inicioOtim;
                tempoTotalOtim += tempoOtim;

                System.out.printf("\n\t\tRodada %d", i + 1);
                System.out.printf("\nDeterminante sem otim.\t%d\n", res);
                System.out.printf("Tempo sem otim.\t\t%.3f ms\n", tempo / 1_000_000.0);
                System.out.printf("Determinante com otim.\t%d\n", resOtim);
                System.out.printf("Tempo com otim.\t\t%.3f ms\n", tempoOtim / 1_000_000.0);
            }
            // Calculando a media de cada metodo
            tempoMedio = tempoTotal / 3;
            tempoMedioOtim = tempoTotalOtim / 3;

            System.out.printf("\nTempo médio sem otimização: \t%d ns", tempoMedio);
            System.out.printf("\nTempo médio com otimização: \t%d ns", tempoMedioOtim);
            System.out.printf("\nGanhos da otimização: \t\t%d ns\n", (tempoMedio -
                    tempoMedioOtim));

            // System.out.printf("\nTempo médio sem otimização: \t%.3f ms", tempoMedio /
            // 1_000_000.0);
            // System.out.printf("\nTempo médio com otimização: \t%.3f ms", tempoMedioOtim /
            // 1_000_000.0);
            // System.out.printf("\nGanhos da otimização: \t\t%.3f ms", (tempoMedio -
            // tempoMedioOtim) / 1_000_000.0);
            // System.out.printf("\n\n");
        }
    }
}