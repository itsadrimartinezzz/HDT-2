import java.io.*;

public class ReadFile {

    public String LeerArchivo(String ruta) {
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("Error: Archivo no encontrado en " + archivo.getAbsolutePath());
            return "";
        }

        StringBuilder contenido = new StringBuilder();

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
