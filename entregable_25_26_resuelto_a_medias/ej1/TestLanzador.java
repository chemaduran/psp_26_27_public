package U1_Multiproceso.resolucion.entregable_25_26.ej1;

public class TestLanzador {
    public static void main(String[] args) {
        String rutaFichero = "D:\\test.txt";
        String rutaDirectorio = "D:\\Chema";

        Process procesoEditor = Lanzador.abrirEditorTexto(rutaFichero);
        if (procesoEditor != null) {
            System.out.println("Editor de texto abierto con éxito.");
        } else {
            System.out.println("Error al abrir el editor de texto.");
        }

        Process procesoExplorador = Lanzador.abrirExplorador(rutaDirectorio);
        if (procesoExplorador != null) {
            System.out.println("Explorador de archivos abierto con éxito.");
        } else {
            System.out.println("Error al abrir el explorador de archivos.");
        }
    }
}
