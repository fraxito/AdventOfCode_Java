package adventofcode_java;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author JORGE_HP
 */
public class AdventOfCode_Java_dia06b {
  

    public int cuentaCambios(){
        int cambios = 0;
        try {
            String nombrefichero="../datos/datos_6_1.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            
            String[] agesStrings = (br.readLine()).split(",");
            ArrayList<Integer> listaPeces = new ArrayList<>();
            for (String ageString : agesStrings) {
                listaPeces.add(Integer.parseInt(ageString.trim()));
            }
            long[] pecesPorEdades = new long[9];
            for (Integer pez : listaPeces) {
                pecesPorEdades[pez]++;
            }
            for (int i = 0; i < 256; i++) {
                long[] auxiliar = new long[9];
                System.arraycopy(pecesPorEdades, 1, auxiliar, 0, 8);
                auxiliar[8] = pecesPorEdades[0];
                auxiliar[6] = auxiliar[6] + pecesPorEdades[0];
                pecesPorEdades = auxiliar; 
            }
            long total = 0;
            for (int i = 0; i < 9; i++) {
                total += pecesPorEdades[i];
            }
            fstream.close();
            System.out.println("HAY : "+total);
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia06b.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia06b.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia06b p = new AdventOfCode_Java_dia06b();
        System.out.println (p.cuentaCambios());
             
    }
    
}
