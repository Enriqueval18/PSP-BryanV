public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int numeroAleatorio = (int) (Math.random()*10)+1;
            cola.put(numeroAleatorio); 
            System.out.println("Productor : " + n
                               + ", produce: " + numeroAleatorio);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }			
			
        }
    }
}


