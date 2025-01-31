/**
 * Implementación de una pila utilizando la clase Vector de Java.
 * 
 * <p>
 * Fecha de inicio: 23/01/2025<br>
 * Fecha de finalización: 30/01/2025
 * </p>
 * 
 * @param <E> el tipo de elementos almacenados en la pila
 * 
 * @author Adriana Martinez
 * @author Derek Coronado
 * @author Luis Figueroa
 */
import java.util.Vector;

public class StackVector<E> implements Stack<E> {
    private Vector<E> stack;

    /**
     * Constructor que inicializa la pila utilizando un Vector.
     */
    public StackVector() {
        stack = new Vector<>();
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     * 
     * @param item el elemento a agregar a la pila
     */
    @Override
    public void push(E item) {
        stack.add(item);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * 
     * @return el elemento removido de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack vacío");
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * 
     * @return el elemento en la parte superior de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack vacío");
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la pila.
     * 
     * @return el tamaño de la pila
     */
    @Override
    public int size() {
        return stack.size();
    }
}
