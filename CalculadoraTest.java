/**
 * Clase de prueba para la clase Calculadora.
 * 
 * <p>
 * Fecha de inicio: 23/01/2025<br>
 * Fecha de finalización: 30/01/2025
 * </p>
 * 
 * @author Adriana Martinez
 * @author Derek Coronado
 * @author Luis Figueroa
 */
import org.junit.*;

public class CalculadoraTest {

    /**
     * Prueba unitaria para evaluar una expresión simple en notación postfija.
     * Se espera que el resultado sea el valor correcto de la expresión.
     */
    @Test
    public void testEvaluarExpresionSimple() {
        Stack<Integer> stack = new StackVector<>();
        Calculadora calc = new Calculadora(stack);
        Assert.assertEquals(15, calc.evaluar("1 2 + 4 * 3 +"));
    }

    /**
     * Prueba unitaria para verificar que se lanza una excepción al intentar dividir por cero.
     * Se espera que se capture una excepcion de tipo {@link ArithmeticException} con el mensaje correspondiente.
     */
    @Test
    public void testDivisionPorCero() {
        Stack<Integer> stack = new StackVector<>();
        Calculadora calc = new Calculadora(stack);

        try {
            calc.evaluar("5 0 /");
            Assert.fail("Se esperaba una excepción de división por cero.");
        } catch (ArithmeticException e) {
            Assert.assertEquals("División por cero.", e.getMessage());
        }
    }

    /**
     * Prueba unitaria para verificar que se lanza una excepción al evaluar una expresión inválida.
     * Se espera que se capture una excepción de tipo {@link IllegalArgumentException} con el mensaje correspondiente.
     */
    @Test
    public void testExpresionInvalida() {
        Stack<Integer> stack = new StackVector<>();
        Calculadora calc = new Calculadora(stack);

        try {
            calc.evaluar("1 +");
            Assert.fail("Se esperaba una excepción por expresión inválida.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Expresión inválida: no hay suficientes operandos.", e.getMessage());
        }
    }
}
