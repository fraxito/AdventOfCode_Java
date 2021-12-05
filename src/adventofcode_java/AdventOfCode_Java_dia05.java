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
public class AdventOfCode_Java_dia05 {
  
    public int cuentalineas(String nombrefichero) {

      int lineas = 0;

        try {
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream;
            fstream = new FileInputStream(new File(nombreArchivo)); 
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                lineas++;
            }
        } catch (FileNotFoundException ex) {} catch (URISyntaxException ex) {} catch (IOException ex) {
        }

            
            
      return lineas;

  }
  
    public int[] formateaArray(String n){
        int[] numeros = new int[5];
        for (int i=0; i<5; i++){
            numeros[i]=Integer.parseInt((n.substring(3*i, 3*i+2)).trim());
        }
        return numeros;
    }
    
    
    public int cuentaCambios(){
        int cambios = 0;
        ArrayList<int[][]> listaCoordenadas = new ArrayList<>();
        try {
            String nombrefichero="../datos/datos_5_1.txt";
            int numlineas = cuentalineas(nombrefichero);
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int[][] mapa = new int[1000][1000];
            while ((strLine = br.readLine()) != null)   {
                String [] parejas = strLine.split("->");
                String [] parejaA = parejas[0].split(",");
                String [] parejaB = parejas[1].split(",");
                int [] pareja = new int[4];
                pareja[0]=Integer.parseInt(parejaA[0].trim());
                pareja[1]=Integer.parseInt(parejaA[1].trim());
                pareja[2]=Integer.parseInt(parejaB[0].trim());
                pareja[3]=Integer.parseInt(parejaB[1].trim());
                System.out.println(Arrays.toString(pareja));
            
                if (pareja[0] == pareja[2]){ //la x es igual, va en horizontal
                    for (int i=pareja[1]; i <= pareja[3]; i++){
                        mapa[pareja[0]][i]++;
                    }
                    for (int i=pareja[3]; i <= pareja[1]; i++){
                        mapa[pareja[0]][i]++;
                    }
                }
                else if (pareja[1] == pareja[3]){
                    for (int i=pareja[0]; i <= pareja[2]; i++){
                        mapa[i][pareja[1]]++;
                    }
                    for (int i=pareja[2]; i <= pareja[0]; i++){
                        mapa[i][pareja[1]]++;
                    }                    
                }
            }
            //ya están los datos en el array
            int contador = 0;
            for(int i=0; i<1000; i++){
               for(int j=0; j<1000; j++){
                   if (mapa[i][j]>1){
                    System.out.print(mapa[i][j] + " ");
                    contador++;
                   }
               }  
               //
            }
            //Close System.out.println("");the input stream
            fstream.close();
            System.out.println("");
            System.out.println("HAY : "+contador);
            
            
            
            
            
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia05.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia05.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia05 p = new AdventOfCode_Java_dia05();
        System.out.println (p.cuentaCambios());
    }
    
}
