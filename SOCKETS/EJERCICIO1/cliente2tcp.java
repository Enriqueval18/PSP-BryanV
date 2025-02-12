package Entendido.EJERCICIO1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class cliente2tcp {
    public static void main(String[] args) throws Exception {

        String Host = "192.168.114.103";
        int Puerto = 6666;// puerto remoto
        Socket Cliente = new Socket(Host, Puerto);
    


        //recibe el numero 2
        DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());
        int numero = flujoEntrada.readInt();
        System.out.println("Recibiendo numero " + numero);


        int factorial = numero;
        //calculo el factorial
        for (int i = 1; i < numero; i++) {
            factorial = factorial* i;
        }
        System.out.println("Factorial terminado");

        //envia el numero 2
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeInt(factorial);
        System.out.println("Enviando numero "+ factorial);


        


        // CERRAR STREAMS Y SOCKETS	
        flujoEntrada.close();	
        flujoSalida.close();	
        Cliente.close();	
    }
}
