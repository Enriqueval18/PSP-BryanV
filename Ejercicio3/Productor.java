public class Productor extends Thread {
    private Cola cola;
    public Productor(Cola c) {
        cola = c;
    }

    public void run() {
        
        for (int i = 0; i < 30; i++) {
            int numeroAleatorio = (int) (Math.random()*10)+1;
            cola.put(numeroAleatorio); 	
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}


