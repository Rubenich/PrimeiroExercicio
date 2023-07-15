import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Outroloop {
    public Outroloop() {
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        int numeroTentativas = 0;
        boolean entradaValida = false;

        for (int i = 0; i <= 4; ++i) {
            System.out.println("Digite 5 números e tente achar o número de 0 a 100");

            int numero = 0;
            while (!entradaValida) {
                try {
                    numero = leitura.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número válido.");
                    leitura.next(); // Limpa o buffer do scanner
                }
            }

            if (numero > numeroAleatorio) {
                System.out.println("O número que procuras é menor");
                ++numeroTentativas;
                System.out.println("Total de tentativas: " + numeroTentativas);
            } else if (numero == numeroAleatorio) {
                System.out.println("Parabéns, você acertou!");
                ++numeroTentativas;
                System.out.println("Total de tentativas: " + numeroTentativas);
                break;
            } else {
                System.out.println("O número que procuras é maior");
                ++numeroTentativas;
                System.out.println("Total de tentativas: " + numeroTentativas);
            }

            if (numeroTentativas == 5) {
                System.out.println("O número não foi encontrado, aqui está o número certo: " + numeroAleatorio);
            }

            entradaValida = false; // Resetar a flag para a próxima iteração
        }
    }
}

