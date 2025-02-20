package EJERCICIO3;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClienteUDP {
    public static void main(String[] args) throws UnknownHostException {
        try {
            //CON ESTO SE CONECTA
            DatagramSocket socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.114.103");

            //OBJECTO A CONECTAR
            Factura factura = new Factura("2","hoy",200.0,"IGC");


            //CON ESTO ENVIO
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(factura);
            byte[] sendData = byteStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6000);
            socket.send(sendPacket);



            //RECIBO
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            ByteArrayInputStream byteStream2 = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream objectStream2 = new ObjectInputStream(byteStream2);
            Object receivedObject = objectStream2.readObject();
            Factura factura1 = (Factura) receivedObject;
            System.out.println("Recibo: "+factura1.getNumerofactura()+"*"+factura1.getImporte());


            //CIERRO
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
