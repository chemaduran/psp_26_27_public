package U1_Multiproceso._04_CuentaVocales;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lanzador {
    private static final Logger logger = Logger.getLogger(Lanzador.class.getName());

    /**
     * Dado un fichero pasado como argumento, contará cuantas apariciones hay de una cierta vocal
     * (pasada como argumento) y dejará la cantidad en otro fichero (también pasado como argumento)
     */
    //  public static void main(String[] args) {
    //    String nombreFicheroEntrada = args[0];
    //    System.out.println(nombreFicheroEntrada);
    //    String letra = args[1];
    //    String nombreFicheroResultado = args[2];
    //    hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);
    //    // Fin del main
    //  }
    public static void main(String[] args) {
        String ficheroEntrada;
        ficheroEntrada = args[0];
        String classpathUtilidades;
        classpathUtilidades = args[1];
        String classpathProcesadorFichero;
        classpathProcesadorFichero = args[2];
        String[] vocales = {"A", "E", "I", "O", "U"};
        String classPath;
        classPath = classpathProcesadorFichero + ":" + classpathUtilidades;
        System.out.println("Usando classpath:" + classPath);
        /* Se lanzan los procesos*/
        for (String vocal : vocales) {
            String fichErrores = "Errores_" + vocal + ".txt";
            ProcessBuilder pb;
            pb =
                    new ProcessBuilder(
                            "java",
                            "-cp",
                            classPath,
                            "U1_Multiproceso._04_CuentaVocales.ProcesadorFichero",
                            ficheroEntrada,
                            vocal,
                            vocal + ".txt");
            // Si hay algún error, almacenarlo en un fichero
            pb.redirectError(new File(fichErrores));
            try {
                pb.start();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error al iniciar el proceso");
            }
            // Fin del for
        }
        // Esperamos un poco
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Error en la espera");
        }
        /// La recogida de resultados se deja como ejercicio al lector.
    }

    private static void hacerRecuento(
            String nombreFicheroEntrada, String letra, String nombreFicheroResultado) {
        ProcesadorFichero pf = new ProcesadorFichero(nombreFicheroEntrada);
        int recuento = pf.hacerRecuento(letra);
        System.out.println("Recuento de " + letra + " en " + nombreFicheroEntrada + ": " + recuento);
        pf.escribirResultado(nombreFicheroResultado, recuento);
    }
}
