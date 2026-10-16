package U1_Multiproceso.resolucion.entregable_25_26.ej1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Lanzador {
    public static Process abrirEditorTexto(String rutaFichero) {
        ProcessBuilder pb;
        try {
            File f = new File(rutaFichero);
            if (!f.exists()) {
                f.createNewFile();
            }

            pb = new ProcessBuilder("notepad.exe", rutaFichero);

            return pb.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Process abrirExplorador(String rutaDirectorio) {
        ProcessBuilder pb;
        try {
            File f = new File(rutaDirectorio);
            if (!f.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("ERRORES.LOG", true))) {
                    bw.write("El directorio no existe: " + rutaDirectorio);
                    bw.newLine();
                }
                return null;
            } else {
                pb = new ProcessBuilder("explorer.exe", rutaDirectorio);

            }


            return pb.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
