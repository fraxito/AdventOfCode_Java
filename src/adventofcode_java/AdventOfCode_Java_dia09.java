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
public class AdventOfCode_Java_dia09 {

      
  
public int minimo(int x, int y, int f, int c, int[][]mapa) { 
    int[] valores = {10,10,10,10}; 
    //arriba
    if (x-1 >= 0 ){valores[0]=mapa[x-1][y];} 
    if (y-1 >= 0 ){valores[1]=mapa[x][y-1];}
    if (x+1 < f ){valores[2]=mapa[x+1][y];}
    if (y+1 < c ){valores[3]=mapa[x][y+1];}
    Arrays.sort(valores);
    if (valores[0]>mapa[x][y]){
        return mapa[x][y];
    }
    return -1;
}
    public int cuentaCambios(){
        int cambios = 0;
        try {
            String nombrefichero="../datos/datos_9.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            ArrayList<String> listaNumeros = new ArrayList();
            String strLine;
            int filas = 0;
            while ((strLine = br.readLine()) != null)   {
               filas++;
               listaNumeros.add(strLine);
            }
            int columnas = listaNumeros.get(0).length();
            int[][]mapa = new int[filas][columnas];
            for (int i=0; i<filas; i++){
                for (int j=0; j<columnas; j++){
                    mapa[i][j]=Integer.parseInt(listaNumeros.get(i).charAt(j)+"");
                }
            }
            for (int i=0; i<filas; i++){
                for (int j=0; j<columnas; j++){
                    cambios += minimo(i,j,filas,columnas,mapa)+1;
                    //System.out.print(+" ");
                }
                System.out.println();
            }
            
            
            fstream.close();
            
            
            
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia09.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia09.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia09 p = new AdventOfCode_Java_dia09();
        System.out.println (p.cuentaCambios());
             
    }
    
}
