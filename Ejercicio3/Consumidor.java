
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
        for (int i = 0; i < 30; i++) {
            valor = cola.get(n);
            if(n == 1){
                if(valor %2 == 0){
                    suma = valor + suma;
                }
            }
            if(n==2){
                if(valor %2 ==1 ){
                    producto = valor + producto;
                }
                
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(n==1){
            System.out.println("El consumidor 1 da un total de pares de : " +suma) ;
        }
        if(n==2){
            System.out.println("EL consumidor 2 da un total de impares de: " +producto);
        }
    }
}
