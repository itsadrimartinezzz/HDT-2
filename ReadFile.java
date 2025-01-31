/**
 * Clase que proporciona un método para leer el contenido de un archivo de texto.
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
import java.io.*;

public class ReadFile {

    /**
     * Lee el contenido de un archivo de texto dado su ruta.
     * 
     * @param ruta Ruta del archivo a leer.
     * @return El contenido del archivo como una cadena de texto.
     *         Si el archivo no existe, devuelve una cadena vacía.
     * @throws RuntimeException si ocurre un error al leer el archivo.
     */
    public String LeerArchivo(String ruta) {
        File archivo = new File(ruta);

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            System.out.println("Error: Archivo no encontrado en " + archivo.getAbsolutePath());
            return "";
        }

        StringBuilder contenido = new StringBuilder();

        // Leer el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }

        return contenido.toString().trim();
    }
}
