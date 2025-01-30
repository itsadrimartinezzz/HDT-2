import javax.management.RuntimeErrorException;
import java.io.*;
import java.io.BufferedReader;
public class ReadFile {

    public String LeerArchivo(String ruta){//al llamar el metodo colocar la ruta del archivo
        File archivo;
        FileReader fr;
        BufferedReader br;
        String linea;

        try{
            archivo = new File(ruta); //abrimos el archivo
            fr = new FileReader(archivo); //lectura del archivo
            br = new BufferedReader(fr); //guardar en memoria lo que vamos a leer


            while((linea = br.readLine()) != null){ //vamos recorriendo por lineas de codigo y captura el salto
                return linea;

            }
            br.close();
            fr.close();


        }   catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
