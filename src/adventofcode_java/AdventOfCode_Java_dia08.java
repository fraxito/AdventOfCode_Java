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
public class AdventOfCode_Java_dia08 {
  

    public int cuentaCambios(){
        int cambios = 0;
        try {
            String nombrefichero="../datos/datos_8.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] linea = strLine.split("\\|"); //en Java para separar usando | hay que usar escape
                String[] numeros = linea[1].split(" ");
                for (int i=0; i<numeros.length; i++){
                    int m = numeros[i].length();
                    if (m==1 || m==4 || m==7 || m==8){
                        cambios++;
                    }
                }
            }

            fstream.close();
            System.out.println("El minimo coste es : "+cambios);
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia08.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia08.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia08 p = new AdventOfCode_Java_dia08();
        System.out.println (p.cuentaCambios());
             
    }
    
}
