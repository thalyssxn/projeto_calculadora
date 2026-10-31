package calculadora;

public class Calculadora {

    public double calc(int a, int b, String op) {
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
            if (b == 0) {
                throw new ArithmeticException("Erro: divisão por zero não é permitida.");
            }
            return (double) a / b;
        } else {
            throw new IllegalArgumentException("Operação inválida: '" + op + "'. Use +, -, * ou /.");
        }
    }
}
