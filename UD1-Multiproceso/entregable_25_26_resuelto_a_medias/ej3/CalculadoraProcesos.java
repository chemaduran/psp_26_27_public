package U1_Multiproceso.resolucion.entregable_25_26.ej3;

import U1_Multiproceso._03_PadreHijo.Hijo;
import U1_Multiproceso._03_PadreHijo.ProcesoJava;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;

public class CalculadoraProcesos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Introduce el primer número: ");
//        String num1 = sc.nextLine();
//        System.out.print("Introduce el segundo número: ");
//        String num2 = sc.nextLine();
//        System.out.print("Introduce la operación (+, -, *, /): ");
//        String operacion = sc.nextLine();

        String[] parametros = new String[3];
        parametros[0] = "12";
        parametros[1] = "4";
        parametros[2] = "+";

        try {
            Process p = ProcesoJava.exec(Operador.class, parametros);

            int salida = p.waitFor();
            getSalidaProceso(p);

            System.out.println("Proceso hijo finalizado con valor: " + salida);
            System.out.println("Proceso padre finalizado");

        } catch (IOException | InterruptedException e) {
            escribirErrores("El hijo no se ha ejecutado correctamente");
        }
    }

    private static void getSalidaProceso(Process p) {
        String line = "";
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        // Se muestra la salida del proceso por pantalla
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                escribirErrores(e.getMessage());
            }

            // Hay que comprobar si "line" es un número o no, para pintar normal o redigir a la salida de errores.txt
            try {
                Integer.parseInt(line);
            } catch (NumberFormatException e) {
                escribirErrores(line);
            }
        }

        // Cuando finaliza se cierra el descriptor del proceso
        try {
            is.close();
        } catch (IOException e) {
            escribirErrores(e.getMessage());
        }
    }


    public static void escribirErrores(String error) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ERRORES.TXT", true))) {
            System.out.println("PADRE: " + error);
            bw.write(error);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("error en la operación");
        }

    }
}
