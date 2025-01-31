/**
 * Clase Calculadora que implementa una interfaz para realizar evaluaciones de expresiones y operaciones matemáticas.
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
public class Calculadora implements Interfaz {
    private Stack<Integer> stack;

    /**
     * Constructor de la clase Calculadora.
     * 
     * @param stack Una implementación de la interfaz Stack&lt;Integer&gt; que se utilizará para manejar los operandos.
     */
    public Calculadora(Stack<Integer> stack) {
        this.stack = stack;
    }

    /**
     * Evalúa una expresión en notación postfija y devuelve el resultado.
     * 
     * @param expresion La expresión en notación postfija a evaluar.
     * @return El resultado de la evaluación de la expresión.
     * @throws IllegalArgumentException Si la expresión es inválida.
     */
    @Override
    public int evaluar(String expresion) throws IllegalArgumentException {
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (esNumero(token)) {
                stack.push(Integer.parseInt(token));
            } else if (esOperador(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida: no hay suficientes operandos.");
                }
                int b = stack.pop();
                int a = stack.pop();
                int resultado = realizarOperacion(a, b, token);
                stack.push(resultado);
            } else {
                throw new IllegalArgumentException("Expresión inválida: token desconocido '" + token + "'.");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida: operandos sobrantes.");
        }

        return stack.pop();
    }

    /**
     * Realiza una operación entre dos operandos utilizando un operador especificado.
     * 
     * @param operandoA El primer operando.
     * @param operandoB El segundo operando.
     * @param operador El operador matemático a utilizar.
     * @return El resultado de la operación.
     */
    @Override
    public int operar(int operandoA, int operandoB, String operador) {
        return realizarOperacion(operandoA, operandoB, operador);
    }

    /**
     * Verifica si un token dado representa un número.
     * 
     * @param token El token a evaluar.
     * @return {@code true} si el token es un número, de lo contrario {@code false}.
     */
    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica si un token dado representa un operador matemático válido.
     * 
     * @param token El token a evaluar.
     * @return {@code true} si el token es un operador válido, de lo contrario {@code false}.
     */
    private boolean esOperador(String token) {
        return "+-*/%".contains(token);
    }

    /**
     * Realiza una operación matemática entre dos operandos dados utilizando un operador especificado.
     * 
     * @param a El primer operando.
     * @param b El segundo operando.
     * @param operador El operador matemático a utilizar.
     * @return El resultado de la operación.
     * @throws IllegalArgumentException Si el operador es desconocido.
     * @throws ArithmeticException Si se intenta realizar una división o módulo por cero.
     */
    private int realizarOperacion(int a, int b, String operador) {
        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("División por cero.");
                yield a / b;
            }
            case "%" -> {
                if (b == 0) throw new ArithmeticException("División por cero.");
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Operador desconocido: " + operador);
        };
    }
}
