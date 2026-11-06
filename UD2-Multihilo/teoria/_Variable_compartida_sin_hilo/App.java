package U2_Multihilo.teoria._Variable_compartida_sin_hilo;

public class App {
  public static void main(String[] args) {
		final int NUM_OBJETOS = 10000;

		VariableCompartida[] variables = new VariableCompartida[NUM_OBJETOS];

    for (int i = 0; i < NUM_OBJETOS; i++) {
      variables[i] = new VariableCompartida();
    }

		for (int i = 0; i < NUM_OBJETOS; i++) {
			variables[i].run();
		}

    System.out.println("El valor del contador es: " + VariableCompartida.contador);
  }
}
