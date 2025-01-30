public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\adria_qibhpui\\OneDrive\\Escritorio\\Estructura de Datos\\hdt#2\\datos.txt"; // RUTA ABSOLUTA

        // Leer el archivo
        ReadFile lector = new ReadFile();
        String expresion = lector.LeerArchivo(rutaArchivo);

        // Verificar si la expresión es válida
        if (expresion.trim().isEmpty()) {
            System.out.println("Error: No se encontró una expresión válida en " + rutaArchivo);
            return;
        }

        // Crear calculadora con VectorStack
        Stack<Integer> miPila = new VectorStack<>();
        Calculadora calculadora = new Calculadora(miPila);

        // Evaluar la expresión y mostrar el resultado
        try {
            int resultado = calculadora.evaluar(expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


