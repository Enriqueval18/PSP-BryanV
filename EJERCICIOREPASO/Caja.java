public class Caja extends Thread {
    private Cola cola;
    private int n;

    public Caja(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
            int valor = cola.obtener();
            System.out.println("Caja " + n + " atendiendo al cliente " + valor);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
    }
}
