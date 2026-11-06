package U2_Multihilo.teoria._02c_Productor_Consumidor_ABC;

public class Abecedario {
  public static void main(String[] args) {
    int N = 5;

    BufferLetra buffer = new BufferLetra();
    H1 p = new H1(buffer, N);
    H2 c = new H2(buffer, N, "Consumer1");
    // H2 c2 = new H2(buffer, N,"Consumer2"); // Podemos jugar a poenr más consumidores, a ver qué tal se comportan

    p.start();
    c.start();
    // c2.start();

    // Espera de finalización de todo lo consumido
    try {
      c.join();
    } catch (InterruptedException e) {
      // Imprime la excepción y la pila de llamadas, línea a línea
      System.out.println("Error en la espera del consumidor: " + e.getLocalizedMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        System.out.println(element);
      }
    }
    System.out.println("Generación de " + N + " letras acabada");
  }
}
