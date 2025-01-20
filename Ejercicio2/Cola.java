import java.util.concurrent.ArrayBlockingQueue;

public class Cola {
	private int numero;
	private int nveces = 0;
	private ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);

	public synchronized void put(int valor) {
		if (lista.size() == 5) {
			try {
				System.out.println("Productor a la espera, cola llena");
				wait();
			} catch (InterruptedException e) {
			}
		}
		try {
			lista.put(valor);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Productor produce: " + valor);
		
		notifyAll();
	}

	public synchronized int get(int n) {
		if (nveces == 2) {	
			lista.remove();
			nveces = 0;
		}

		if (lista.size() == 0) {
			System.out.println("Consumidor espera, cola vacia");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		numero = lista.peek();
		nveces++;
		System.out.println("Consumidor " + n + " consume: " + numero);
		notifyAll();
		return numero;
	}

}
