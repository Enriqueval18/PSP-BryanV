package NORMAL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PlantillaTCPCLiente {
    public static void main(String[] args) throws IOException {
        //ESTO SIRVE PARA CONECTARSE
        String Host = "192.168.114.103";
        int Puerto = 6666;// puerto remoto
        Socket Cliente = new Socket(Host, Puerto);

        //AQUI SE PONE QUE QUIERES ENVIAR
        int numero = 3;

        //CON ESTO SE ENVIA
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeInt(numero);


        //CON ESTO SE RECIBE
        DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());
        int resultado = flujoEntrada.readInt();
        System.out.println("Servidor, he recibido " +resultado);


        //SE CIERRA LAS COSAS
        flujoSalida.close();
        flujoEntrada.close();
        Cliente.close();


    }
}
