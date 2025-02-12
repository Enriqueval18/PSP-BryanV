package Entendido.EJERCICIO1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente2udp {
  public static void main(String[] argv) throws Exception {
    DatagramSocket clientSocket = new DatagramSocket(12347);// socket cliente
    String destino = "192.168.114.103";
    InetAddress IPServidor = InetAddress.getByName(destino);
    int port = 12346; // puerto

    // recibo numero
    byte[] conversor = new byte[4];
    DatagramPacket recibo = new DatagramPacket(conversor, conversor.length);
    clientSocket.receive(recibo);

    byte[] hh = recibo.getData();
    int numero2 = hh[0];
    System.out.println("He recibido: " + numero2);


    long factorial = numero2;
    //calculo el factorial
    for (int i = 1; i < numero2; i++) {
        factorial = factorial* i;
    }
    System.out.println("Factorial terminado");



    // lo envio
    // String paso = String.valueOf(factorial);
    byte b = (byte) factorial;
    byte[] conversor2 = new byte[8];
    conversor2[0] = b;

    // enviamos al servidor el numero
    DatagramPacket envio = new DatagramPacket(conversor2, conversor2.length, IPServidor, port);
    clientSocket.send(envio);
    System.out.println("Numero " + factorial + " enviado");

    clientSocket.close();// cerrar socket
  }
}
