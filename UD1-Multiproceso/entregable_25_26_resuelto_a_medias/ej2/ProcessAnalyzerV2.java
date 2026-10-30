package U1_Multiproceso.resolucion.entregable_25_26.ej2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessAnalyzerV2 {
    private static final Logger logger = Logger.getLogger(ProcessAnalyzer.class.getName());
    private static final String rutaDirectorio = "C:";
    public static void main(String[] args) {
        String minimo;
        if (args.length > 0) {
            minimo = args[0];
        }else{
            minimo = "0";
        }
        ProcessBuilder pb = new ProcessBuilder();
        File ERORES_LOG = new File("ERRORES.LOG");
        try {
            pb.command("cmd.exe", "/c", "tasklist /FO LIST |find \"Nombre de imagen\"");
            Process p = pb.start();
            mostrarResultado(p, Integer.parseInt(minimo));
            pb.redirectError(ERORES_LOG);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarResultado(Process p, int minimo) {
        InputStream is = p.getInputStream();
        int letra = 0;
        StringBuilder linea = new StringBuilder();
        try {
            while ((letra = is.read()) != -1) {
                if (letra == '\n') {
                    if (linea.length() > minimo) {
                        System.out.println(linea);
                    }
                    linea.setLength(0);
                } else if (letra != '\r') {
                    linea.append((char) letra);
                }
            }
            if (linea.length() > minimo) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error al leer los datos del proceso");
        }

        try {
            is.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al leer los datos del proceso");
        }
    }

    public static void mostrarErrores(Process p) {
        logger.log(Level.INFO, "Entramos en mostrar errores");
        InputStream is = p.getErrorStream();
        int letra = 0;
        try {
            while ((letra = is.read()) != -1) {
                System.out.print((char) letra);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error al leer los datos del proceso");
        }
    }
}
