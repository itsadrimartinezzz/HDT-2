import org.junit.*;

public class CalculadoraTest {

    @Test
    public void testEvaluarExpresionSimple() {
        Stack<Integer> stack = new VectorStack<>();
        Calculadora calc = new Calculadora(stack);
        Assert.assertEquals(15, calc.evaluar("1 2 + 4 * 3 +"));
    }

    @Test
    public void testDivisionPorCero() {
        Stack<Integer> stack = new VectorStack<>();
        Calculadora calc = new Calculadora(stack);
        
        try {
            calc.evaluar("5 0 /");
            Assert.fail("Se esperaba una excepción de división por cero.");
        } catch (ArithmeticException e) {
            Assert.assertEquals("División por cero.", e.getMessage());
        }
    }

    @Test
    public void testExpresionInvalida() {
        Stack<Integer> stack = new VectorStack<>();
        Calculadora calc = new Calculadora(stack);
        
        try {
            calc.evaluar("1 +");
            Assert.fail("Se esperaba una excepción por expresión inválida.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Expresión inválida: no hay suficientes operandos.", e.getMessage());
        }
    }
}