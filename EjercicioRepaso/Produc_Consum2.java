public class Produc_Consum2 {
    public static void main(String[] args) {
    Cola2 cola = new Cola2();
	
    Producto2  prod = new Producto2(cola);	
    //los distingo la n por numeros 
	Consumidor2 cons = new Consumidor2(cola, 1);
    Consumidor2 cons2 = new Consumidor2(cola, 2);
    Consumidor2 cons3 = new Consumidor2(cola, 3);

    
    prod.start();
	cons.start();
    cons2.start();
    cons3.start();  
    
}
}
