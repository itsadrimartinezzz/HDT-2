import java.util.Vector;

// Definición de la interfaz Stack<E> si no existe
interface Stack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}

// Implementación de la pila con Vector
public class VectorStack<E> implements Stack<E> {
    private Vector<E> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack vacío");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack vacío");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
