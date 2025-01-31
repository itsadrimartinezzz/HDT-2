import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
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
