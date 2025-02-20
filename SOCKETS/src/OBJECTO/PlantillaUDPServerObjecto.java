package OBJECTO;

import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import EJERCICIO3.Factura;

public class PlantillaUDPServerObjecto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //CON ESTO SE ENVIA
        int numeroPuerto = 6000;
        DatagramSocket socket = new DatagramSocket(numeroPuerto);

        //CREO UN ARRAY PARA RECIBIR
        byte[] receiveData = new byte[1024];

        //CON ESTO RECIBO
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        Object receivedObject = objectStream.readObject();

        //LO ALMACENO EN SU PROPIO OBJECTO
        Factura factura = (Factura) receivedObject;
        System.out.println("Recibo: "+factura.getNumerofactura()+"*"+factura.getImporte());


        //HAGO LAS OPERACIONES
        String tipo;
        double iva = 0;
        double importeTotal;
        tipo = factura.getTipoiva();
        if (tipo.equals("IGC")){
            iva = factura.getImporte() * 0.7;
        }else if (tipo.equals("ESP")){
            iva = factura.getImporte() * 0.21;
        }else if (tipo.equals("EUR")){
            iva = factura.getImporte() * 0.15;
        }

        importeTotal = factura.getImporte() + iva;
        factura.setIva(iva);
        factura.setImportetotal(importeTotal);


        //CON ESTO ENVIO
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        ByteArrayOutputStream byteStream2 = new ByteArrayOutputStream();
        ObjectOutputStream objectStream2 = new ObjectOutputStream(byteStream2);
        objectStream2.writeObject(factura);
        byte[] sendData = byteStream2.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        socket.send(sendPacket);



        System.out.println("enviado");
    }
}
