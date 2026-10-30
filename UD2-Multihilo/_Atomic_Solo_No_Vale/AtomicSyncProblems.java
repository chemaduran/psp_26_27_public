package U2_Multihilo.teoria._Atomic_Solo_No_Vale;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSyncProblems extends Thread {
  public static final AtomicInteger counter = new AtomicInteger(0);
  private final int LIMIT = 100;

  @Override
  public void run() {
    for (long i = 0; i < 100; i++) {
      // Comprobamos si se ha alcanzado el límite
      if (counter.get() < LIMIT) {
        // Simulamos algo de trabajo
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        // Incrementamos el contador si la condición se mantiene
        counter.incrementAndGet();
      }
    }
  }
}
