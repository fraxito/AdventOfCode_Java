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
public class AdventOfCode_Java_dia10_b {

    
  
    public long cuentaCambios(){
        long cambios = 0;
        try {
            String nombrefichero="../datos/datos_10_2.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            ArrayList<String> lineasOK = new ArrayList();
            String strLine;
            char [] pila = new char[1000];
            int posicionPila = 0;
            char aux;
            int ilegal = 0;
            ArrayList<Long> pesos = new ArrayList();
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

               long cambios2=0;
               
               
               if (ilegal == 0){
                    for (int i=posicionPila-1; i>= 0; i--) {
                        switch (pila[i]){
                            case '(': {System.out.print(')'); cambios2 = cambios2 * 5 + 1;} break;
                            case '[': {System.out.print(']'); cambios2 = cambios2 * 5 + 2;} break;
                            case '{': {System.out.print('}'); cambios2 = cambios2 * 5 + 3;} break;
                            case '<': {System.out.print('>'); cambios2 = cambios2 * 5 + 4;} break;
                        }                   
                    }
                    lineasOK.add(strLine);
                    pesos.add(cambios2);
                    
                    System.out.println(""+cambios2);
               }
               
               posicionPila=0;
               ilegal = 0;
            }
            
            fstream.close();
            

            Collections.sort(pesos);
            cambios = pesos.get(pesos.size()/2);
            for (int i=0; i<pesos.size(); i++){
                System.out.println (i+" "+pesos.get(i));
            }            
            
            
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
        AdventOfCode_Java_dia10_b p = new AdventOfCode_Java_dia10_b();
        System.out.println (p.cuentaCambios());
             
    }
    
}
