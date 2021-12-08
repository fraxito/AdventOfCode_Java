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
public class AdventOfCode_Java_dia08_b {
      public boolean esAnagrama(String str1, String str2) { 
        if (str1.length()==0 || str2.length()==0){
            return false;
        }
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", "");  
        boolean status = true;  
        if (s1.length() != s2.length()) {  
            status = false;  
        } else {  
            char[] arrayS1 = s1.toLowerCase().toCharArray();  
            char[] arrayS2 = s2.toLowerCase().toCharArray();  
            Arrays.sort(arrayS1);  
            Arrays.sort(arrayS2);  
            status = Arrays.equals(arrayS1, arrayS2);  
        }  
        return status;
    } 
      
      public int cadenaIncluida(String str1, String str2) { 
        if (str1.length()==0 || str2.length()==0){
            return -1;
        }
        String s1 = str1.replaceAll("\\s", "");  
        String s2 = str2.replaceAll("\\s", ""); 
        if (s1.length() < s2.length()){ //para que en s1 siempre esté la cadena más larga de las dos
            String aux = s2;
            s1 = s2;
            s2 = aux;
        }
        char[] arrayS1 = s1.toLowerCase().toCharArray();  
        char[] arrayS2 = s2.toLowerCase().toCharArray(); 
        int cont = 0;
        for (int i=0; i<arrayS2.length;i++){
            for (int j=0; j<arrayS1.length;j++){
                if (arrayS2[i]==arrayS1[j]){
                    cont++;
                }
            }
        }
        return arrayS2.length - cont;
        
      }
public String sumados(String str1, String str2) { 
    String aux = ""+str1;
    int pos = 0;
    for (int i=0; i<str2.length(); i++){
        pos = 0;
        for (int j=0; j<str1.length(); j++){
            if (str2.charAt(i) == str1.charAt(j)){
                pos++;
            }
        }
        if (pos==0){aux = aux + str2.charAt(i);}
    }
    return aux;
}
public String restados(String str1, String str2) { 
    String aux = "";
    for (int i=0; i<str2.length(); i++){
        for (int j=0; j<str1.length(); j++){
            if (str2.charAt(i) == str1.charAt(j)){
                aux = aux + str2.charAt(i);
            }
        }
    }
    return aux;
}
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
                String[] nums = {"","","","","","","","","",""};
                String[] numerosA = linea[0].split(" ");
                String[] numerosB = linea[1].split(" ");
                //primero el bucle de los fáciles
                for (int i=0; i<numerosA.length; i++){
                    switch (numerosA[i].length()){
                        case 2: nums[1] = numerosA[i]; break;
                        case 4: nums[4] = numerosA[i]; break;
                        case 3: nums[7] = numerosA[i]; break;
                        case 7: nums[8] = numerosA[i]; break;
                    }
                }
                //con los fáciles en el array, miro a ver los chungos. Empiezo con 3 y 6
                for (int i=0; i<numerosA.length; i++){
                    switch (numerosA[i].length()){
                        case 5: {
                                //si tiene 3 iguales con el 7 o 2 con el 1, es el 3
                                if (cadenaIncluida(numerosA[i], nums[1])==0 || cadenaIncluida(numerosA[i], nums[7])==0 ){
                                    nums[3] = numerosA[i];
                                }
                        }; break;
                        case 6: {
                                //si tiene 1 distinto con el 7 o el 1, es el 6
                                if (cadenaIncluida(nums[1],numerosA[i] )==1 || cadenaIncluida(numerosA[i], nums[7])==1 ){
                                    nums[6] = numerosA[i];
                                }
                        }; break;
                    }
                }
                nums[9] = sumados(nums[4], nums[3]);
                nums[5] = restados(nums[9], nums[6]);
                
                //ya están todos excepto el 2 y  0
                 for (int i=0; i<numerosA.length; i++){
                    switch (numerosA[i].length()){
                        case 5: {
                            System.out.println(numerosA[i]);
                                if (!nums[3].equals(numerosA[i]) && !nums[5].equals(numerosA[i])){
                                    nums[2] = numerosA[i];
                                }
                        }; break;
                        case 6: {
                                if (!nums[6].equals(numerosA[i]) && !nums[9].equals(numerosA[i])){
                                    nums[0] = numerosA[i];
                                }
                                }
                        }; break;
                    }
                               
           
                
                
                
                for (int i=0; i<numerosB.length; i++){
                    for (int j=0; j<10; j++){
                        if (esAnagrama(numerosB[i], nums[j])){
                            System.out.print(j+" ");
                        }
                    }
                    
                }
                System.out.println("");
                System.out.println(Arrays.toString(nums));
            }
            
            fstream.close();
            System.out.println("El minimo coste es : "+cambios);
            
            System.out.println("distancia: "+cadenaIncluida("cbegaf","bdacg" ));
            
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia08_b.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia08_b.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia08_b p = new AdventOfCode_Java_dia08_b();
        System.out.println (p.cuentaCambios());
             
    }
    
}
