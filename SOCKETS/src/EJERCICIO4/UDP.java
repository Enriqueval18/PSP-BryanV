package EJERCICIO4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        //CON ESTO SE CONECTA
        DatagramSocket clientSocket = new DatagramSocket();
        String destino = "192.168.114.103";
        InetAddress IPServidor = InetAddress.getByName(destino);
        int port = 12345;

        //AQUI SE PONE LO QUE VAMOS A ENVIAR
        System.out.println("INTRODUCE LA IP");
        String ip = teclado.next();

        //CON ESTO SE CONVIERTE A BYTES PARA ENVIAR
        byte[] conversor = ip.getBytes(); //se convierte de string a bytes

        //CON ESTO SE ENVIA
        DatagramPacket envio = new DatagramPacket(conversor, conversor.length, IPServidor, port);
        clientSocket.send(envio);
        System.out.println("IP ENVIADA "+ip );



        //CON ESTO SE RECIBE
        byte[] recibidos = new byte[8];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        clientSocket.receive(recibo);

        //CON ESTO SE CONVIERTE DE BYTES A NORMAL
        String hola = new String(recibo.getData(),0,recibo.getLength()).trim();
        if(hola.startsWith("-")){
            System.out.println("DIRECCION IP INVALIDA : "+ ip);
        }
        else{
            System.out.println("DIRRECCION IP VALIDA , he recibido " +hola);

        }



        //CON ESTO SE CIERRA
        clientSocket.close();


    }
}
