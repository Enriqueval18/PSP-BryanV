package NORMAL;

import java.io.IOException;
import java.net.*;

public class PlantillaUDPCliente {
    public static void main(String[] args) throws IOException {
        //CON ESTO SE CONECTA
        DatagramSocket clientSocket = new DatagramSocket();
        String destino = "192.168.114.103";
        InetAddress IPServidor = InetAddress.getByName(destino);
        int port = 12345;

        //AQUI SE PONE LO QUE VAMOS A ENVIAR
        int numero =1;

        //CON ESTO SE CONVIERTE A BYTES PARA ENVIAR
        byte b = (byte) numero;
        byte[] conversor = new byte[8];
        conversor[0] = b;

        //CON ESTO SE ENVIA
        // enviamos al servidor el numero
        DatagramPacket envio = new DatagramPacket(conversor, conversor.length, IPServidor, port);
        clientSocket.send(envio);
        System.out.println("Numero "+numero+ " enviado" );

        //CON ESTO SE RECIBE
        byte[] recibidos = new byte[8];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        clientSocket.receive(recibo);

        //CON ESTO SE CONVIERTE DE BYTES A NORMAL
        byte[] hh = recibo.getData();
        long numero2 = hh[0];
        System.out.println("He recibido: " + numero2);

        //CON ESTO SE CIERRA
        clientSocket.close();


    }
}
