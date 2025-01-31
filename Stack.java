/**
 * Interfaz que define las operaciones básicas de una pila (Stack).
 * 
 * <p>
 * Fecha de inicio: 23/01/2025<br>
 * Fecha de finalización: 30/01/2025
 * </p>
 * 
 * @param <E> el tipo de elementos que contendrá la pila.
 * 
 * @author Adriana Martinez
 * @author Derek Coronado
 * @author Luis Figueroa
 */
public interface Stack<E> {

    /**
     * Agrega un elemento a la parte superior de la pila.
     * 
     * @param item el elemento a agregar.
     */
    void push(E item);

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * 
     * @return el elemento eliminado de la parte superior de la pila.
     */
    E pop();

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * 
     * @return el elemento en la parte superior de la pila.
     */
    E peek();

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();

    /**
     * Devuelve el número de elementos en la pila.
     * 
     * @return el tamaño de la pila.
     */
    int size();
}
