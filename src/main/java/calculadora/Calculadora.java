package calculadora;

/**
 * Módulo de cálculos matemáticos básicos do aplicativo FinançApp.
 * <p>
 * Esta classe é usada por funcionalidades como cálculo de orçamento mensal,
 * divisão de despesas e projeção de economia. Ela realiza as quatro
 * operações básicas (soma, subtração, multiplicação e divisão) e trata
 * os casos de erro: divisão por zero e operação inválida.
 * </p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 * Calculadora calculadora = new Calculadora();
 * double total = calculadora.calc(1200, 3, "/"); // 400.0
 * </pre>
 *
 * @author Thalysson Sergio Fernandes Soares
 * @version 1.0
 */
public class Calculadora {

    /**
     * Cria uma nova calculadora. A classe não guarda estado,
     * então a mesma instância pode ser reutilizada em vários cálculos.
     */
    public Calculadora() {
        // Nenhuma inicialização necessária
    }

    /**
     * Realiza uma operação matemática básica entre dois números inteiros.
     * <p>
     * O resultado é retornado como {@code double} para que divisões não
     * exatas (por exemplo, {@code 7 / 2}) não percam as casas decimais e
     * para evitar estouro de {@code int} em somas e multiplicações grandes.
     * </p>
     *
     * @param a  primeiro operando
     * @param b  segundo operando (na divisão, é o divisor)
     * @param op operação desejada: {@code "+"}, {@code "-"}, {@code "*"} ou {@code "/"}
     * @return o resultado da operação
     * @throws ArithmeticException      se a operação for divisão e {@code b} for zero
     * @throws IllegalArgumentException se {@code op} for nula ou não for uma das operações suportadas
     */
    public double calc(int a, int b, String op) {
        // Verifica se a operação foi informada
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida: nenhuma operação informada. Use +, -, * ou /.");
        }
        if (op.equals("+")) {
            return (double) a + b;
        } else if (op.equals("-")) {
            return (double) a - b;
        } else if (op.equals("*")) {
            return (double) a * b;
        } else if (op.equals("/")) {
            // Divisão por zero não é permitida
            if (b == 0) {
                throw new ArithmeticException("Erro: divisão por zero não é permitida.");
            }
            return (double) a / b;
        } else {
            // Operação não reconhecida
            throw new IllegalArgumentException("Operação inválida: '" + op + "'. Use +, -, * ou /.");
        }
    }
}
