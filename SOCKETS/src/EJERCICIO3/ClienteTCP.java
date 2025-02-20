package EJERCICIO3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class ClienteTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        String Host = "192.168.114.100";
        int Puerto = 6000;
        Socket cliente = new Socket(Host, Puerto);
        Factura factura = new Factura("2","hoy",200.0,"IGC");

        //envio el objecto
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        perSal.writeObject(factura);
        System.out.println("Envio: "+factura.getNumerofactura()+"*"+factura.fechafactura+"*"+factura.importe +"*"+factura.tipoiva);

        //recibo
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
        Factura dato = (Factura) perEnt.readObject();
        System.out.println("Recibo: "+dato.getNumerofactura()+"*"+dato.getImporte() +"*"+dato.getIva() +"*"+dato.getImportetotal());

        perSal.close();
        perEnt.close();
        cliente.close();

    }
}
