public class Cola2 {
    private int numero;
	private int lista = 0;
    
    public synchronized int get(int n) {
		try {
			while (lista == 0) {
                wait();
            }
		} catch (Exception e) {}

		numero = lista;
		System.out.println( "Camion "+ n + " carga: " + numero +" Litros");
    	lista = 0;
		notify();
		return numero;
    	}

    public synchronized void put(int valor) {
		if(lista != 0){
			try {
				System.out.println("Productor a la espera, cola llena");
				wait();
    	    } catch (InterruptedException e) { }
		}
		System.out.println("Productor llena el deposito con ==> " + valor + " Litros");
		  lista = valor;
    	  notify();
    	}
}
