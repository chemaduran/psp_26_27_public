package U2_Multihilo.teoria._Atomic_Solo_No_Vale;

public class App {
  public static void main(String[] args) {
		final int NUM_HILOS = 100;
    // Crear un array de 100 hilos
    Thread[] threads = new Thread[NUM_HILOS];

    // Inicializar todos los hilos
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new AtomicSyncProblems();
    }

    // Iniciar todos los hilos
    for (Thread thread : threads) {
      thread.start();
    }

    // Esperar a que todos los hilos terminen
    try {
      for (Thread thread : threads) {
        thread.join();
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    System.out.println("Valor final del contador: " + AtomicSyncProblems.counter.get());
  }
}
