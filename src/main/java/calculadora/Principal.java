package calculadora;

import java.util.Scanner;

/**
 * Ponto de entrada da aplicação de console da calculadora do FinançApp.
 * <p>
 * Lê expressões no formato {@code <numero> <operacao> <numero>} (por exemplo,
 * {@code 10 / 2}) e mostra o resultado. Todos os erros (divisão por zero,
 * operação inválida, texto no lugar de número) são capturados e exibidos
 * como mensagem, sem interromper a execução do programa.
 * </p>
 *
 * @author Thalysson Sergio Fernandes Soares
 * @version 1.0
 */
public class Principal {

    /**
     * Construtor privado: a classe só possui o método estático {@link #main(String[])}.
     */
    private Principal() {
    }

    /**
     * Inicia o laço de leitura de expressões até o usuário digitar {@code sair}.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== FinançApp - Calculadora ===");
        System.out.println("Digite: <numero> <operacao> <numero>  (ex.: 10 / 2)");
        System.out.println("Operações: +  -  *  /     Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("> ");
            if (!entrada.hasNextLine()) {
                break;
            }
            String linha = entrada.nextLine().trim();
            if (linha.equalsIgnoreCase("sair")) {
                break;
            }
            if (linha.isEmpty()) {
                continue;
            }

            // Separa os números e a operação
            String[] partes = linha.split("\\s+");
            if (partes.length != 3) {
                System.out.println("Formato inválido. Use: <numero> <operacao> <numero>");
                continue;
            }

            // Trata os erros sem encerrar o programa
            try {
                int a = Integer.parseInt(partes[0]);
                int b = Integer.parseInt(partes[2]);
                double resultado = calculadora.calc(a, b, partes[1]);
                System.out.println("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                System.out.println("Erro: informe apenas números inteiros.");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Calculadora encerrada.");
        entrada.close();
    }
}
