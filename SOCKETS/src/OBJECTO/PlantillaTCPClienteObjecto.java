package OBJECTO;

import EJERCICIO3.Factura;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlantillaTCPClienteObjecto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //CON ESTO SE CONECTA
        String Host = "192.168.114.103";
        int Puerto = 6000;
        Socket cliente = new Socket(Host, Puerto);

        //AQUI SE DEFINE EL OBJECTO QUE VAS A ENVIAR
        Factura factura = new Factura("2","hoy",200.0,"IGC");

        //CON ESTO SE ENVIA
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        perSal.writeObject(factura);
        System.out.println("Envio: "+factura.getNumerofactura());


        //CON ESTO RECIBO
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
        Factura dato = (Factura) perEnt.readObject();
        System.out.println("Recibo: "+dato.getNumerofactura()+"*"+dato.getImporte() +"*"+dato.getIva() +"*"+dato.getImportetotal());

        //CON ESTO SE DESCONECTA
        perSal.close();
        perEnt.close();
        cliente.close();


    }
}
