public class Consumidor2 extends Thread{
    private Cola2 cola;
    private int n;
    public Consumidor2(Cola2 c, int n) {
        cola = c;
        this.n = n;
    }
    public void run() {
        int valor = 0;
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(n); //recoge el numero
            suma = suma+valor;
            if(i == 4){
                System.out.println( "Camion "+ n + " Volumen Total recogido = "+ suma+ " Operacion de carga finalizada!!");
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) { }	
    }
}
