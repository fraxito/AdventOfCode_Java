package adventofcode_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
public class AdventOfCode_Java_dia04 {

    public int[] formateaArray(String n){
        int[] numeros = new int[5];
        for (int i=0; i<5; i++){
            numeros[i]=Integer.parseInt((n.substring(3*i, 3*i+2)).trim());
        }
        return numeros;
    }
    
    public int chequeaCarton(ArrayList<int[][]> listaCartones){
        for (int k=0; k<listaCartones.size(); k++){
            int [][] carton = listaCartones.get(k);
            int suma = 0;
            for (int i=0; i<carton.length; i++){
                for(int j=0; j<carton[0].length; j++){
                    suma += carton[i][j];
                }
                if (suma == -5){ return k;}//si la suma es -5 entonces los 5 valen -1
                else {suma = 0;}
            }
            //lo mismo pero en columnas
            suma = 0;
            for (int i=0; i<carton.length; i++){
                for(int j=0; j<carton[0].length; j++){
                    suma += carton[j][i];
                }
                if (suma == -5){ return k;}//si la suma es -5 entonces los 5 valen -1
                else {suma = 0;}
            }
        }
        return -100;
    }
    
    public int cuentaCambios(){
        int cambios = 0;
        ArrayList<int[][]> listaCartones = new ArrayList<>();
        try {
            URI nombreArchivo = getClass().getResource("../datos/datos_4_2.txt").toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String [] numeros = (br.readLine()).split(",");
            
            for (int i=0; i<numeros.length; i++){
                //System.out.println (numeros[i]);
            }
            
            while ((strLine = br.readLine()) != null)   {

                    int [][] carton = new int[5][5];
                    for (int i=0; i<5; i++){
                        if ((strLine = br.readLine()) != null){
                            int [] fila = formateaArray(strLine);
                            for (int j=0; j<5; j++){
                                carton[i][j]=fila[j];
                            }
                        }
                    }
                    listaCartones.add(carton);
               
            }
            //ya est??n los cartones en el arraylist, ahora a jugar al bingo
            
            int contador = 0;
            boolean bingo = false;
            int numeroActual = 0;
            while (!bingo  && contador < numeros.length ){
                numeroActual = Integer.parseInt(numeros[contador]);
                for (int [][] carton : listaCartones){
                    for (int i=0; i<carton.length; i++){
                        for(int j=0; j<carton[0].length; j++){
                            if (carton[i][j] == numeroActual){
                                carton[i][j] = -1;  //si ha salido el n?? lo ponemos a -1 para indicarlo
                            }
                        }
                    }
                }
                //chequea cada carton por si tiene linea horizontal o vertical
                int cartonPremiado = chequeaCarton(listaCartones);
                bingo = ( cartonPremiado!= -100);
                if (bingo){
                    System.out.println("el cart??n premiado es: "+cartonPremiado);
                    System.out.println(Arrays.deepToString(listaCartones.get(cartonPremiado)));
                    int [][] carton = listaCartones.get(cartonPremiado);
                    int suma = 0;
                    for (int i=0; i<carton.length; i++){
                        for(int j=0; j<carton[0].length; j++){
                            if (carton[i][j] != -1){
                                suma += carton[i][j];
                            }
                        }
                    }
                    System.out.println("la suma es: "+suma);
                    System.out.println("y el resultado es: " + (suma*numeroActual));
                }
                contador++;
            }
            
            //Close the input stream
            fstream.close();

            System.out.println("HAY : "+listaCartones.size());
            
            
            
            
            
            
        }  catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia04.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia04.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia04 p = new AdventOfCode_Java_dia04();
        System.out.println (p.cuentaCambios());
    }
    
}
