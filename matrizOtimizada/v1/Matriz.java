import java.util.Random;

public class Matriz {
    private int[][] matriz;
    private int colunas, linhas;

    public Matriz(int ordem) {
        this.setColunas(ordem);
        this.setLinhas(ordem);
        this.matriz = new int[ordem][ordem];
    }

    public Matriz(int colunas, int linhas) {
        this.setColunas(colunas);
        this.setLinhas(linhas);
        this.matriz = new int[linhas][colunas];
    }

    public int getColunas() {
        return this.colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getValor(int i, int j) {
        return this.matriz[i][j];
    }

    public void setValor(int i, int j, int valor) {
        this.matriz[i][j] = valor;
    }

    public void criaMatrizes() {
        Random random = new Random();
        int ordem = this.ordem();
        int tamanhoRandom = ordem * ordem;

        if (ordem == -1) {
            System.out.println("A matriz não é quadrada!");
        } else {
            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < ordem; j++) {
                    matriz[i][j] = random.nextInt(tamanhoRandom);
                }
            }
        }
    }

    public void criaMatrizesComSeed(long seed) {
        Random random = new Random();
        random.setSeed(seed);
        int ordem = this.ordem();
        int tamanhoRandom = ordem * ordem;

        if (ordem == -1) {
            System.out.println("A matriz não é quadrada!");
        } else {
            for (int i = 0; i < ordem; i++) {
                for (int j = 0; j < ordem; j++) {
                    matriz[i][j] = random.nextInt(tamanhoRandom);
                }
            }
        }
    }

    public void imprimeMatrizes() {
        System.out.printf("Matriz completa:\n");
        int ordem = this.ordem();
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public int ordem() {
        int linhas = this.getLinhas();
        int colunas = this.getColunas();

        // Se não for quadrada, retorna -1
        int ordem = -1;
        if (linhas == colunas) {
            ordem = linhas;
        }
        return ordem;
    }

    public void copiaMatrizMaiorParaMenor(Matriz maior, Matriz menor, int iProibido, int jProibido) {
        int contAi, contAj, contBi, contBj;
        int temp, numLinhas, numColunas;

        numLinhas = menor.getLinhas();
        numColunas = menor.getColunas();

        contAi = 0;
        for (contBi = 0; contBi < numLinhas; contBi++) {
            if (contAi == iProibido) {
                contAi++;
            }
            contAj = 0;
            for (contBj = 0; contBj < numColunas; contBj++) {
                if (contAj == jProibido) {
                    contAj++;
                }
                temp = maior.getValor(contAi, contAj);
                menor.setValor(contBi, contBj, temp);
                contAj++;
            }
            contAi++;
        }
    }

    public int retornaSinal(int i, int j) {
        int sinal;
        if ((i + j) % 2 == 0) {
            sinal = 1;
        } else {
            sinal = -1;
        }
        return sinal;
    }

    public int determinanteOrdem1(Matriz matriz) {
        return matriz.getValor(0, 0);
    }

    public int determinanteOrdem2(Matriz matriz) {
        int diagonalPrincipal, diagonalSecundaria;
        diagonalPrincipal = matriz.getValor(0, 0) * matriz.getValor(1, 1);
        diagonalSecundaria = matriz.getValor(0, 1) * matriz.getValor(1, 0);
        return diagonalPrincipal - diagonalSecundaria;
    }

    public int determinanteOrdemN(Matriz matriz) {
        int cofator, sinal, det;
        Matriz matrizMenor;

        int resultado = 0;
        for (int j = 0; j < matriz.ordem(); j++) {
            cofator = matriz.getValor(0, j);
            sinal = matriz.retornaSinal(0, j);
            matrizMenor = new Matriz(matriz.getLinhas() - 1, matriz.getColunas() - 1);
            this.copiaMatrizMaiorParaMenor(matriz, matrizMenor, 0, j);
            det = matrizMenor.determinante();
            resultado = resultado + (cofator * sinal * det);
        }
        return resultado;
    }

    public int determinante() {
        int ordem = this.ordem();
        int determinante = 0;

        if (ordem > 0) {
            if (ordem == 1) {
                determinante = this.determinanteOrdem1(this);
            } else {
                if (ordem == 2) {
                    determinante = this.determinanteOrdem2(this);
                } else {
                    determinante = this.determinanteOrdemN(this);
                }
            }
        } else {
            System.out.println("Matriz não quadrada 🐑");
        }

        return determinante;
    }

    // OTIMIZAÇÕES!!!!

    public int determinanteOrdemNOtimizada(Matriz matriz) {
        Matriz matrizMenor;
        int cofator, sinal, det;
        int resultado = 0;

        int qtdZeros;
        int ordem = matriz.ordem();

        int maiorQtdZerosColuna = 0;
        int colunaMaisZeros = 0;

        for (int j = 0; j < ordem; j++) {
            qtdZeros = contaZerosColuna(j);
            if (qtdZeros > maiorQtdZerosColuna) {
                colunaMaisZeros = j;
                maiorQtdZerosColuna = qtdZeros;
            }
        }

        int maiorQtdZerosLinha = 0;
        int linhaMaisZeros = 0;

        for (int i = 0; i < ordem; i++) {
            qtdZeros = contaZerosLinha(i);
            if (qtdZeros > maiorQtdZerosLinha) {
                linhaMaisZeros = i;
                maiorQtdZerosLinha = qtdZeros;
            }
        }

        if (maiorQtdZerosLinha >= maiorQtdZerosColuna) {
            for (int j = 0; j < matriz.ordem(); j++) {
                cofator = matriz.getValor(linhaMaisZeros, j);
                if (cofator != 0) {
                    sinal = matriz.retornaSinal(linhaMaisZeros, j);
                    matrizMenor = new Matriz(matriz.getLinhas() - 1, matriz.getColunas() - 1);
                    this.copiaMatrizMaiorParaMenor(matriz, matrizMenor, linhaMaisZeros, j);
                    det = matrizMenor.determinante();
                    resultado = resultado + (cofator * sinal * det);
                }
            }
        } else {
            for (int i = 0; i < matriz.ordem(); i++) {
                cofator = matriz.getValor(i, colunaMaisZeros);
                if (cofator != 0) {
                    sinal = matriz.retornaSinal(i, colunaMaisZeros);
                    matrizMenor = new Matriz(matriz.getLinhas() - 1, matriz.getColunas() - 1);
                    this.copiaMatrizMaiorParaMenor(matriz, matrizMenor, i, colunaMaisZeros);
                    det = matrizMenor.determinante();
                    resultado = resultado + (cofator * sinal * det);
                }
            }
        }
        return resultado;
    }

    public int determinanteOtimizado() {
        int ordem = this.ordem();
        int determinante = 0;

        if (ordem > 0) {
            if (ordem == 1) {
                determinante = this.determinanteOrdem1(this);
            } else {
                if (ordem == 2) {
                    determinante = this.determinanteOrdem2(this);
                } else {
                    determinante = this.determinanteOrdemNOtimizada(this);
                }
            }
        } else {
            System.out.println("Matriz não quadrada 🐑");
        }

        return determinante;
    }

    public int contaZerosLinha(int linha) {
        int qtdZeros = 0;
        for (int i = 0; i < this.ordem(); i++) {
            if (this.matriz[linha][i] == 0) {
                qtdZeros++;
            }
        }
        return qtdZeros;

    }

    public int contaZerosColuna(int coluna) {
        int qtdZeros = 0;
        for (int i = 0; i < this.ordem(); i++) {
            if (this.matriz[i][coluna] == 0) {
                qtdZeros++;
            }
        }
        return qtdZeros;
    }
}