import java.util.Scanner;

public class JogoDaVelha {
    public static char matriz[][] = new char[3][3]; // Cria a Matriz do jogo da velha

    public static void main(String[] args) {
        int numeroDeJogadas = 0;
        char resultado = ' ';
        inicializaMatriz(); // Preenche a Matriz
        do {
            imprimeMatriz(); // Mostra a matriz
            jogadaDoUsuario(1, 'X');
            numeroDeJogadas++;
            resultado = verificaVencedor();
            // Verifica se o jogador 1 venceu ou se já foram 9 jogadas
            if (resultado == 'X' || numeroDeJogadas == 9)
                break;
            imprimeMatriz();
            jogadaDoUsuario(2, 'O');
            numeroDeJogadas++;
            resultado = verificaVencedor();
            // Verifica se o jogador 2 venceu
            if (resultado == 'O')
                break;
        } while ((resultado == ' ') && (numeroDeJogadas != 9));
        imprimeMatriz();
        if (resultado == 'X')
            System.out.println("Jogador 1 ganhou!");
        else if (resultado == 'O')
            System.out.println("Jogador 2 ganhou!");
        else
            System.out.println("O jogo empatou!!!");
    }

    public static void inicializaMatriz() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matriz[i][j] = ' ';
    }

    public static void imprimeMatriz() {
        for (int i = 0; i < 3; i++) {
            System.out.printf(" %c | %c | %c ",
                    matriz[i][0], matriz[i][1], matriz[i][2]);
            if (i != 2)
                System.out.printf("\n---|---|---\n");
        }
        System.out.printf("\n");
    }

    public static void jogadaDoUsuario(int usuario, char simbolo) {
        Scanner entrada = new Scanner(System.in);
        // Complete o código aqui...
        System.out.println("1 - Superior Esquerdo");
        System.out.println("2 - Superior Meio");
        System.out.println("3 - Superior Direito");
        System.out.println("4 - Meio Esquerdo");
        System.out.println("5 - Meio");
        System.out.println("6 - Meio Direito");
        System.out.println("7 - Inferior Esquerdo");
        System.out.println("8 - Inferior Meio");
        System.out.println("9 - Inferior Direito");
        System.out.println("Digite o número: ");
        int num = entrada.nextInt();
        switch (num) {
            case 1:
                if (matriz[0][0] == 'X' || matriz[0][0] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else
                    matriz[0][0] = simbolo;
                break;
            case 2:
                if (matriz[0][1] == 'X' || matriz[0][1] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else
                    matriz[0][1] = simbolo;

                break;
            case 3:
                if (matriz[0][2] == 'X' || matriz[0][2] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[0][2] = simbolo;
                }
                break;
            case 4:
                if (matriz[1][0] == 'X' || matriz[1][0] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[1][0] = simbolo;
                }
                break;
            case 5:
                if (matriz[1][1] == 'X' || matriz[1][1] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[1][1] = simbolo;
                }
                break;
            case 6:
                if (matriz[1][2] == 'X' || matriz[1][2] == 'O') {
                    System.err.println("Posição invalida, Tente novamente!!");

                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[1][2] = simbolo;
                }
                break;
            case 7:
                if (matriz[2][0] == 'X' || matriz[2][0] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[2][0] = simbolo;
                }
                break;
            case 8:
                if (matriz[2][1] == 'X' || matriz[2][1] == 'O') {
                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);

                } else {
                    matriz[2][1] = simbolo;
                }
                break;
            case 9:
                if (matriz[2][2] == 'X' || matriz[2][2] == 'O') {

                    System.err.println("Posição invalida, Tente novamente!!");
                    jogadaDoUsuario(usuario, simbolo);
                } else {
                    matriz[2][2] = simbolo;
                }
                break;

        }
    }

    public static char verificaVencedor() {
        // Verifica as linhas
        for (int i = 0; i < 3; i++)
            if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2])
                return matriz[i][0];
        // Verifica as colunas
        for (int i = 0; i < 3; i++)
            if (matriz[0][i] == matriz[1][i] && matriz[0][i] == matriz[2][i])
                return matriz[0][i];
        // Verifica diagonais
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2])
            return matriz[0][0];
        if (matriz[2][0] == matriz[1][1] && matriz[1][1] == matriz[0][2])
            return matriz[0][2];
        // Se não encontrou vencedor, retorna "espaço"
        return ' ';
    }
}