package NORMAL;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PlantillaUDPServer {
    public static void main(String[] args) throws IOException {
        //CON ESTO SE CONECTA
        int port = 6666;
        DatagramSocket serverSocket = new DatagramSocket(port);

        //CON ESTO RECIBO
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        serverSocket.receive(receivePacket);



        //GENERO UNA RESPUESTA DE BYTES A ENTEROS
        int suma = 1;
        int mayor =2;
        int menor = 4;

        //CONVIERTO DE BYTES A ENTEROS
        int respuesta = suma + mayor + menor;
        byte b = (byte) respuesta;
        byte[] conversor = new byte[8];
        conversor[0] = b;

        //CON ESTO SE ENVIA
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();
        DatagramPacket sendPacket = new DatagramPacket(conversor, conversor.length, clientAddress, clientPort);
        serverSocket.send(sendPacket);

        //CON ESTO SE CIERRA
        serverSocket.close();
    }
}
