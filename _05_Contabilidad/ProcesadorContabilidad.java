package U1_Multiproceso._05_Contabilidad;

import U1_Multiproceso._02_EjecutandoConsola.EjecutaConsola;
import U1_Multiproceso._04_CuentaVocales.UtilidadesFicheros;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesadorContabilidad {
    private static final Logger logger = Logger.getLogger(ProcesadorContabilidad.class.getName());

    public static void main(String[] args) {
        String nombreFichero = args[0];
        String nombreFicheroResultado = args[1];
        System.out.println("Procesando " + nombreFichero);
        System.out.println("Resultado en " + nombreFicheroResultado);
        ArrayList<String> cantidades;
        long total = 0;
        try {
            // Extraemos las cantidades
            cantidades = UtilidadesFicheros.getLineasFichero(nombreFichero);
            // Y las sumamos una por una
            for (String lineaCantidad : cantidades) {
                long cantidad = Long.parseLong(lineaCantidad);
                total = total + cantidad;
                // Fin del for que recorre las cantidades
            }
            // Almacenamos el total en un fichero
            PrintWriter pw;
            pw = UtilidadesFicheros.getPrintWriter(nombreFicheroResultado);
            pw.println(total);
            pw.close();
        } // Fin del try
        catch (IOException e) {
            logger.log(Level.SEVERE, "No se pudo procesar el fichero " + nombreFichero);
        }
        // Fin del main
    }
}
