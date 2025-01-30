public class Calculadora {
    private Stack<Integer> stack;

    // Constructor acepta cualquier implementación de Stack<Integer>
    public Calculadora(Stack<Integer> stack) {
        this.stack = stack;
    }

    // Método para evaluar una expresión postfix
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

    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esOperador(String token) {
        return "+-*/%".contains(token);
    }

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