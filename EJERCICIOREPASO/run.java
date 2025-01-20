public class run {
    public static void main(String[] args) {
       Cola nuevacola = new Cola();
       Caja caja1 = new Caja(nuevacola, 1);
       Caja caja2 = new Caja(nuevacola, 2);
       Caja caja3 = new Caja(nuevacola, 3);
       Cliente cliente1 = new Cliente(nuevacola, 1);
       Cliente cliente2 = new Cliente(nuevacola, 2);
       Cliente cliente3 = new Cliente(nuevacola, 3);
       Cliente cliente4 = new Cliente(nuevacola, 4);
       Cliente cliente5 = new Cliente(nuevacola, 5);
       Cliente cliente6 = new Cliente(nuevacola, 6);

       caja1.start();
       caja2.start();
       caja3.start();

       cliente1.start();
       cliente2.start();
       cliente3.start();
       cliente4.start();
       cliente5.start();
       cliente6.start();
    }
}
