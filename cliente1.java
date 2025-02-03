import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente1 {
       public static void main(String[] args) throws Exception {
        String Host = "192.168.114.103";
        int Puerto = 6666;// puerto remoto

        System.out.println("PROGRAMA CLIENTE INICIADO....");
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
