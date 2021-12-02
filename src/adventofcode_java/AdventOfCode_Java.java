package adventofcode_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE_HP
 */
public class AdventOfCode_Java {

    public int cuentaCambios(){
        int cambios = 0;

        try {
            URI nombreArchivo = getClass().getResource("datos.txt").toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int numeroA = Integer.valueOf(br.readLine());
            
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
              // Print the content on the console
              System.out.println (strLine);
              if (numeroA < Integer.valueOf(strLine)){
                  cambios++;
              }
              numeroA = Integer.valueOf(strLine);
            }

            //Close the input stream
            fstream.close();

        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java p = new AdventOfCode_Java();
        System.out.println (p.cuentaCambios());
    }
    
}
