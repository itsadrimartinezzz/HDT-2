/**
 * Interfaz que define los métodos para evaluar operaciones matemáticas y realizar cálculos con operandos.
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
public interface Interfaz {

    /**
     * Evalúa una operación matemática y devuelve el resultado.
     * 
     * @param operacion La operación matemática en forma de cadena.
     * @return El resultado de la operación.
     */
    int evaluar(String operacion);

    /**
     * Realiza una operación matemática entre dos operandos utilizando un operador especificado.
     * 
     * @param operandoA El primer operando.
     * @param operandoB El segundo operando.
     * @param operador El operador matemático a utilizar (e.g., "+", "-", "*", "/", "%").
     * @return El resultado de la operación.
     */
    int operar(int operandoA, int operandoB, String operador);
}
