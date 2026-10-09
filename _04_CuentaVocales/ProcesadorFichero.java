package U1_Multiproceso._04_CuentaVocales;

import U1_Multiproceso._02_EjecutandoConsola.EjecutaConsola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static U1_Multiproceso._04_CuentaVocales.UtilidadesFicheros.getLineasFichero;

public class ProcesadorFichero {
    private String nombreFichero;
    private static final Logger logger = Logger.getLogger(ProcesadorFichero.class.getName());

    public ProcesadorFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public int hacerRecuento(String letra) {
        int recuento = 0;
        try {
            ArrayList<String> lineas = getLineasFichero(nombreFichero);
            for (String linea : lineas) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == letra.charAt(0)) {
                        recuento++;
                    }
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al abrir el fichero");
        }
        return recuento;
    }

    public void escribirResultado(String nombreFicheroResultado, int recuento) {
        try {
            PrintWriter printWriter = UtilidadesFicheros.getPrintWriter(nombreFicheroResultado);
            printWriter.println(recuento);
            printWriter.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al abrir el fichero");
        }
    }
}
