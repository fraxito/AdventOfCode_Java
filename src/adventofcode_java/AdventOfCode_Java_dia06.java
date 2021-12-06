package adventofcode_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE_HP
 */
public class AdventOfCode_Java_dia06 {
  
    public int cuentaCambios(){
        int cambios = 0;
        ArrayList<Integer> listaPeces = new ArrayList<>();
        try {
            String nombrefichero="../datos/datos_6.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String [] numeros = (br.readLine()).split(",");
            for (int i=0; i<numeros.length; i++){
                listaPeces.add(Integer.parseInt(numeros[i]));
            }
            //ya están los datos en el arraylist
            int numpeces = 0;
            int nacimientos = 0;
            int pez;
            for (int i=0; i<80; i++){
                numpeces = listaPeces.size();
                for (int j=0; j<numpeces;j++) {
                    pez = listaPeces.get(j);
                    pez--;
                    if (pez == -1){nacimientos++;pez=6;}
                    listaPeces.set(j, pez);
                    //System.out.print(listaPeces.get(j)+", ");
                }
                for (int j=0; j<nacimientos;j++) {
                    listaPeces.add(8);
                }
                numpeces = listaPeces.size();

                nacimientos = 0;
            }
            
            fstream.close();
            System.out.println("");
            System.out.println("HAY : "+listaPeces.size());

        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia06.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia06.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia06 p = new AdventOfCode_Java_dia06();
        System.out.println (p.cuentaCambios());
    }
    
}
