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
public class AdventOfCode_Java_dia05b {

    public int[] formateaArray(String n) {
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            numeros[i] = Integer.parseInt((n.substring(3 * i, 3 * i + 2)).trim());
        }
        return numeros;
    }

    public int cuentaCambios() {
        int cambios = 0;
        int ancho = 1000, alto = 1000;
        ArrayList<int[][]> listaCoordenadas = new ArrayList<>();
        try {
            String nombrefichero = "../datos/datos_5_1.txt";
            URI nombreArchivo = getClass().getResource(nombrefichero).toURI();
            FileInputStream fstream = new FileInputStream(new File(nombreArchivo));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int[][] mapa = new int[alto][ancho];
            while ((strLine = br.readLine()) != null) {
                String[] parejas = strLine.split("->");
                String[] parejaA = parejas[0].split(",");
                String[] parejaB = parejas[1].split(",");
                int[] pareja = new int[4];
                pareja[0] = Integer.parseInt(parejaA[0].trim());
                pareja[1] = Integer.parseInt(parejaA[1].trim());
                pareja[2] = Integer.parseInt(parejaB[0].trim());
                pareja[3] = Integer.parseInt(parejaB[1].trim());
                //System.out.println(Arrays.toString(pareja));

                if (pareja[1] == pareja[3]) {
                    for (int x = Math.min(pareja[0], pareja[2]); x <= Math.max(pareja[0], pareja[2]); x++) {
                        mapa[pareja[1]][x]++;
                    }
                } else if (pareja[0] == pareja[2]) {
                    for (int y = Math.min(pareja[1], pareja[3]); y <= Math.max(pareja[1], pareja[3]); y++) {
                        mapa[y][pareja[0]]++;
                    }
                } else {
                    //como si fuera un vector
                    int direccion = (pareja[3] - pareja[1]) / (pareja[2] - pareja[0]);

                    if (direccion == 1) {
                        if (pareja[0] < pareja[2]) {
                            for (int x = pareja[0]; x <= pareja[2]; x++) {
                                mapa[pareja[1]][x]++;
                                pareja[1]++;
                            }
                        } else if (pareja[2] < pareja[0]) {
                            for (int x = pareja[2]; x <= pareja[0]; x++) {
                                mapa[pareja[3]][x]++;
                                pareja[3]++;
                            }
                        }
                    } else if (direccion == -1) {
                        if (pareja[0] < pareja[2]) {
                            for (int x = pareja[0]; x <= pareja[2]; x++) {
                                mapa[pareja[1]][x]++;
                                pareja[1]--;
                            }
                        } else if (pareja[2] < pareja[0]) {
                            for (int x = pareja[2]; x <= pareja[0]; x++) {
                                mapa[pareja[3]][x]++;
                                pareja[3]--;
                            }
                        }
                    }
                }
            }
            //ya están los datos en el array
            int contador = 0;
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    //System.out.print(mapa[j][i] + " ");
                    if (mapa[i][j] > 1) {

                        contador++;
                    }
                }
                //System.out.println("");
            }
            //Close System.out.println("");the input stream
            fstream.close();
            System.out.println("");
            System.out.println("HAY : " + contador);

            //System.out.println(Arrays.deepToString(mapa));
        } catch (IOException ex) {
            Logger.getLogger(AdventOfCode_Java_dia05b.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdventOfCode_Java_dia05b.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cambios;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdventOfCode_Java_dia05b p = new AdventOfCode_Java_dia05b();
        System.out.println(p.cuentaCambios());
    }

}
