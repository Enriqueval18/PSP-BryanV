package OBJECTO;

import EJERCICIO3.Factura;
import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PlantillaTCPServidorObjecto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //CON ESTO EL CLIENTE SE CONECTA
        int numeroPuerto = 6000;
        ServerSocket servidor =  new ServerSocket(numeroPuerto);
        Socket cliente = servidor.accept();

        //CON ESTO SE RECIBE EL OBJECTO
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        Factura factura = (Factura) inObjeto.readObject();
        System.out.println("Recibo: "+factura.getNumerofactura()+"*"+factura.getImporte());



        //SE HACEN LAS OPERACIONES
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


        //CON ESTO SE ENVIA
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        outObjeto.writeObject(factura);
        System.out.println("Envio: " + factura.getNumerofactura()+" iva "+factura.getIva()+ " total "+factura.getImportetotal());


        // CERRAR STREAMS Y SOCKETS
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();

    }
}
