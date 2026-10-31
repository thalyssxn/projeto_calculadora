package calculadora;

import java.util.Scanner;

public class Principal {

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

            String[] partes = linha.split("\\s+");
            if (partes.length != 3) {
                System.out.println("Formato inválido. Use: <numero> <operacao> <numero>");
                continue;
            }

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
