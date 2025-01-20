public class Cliente extends Thread {
    private Cola cola;
    private int n;

    public Cliente(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
            cola.entrar(n);
            try {
                Thread.sleep(100); 
            } catch (Exception e) {
            }

    }
}
