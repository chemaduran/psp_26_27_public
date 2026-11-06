package U2_Multihilo.teoria._Variable_compartida_sin_hilo;

public class VariableCompartida {
	public static long contador = 0;

	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador++;
		}
	}
}
