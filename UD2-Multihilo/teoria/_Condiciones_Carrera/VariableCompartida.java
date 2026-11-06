package U2_Multihilo.teoria._Condiciones_Carrera;

public class VariableCompartida extends Thread {
    public static int contador = 0;
//  public static AtomicInteger contador = new AtomicInteger();

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
            contador++;
//      contador.incrementAndGet();
    }
  }
}
