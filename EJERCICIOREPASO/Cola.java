import java.util.concurrent.ArrayBlockingQueue;

public class Cola {
    private int ncaja;
    private ArrayBlockingQueue<Integer> disponible = new ArrayBlockingQueue<>(3);

    public synchronized int obtener() {
        while (disponible.isEmpty()) { 
            try {
                wait();
            } catch (Exception e) {}
        }
        try {
            ncaja = disponible.take(); 
        } catch (Exception e) {}
        notifyAll(); 
        return ncaja;
    }

    public synchronized void entrar(int n) {
        while (disponible.size() == 3) { 
            try {
                wait();
            } catch (Exception e) {
            }
        }
        disponible.offer(n); 
        notifyAll(); 
    }
}
