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

import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author JORGE_HP
 */
public class AdventOfCode_Java_dia07 {
  

    public int cuentaCambios(){
        int cambios = 0;
        try {
            String nombrefichero="../datos/datos_7_2.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            
            String[] agesStrings = (br.readLine()).split(",");
            ArrayList<Integer> listaCangrejos = new ArrayList<>();
            for (String ageString : agesStrings) {
                listaCangrejos.add(Integer.parseInt(ageString.trim()));
            }
            int maximo = Collections.max(listaCangrejos);
            int minimo = Collections.min(listaCangrejos);
            ArrayList<Integer> listaCostes = new ArrayList<>();

            int fuel = 0;
            for (int i = minimo; i < maximo; i++) {
                fuel=0;
                for (Integer cangrejo : listaCangrejos) {
                    fuel+= Math.abs(i-cangrejo);
                }
                listaCostes.add(fuel);
            }
            
            int minimoCoste = Collections.min(listaCostes);
            
            fstream.close();
            System.out.println("El minimo coste es : "+minimoCoste);
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia07.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia07.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia07 p = new AdventOfCode_Java_dia07();
        System.out.println (p.cuentaCambios());
             
    }
    
}
