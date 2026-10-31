package calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Testes unitários da classe {@link Calculadora}.
 * <p>
 * Cada teste exibe no console a entrada utilizada, o resultado esperado
 * e o resultado obtido, além de validar o resultado com asserções do JUnit 4.
 * </p>
 *
 * @author Thalysson Sergio Fernandes Soares
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCalculadora {

    /** Instância da calculadora testada, recriada antes de cada teste. */
    private Calculadora calculadora;

    /** Diferença máxima aceita na comparação de números decimais. */
    private static final double DELTA = 0.0001;

    /**
     * Cria uma nova calculadora antes de cada teste.
     */
    @Before
    public void prepararCalculadora() {
        calculadora = new Calculadora();
    }

    /**
     * Exibe no console os dados de um teste.
     *
     * @param nome     nome do teste
     * @param entrada  descrição da entrada utilizada
     * @param esperado resultado esperado
     * @param obtido   resultado obtido
     */
    private void exibir(String nome, String entrada, Object esperado, Object obtido) {
        System.out.println("[" + nome + "]");
        System.out.println("  Entrada:  " + entrada);
        System.out.println("  Esperado: " + esperado);
        System.out.println("  Obtido:   " + obtido);
        System.out.println();
    }

    /** Verifica a soma de dois números positivos. */
    @Test
    public void deveSomarDoisNumeros() {
        double obtido = calculadora.calc(10, 5, "+");
        exibir("Soma", "calc(10, 5, \"+\")", 15.0, obtido);
        assertEquals(15.0, obtido, DELTA);
    }

    /** Verifica a soma envolvendo número negativo. */
    @Test
    public void deveSomarComNumeroNegativo() {
        double obtido = calculadora.calc(-4, 9, "+");
        exibir("Soma com negativo", "calc(-4, 9, \"+\")", 5.0, obtido);
        assertEquals(5.0, obtido, DELTA);
    }

    /** Verifica a subtração de dois números. */
    @Test
    public void deveSubtrairDoisNumeros() {
        double obtido = calculadora.calc(10, 3, "-");
        exibir("Subtração", "calc(10, 3, \"-\")", 7.0, obtido);
        assertEquals(7.0, obtido, DELTA);
    }

    /** Verifica a subtração com resultado negativo. */
    @Test
    public void deveSubtrairComResultadoNegativo() {
        double obtido = calculadora.calc(3, 10, "-");
        exibir("Subtração com resultado negativo", "calc(3, 10, \"-\")", -7.0, obtido);
        assertEquals(-7.0, obtido, DELTA);
    }

    /** Verifica a multiplicação de dois números. */
    @Test
    public void deveMultiplicarDoisNumeros() {
        double obtido = calculadora.calc(6, 7, "*");
        exibir("Multiplicação", "calc(6, 7, \"*\")", 42.0, obtido);
        assertEquals(42.0, obtido, DELTA);
    }

    /** Verifica a multiplicação por zero. */
    @Test
    public void deveMultiplicarPorZero() {
        double obtido = calculadora.calc(8, 0, "*");
        exibir("Multiplicação por zero", "calc(8, 0, \"*\")", 0.0, obtido);
        assertEquals(0.0, obtido, DELTA);
    }

    /** Verifica a divisão exata. */
    @Test
    public void deveDividirDoisNumeros() {
        double obtido = calculadora.calc(20, 4, "/");
        exibir("Divisão", "calc(20, 4, \"/\")", 5.0, obtido);
        assertEquals(5.0, obtido, DELTA);
    }

    /** Verifica a divisão com resultado decimal. */
    @Test
    public void deveDividirComResultadoDecimal() {
        double obtido = calculadora.calc(7, 2, "/");
        exibir("Divisão com decimal", "calc(7, 2, \"/\")", 3.5, obtido);
        assertEquals(3.5, obtido, DELTA);
    }

    /** Verifica que a divisão por zero é impedida com exceção e mensagem. */
    @Test
    public void deveImpedirDivisaoPorZero() {
        ArithmeticException erro = assertThrows(ArithmeticException.class,
                () -> calculadora.calc(10, 0, "/"));
        exibir("Divisão por zero", "calc(10, 0, \"/\")",
                "ArithmeticException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
        assertEquals("Erro: divisão por zero não é permitida.", erro.getMessage());
    }

    /** Verifica que um operador desconhecido é rejeitado com mensagem. */
    @Test
    public void deveRejeitarOperacaoInvalida() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, "%"));
        exibir("Operação inválida", "calc(10, 5, \"%\")",
                "IllegalArgumentException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
        assertEquals("Operação inválida: '%'. Use +, -, * ou /.", erro.getMessage());
    }

    /** Verifica que uma operação vazia é rejeitada. */
    @Test
    public void deveRejeitarOperacaoVazia() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, ""));
        exibir("Operação vazia", "calc(10, 5, \"\")",
                "IllegalArgumentException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
    }

    /** Verifica que uma operação nula é rejeitada. */
    @Test
    public void deveRejeitarOperacaoNula() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, null));
        exibir("Operação nula", "calc(10, 5, null)",
                "IllegalArgumentException", erro.getClass().getSimpleName() + " - " + erro.getMessage());
    }
}
