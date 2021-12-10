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
public class AdventOfCode_Java_dia10 {

      
  
    public int cuentaCambios(){
        int cambios = 0;
        try {
            String nombrefichero="../datos/datos_10.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            ArrayList<String> listaOperadores = new ArrayList();
            String strLine;
            char [] pila = new char[1000];
            int posicionPila = 0;
            char aux;
            int ilegal = 0;
            while ((strLine = br.readLine()) != null)   {
               for (int i=0; i<strLine.length(); i++){
                   if (ilegal==0){
                        aux = strLine.charAt(i);
                        if (aux=='(' || aux=='{' || aux=='<' || aux=='['){
                            pila[posicionPila] = aux;
                            posicionPila++;
                        }
                        else if (aux==')' || aux=='}' || aux=='>' || aux==']'){
                            switch (aux){
                                case ')': {if (posicionPila > 0 && pila[posicionPila-1] == '(') { posicionPila--;} else {ilegal=3;} } ;break;
                                case ']': {if (posicionPila > 0 && pila[posicionPila-1] == '[') { posicionPila--;} else {ilegal=57;} } ;break;
                                case '}': {if (posicionPila > 0 && pila[posicionPila-1] == '{') { posicionPila--;} else {ilegal=1197;} } ;break;
                                case '>': {if (posicionPila > 0 && pila[posicionPila-1] == '<') { posicionPila--;} else {ilegal=25137;} } ;break;
                            }
                            
                            
                        }
                    }
               }
               cambios+=ilegal;
               System.out.println("Ilegal: "+ilegal);
               posicionPila=0;
               ilegal = 0;
               
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
        AdventOfCode_Java_dia10 p = new AdventOfCode_Java_dia10();
        System.out.println (p.cuentaCambios());
             
    }
    
}
