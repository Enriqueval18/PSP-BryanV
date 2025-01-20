public class Producto2 extends Thread{
    private Cola2 cola;

    public Producto2(Cola2 c) {
        cola = c;
    }
    public void run() {
        for (int i = 0; i < 15; i++) {
            int numeroAleatorio = (int) (Math.random()*1000)+1;
            cola.put(numeroAleatorio); 
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }			
			
        }
    }
}
