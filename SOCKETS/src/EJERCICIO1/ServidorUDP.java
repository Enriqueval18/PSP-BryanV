package EJERCICIO1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServidorUDP {
    public static void main(String[] args) throws IOException {

        // Asocio el socket al puerto 12345
        DatagramSocket socket = new DatagramSocket(12345);
        DatagramSocket socket2 = new DatagramSocket(12346);
        System.out.println("Servidor Esperando Datagrama .......... ");
        DatagramPacket recibo;

        byte[] bufer = new byte[1024]; // para recibir el datagrama
        recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo); //recibo datagrama

        byte[] hh = recibo.getData();
        int numero = hh[0];

        System.out.println("Servidor Recibe:" + numero);

        // DIRECCION ORIGEN DEL MENSAJE
        InetAddress IPOrigen = InetAddress.getByName("localhost");
        int puerto = 12347;

        // ENVIANDO DATAGRAMA AL CLIENTE
        System.out.println("Enviando numero "+numero);
        byte b = (byte) numero; // paso entero a byte
        byte[] enviados = new byte[2];
        enviados[0] = b;

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket2.send(envio);

        System.out.println("Servidor Esperando Datagrama .......... ");
        DatagramPacket recibo2;

        byte[] bufer2 = new byte[1024]; // para recibir el datagrama
        recibo2 = new DatagramPacket(bufer2, bufer2.length);
        socket2.receive(recibo2); //recibo datagrama

        byte[] hh2 = recibo2.getData();
        int numero2 = hh2[0];

        System.out.println("Servidor Recibe:" + numero2);

        // DIRECCION ORIGEN DEL MENSAJE
        InetAddress IPOrigen2 = recibo.getAddress();
        int puerto2 = recibo.getPort();

        // ENVIANDO DATAGRAMA AL CLIENTE
        System.out.println("Enviando numero "+numero2);
        byte b2 = (byte) numero2; // paso entero a byte
        byte[] enviados2 = new byte[4];
        enviados2[0] = b2;

        DatagramPacket envio2 = new DatagramPacket(enviados2, enviados2.length, IPOrigen2, puerto2);
        socket.send(envio2);



        // CERRAR STREAMS Y SOCKETS
        System.out.println("Cerrando conexion...");
        socket.close();
        socket2.close();

    }

}
