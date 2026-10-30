package U2_Multihilo.teoria._Condiciones_Carrera;

public class App {
  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
      new VariableCompartida().start();
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
	    System.out.println(e.getMessage());
    }
    System.out.println("El valor del contador es: " + VariableCompartida.contador);
  }
}
