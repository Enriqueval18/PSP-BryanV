import java.util.concurrent.ArrayBlockingQueue;

public class Cola {
    private int numero;
	private ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);
    
    
    public synchronized int get() {
		try {
			if(lista.size() == 0){
				wait();
			 }
		} catch (Exception e) {}
		
		try {
			numero = lista.take();
		} catch (Exception e) {}
    	notify();
		return numero;
    	}


    public synchronized void put(int valor) {
		if(lista.size() == 5){
			try {
				System.out.println("Productor a la espera, cola llena");
				wait();
    	    } catch (InterruptedException e) { }
		}
		  lista.offer(valor);
    	  notify();
    	}
    
}
