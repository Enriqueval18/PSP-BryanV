package EJERCICIO1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente1tcp {
       public static void main(String[] args) throws Exception {
        String Host = "localhost";
        int Puerto = 6666;// puerto remoto
        Socket Cliente = new Socket(Host, Puerto);
        
        //Hago que el usuario escriba el numero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero");
        int numero = teclado.nextInt();


        //envio el numero al servidor
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeInt(numero);
        System.out.println("Enviando numero " +numero);




        //recibo el factorial del servidor
        DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());
        int resultado = flujoEntrada.readInt();
        System.out.println("Servidor, he recibido " +resultado);


    
        
        // CERRAR STREAMS Y SOCKETS	
        flujoSalida.close();
        flujoEntrada.close();		
        Cliente.close();	
    }
}
