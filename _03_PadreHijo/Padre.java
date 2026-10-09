package U1_Multiproceso._03_PadreHijo;

import U1_Multiproceso._02_EjecutandoConsola.EjecutaConsola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Padre {
    private static final Logger logger = Logger.getLogger(Padre.class.getName());

    public static void main(String[] args) {
        // Flujo de entrada para solicitar datos al usuario por teclado
        Scanner sc = new Scanner(System.in);

        try {
            // Introducción de datos (es necesario el control de errores)
            char opcion;

            do {
                Process p = ProcesoJava.exec(Hijo.class);

                // Se obtiene stdout del proceso hijo
                getSalidaProceso(p);

                // El proceso padre espera a que el hijo finalice
                int salida = p.waitFor();

                System.out.println("a ver que pinta " + p.getInputStream());
                System.out.println("Proceso hijo finalizado con valor: " + salida);
                System.out.println("Proceso padre finalizado");
                //        mostrarResultadoBuffer(p);

                // CONTROL DE NUEVA INSERCIÓN
                System.out.println("¿Desea lanzar más procesos (S/N)?: ");
                opcion = sc.nextLine().toUpperCase().charAt(0);
            } while (opcion == 'S');
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    // Función que obtiene la salida stdout del proceso hijo
    private static void getSalidaProceso(Process p) {
        String line = "";
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        // Se muestra la salida del proceso por pantalla
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
            System.out.println(line);
        }

        // Cuando finaliza se cierra el descriptor del proceso
        try {
            is.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void mostrarResultadoBuffer(Process p) {
        // Creamos el flujo de lectura con el proceso
        BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));

        try {
            // Guardamos la primera línea
            String linea = leer.readLine();
            // Leemos las líneas y las mostramos por panatalla
            while (linea != null) {
                System.out.println(linea);
                linea = leer.readLine();
            }
        } catch (IOException e) {
            // Controlamos el error por si hay error en el flujo de lectura
            logger.log(Level.SEVERE, "Error en el flujo de lectura");
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
