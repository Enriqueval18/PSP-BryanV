//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    // Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            valor = cola.get(); // recoge el n�mero
            suma = valor + suma;
            System.out.println("Consumidor: " + n
                    + ", consume: " + valor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
    }
}
