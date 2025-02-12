package Entendido.EJERCICIO1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente1udp {
    public static void main(String[] argv) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        String destino = "192.168.114.103";
        InetAddress IPServidor = InetAddress.getByName(destino);
        int port = 12345;


        // escrbio el numero el numero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero");
        int numero = teclado.nextInt();
                
        byte b = (byte) numero;
        byte[] conversor = new byte[8];
        conversor[0] = b;

        // enviamos al servidor el numero
        DatagramPacket envio = new DatagramPacket(conversor, conversor.length, IPServidor, port);
        clientSocket.send(envio);
        System.out.println("Numero "+numero+ " enviado" );







        //recibo del servidor y lo muestro
    
        byte[] recibidos = new byte[8];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        clientSocket.receive(recibo);
    
        byte[] hh = recibo.getData();
        long numero2 = hh[0];
        System.out.println("He recibido: " + numero2);


    

        clientSocket.close();
    }
}
