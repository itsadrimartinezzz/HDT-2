/**
 * Clase principal que lee expresiones matemáticas desde un archivo, las evalúa utilizando la clase Calculadora
 * y muestra los resultados.
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    /**
     * Método principal que lee un archivo de texto con expresiones matemáticas, las evalúa y muestra los resultados.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        String rutaArchivo = "datos.txt"; // Asegúrate de que el archivo esté en la misma carpeta que el programa

        // Leer el archivo
        String contenido;
        try {
            contenido = Files.readString(Paths.get(rutaArchivo));
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo " + rutaArchivo);
            return;
        }

        // Verificar si el archivo tiene contenido válido
        if (contenido.trim().isEmpty()) {
            System.out.println("Error: No se encontró una expresión válida en " + rutaArchivo);
            return;
        }

        // Separar por líneas para evaluar múltiples expresiones
        String[] lineas = contenido.split("\n");

        // Crear calculadora con StackVector
        Stack<Integer> miPila = new StackVector<>();
        Calculadora calculadora = new Calculadora(miPila);

        // Evaluar cada línea y mostrar el resultado
        for (String expresion : lineas) {
            expresion = expresion.trim(); // Eliminar espacios en blanco
            if (!expresion.isEmpty()) {
                try {
                    int resultado = calculadora.evaluar(expresion);
                    System.out.println("Resultado de '" + expresion + "': " + resultado);
                } catch (Exception e) {
                    System.out.println("Error al evaluar '" + expresion + "': " + e.getMessage());
                }
            }
        }
    }
}
