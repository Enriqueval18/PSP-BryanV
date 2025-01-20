
public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        int suma = 0;
        int producto = 0;
        for (int i = 0; i < 10; i++) {
            valor = cola.get(n);
            if(n == 1){
                suma = valor + suma;
            }
            if(n==2){
                producto = valor + producto;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(n==1){
            System.out.println("El consumidor 1 da un total de: " +suma) ;
        }
        if(n==2){
            System.out.println("EL consumidor 2 da un total de: " +producto);
        }
    }
}
