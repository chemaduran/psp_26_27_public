package U1_Multiproceso.resolucion.entregable_25_26.ej3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Operador {
    public static void main(String[] args) {
        if (args.length == 3) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            // hacer operaciones
            switch (args[2]) {
                case "+":
                    escribirOperacion(String.valueOf(num1 + num2));
                    break;
                case "-":
                    escribirOperacion(String.valueOf(num1 - num2));
                    break;
                case "x":
                    escribirOperacion(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        escribirOperacion(String.valueOf(num1 / num2));
                    } else {
                        System.out.println("División por cero");
                    }
                    break;
                default:
                    System.out.println("Error en el formato de la operación: operaciones válidas: + - x /");

            }
        } else {
            System.out.println("Faltan parámetros");
        }
    }

    public static void escribirOperacion(String resultado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("OPERACIONES.LOG", true))) {
            System.out.println("HIJO: " + resultado);
            bw.write(resultado);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("error al escribir la operación a fichero");
        }

    }
}
