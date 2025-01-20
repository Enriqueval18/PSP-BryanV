public class Produc_Consum {
  public static void main(String[] args) {  
    //recurso compartido
    Cola cola = new Cola();
	
    //Hilos, productor y consumidor
    Productor prod = new Productor(cola, 1);	
	  Consumidor cons = new Consumidor(cola, 1);
    
    //lanzas los hilos a ejecucion
    prod.start();
	  cons.start();

  }
}