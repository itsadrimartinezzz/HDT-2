public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "datos.txt"; // Asegúrate de que el archivo esté en la misma carpeta que el programa

        // Leer el archivo
        ReadFile lector = new ReadFile();
        String contenido = lector.LeerArchivo(rutaArchivo);

        // Verificar si el archivo tiene contenido válido
        if (contenido.trim().isEmpty()) {
            System.out.println("Error: No se encontró una expresión válida en " + rutaArchivo);
            return;
        }

        // Separar por líneas para evaluar múltiples expresiones
        String[] lineas = contenido.split("\n");

        // Crear calculadora con VectorStack
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