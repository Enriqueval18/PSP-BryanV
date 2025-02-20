package EJERCICIO4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TPC {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        //ESTO SIRVE PARA CONECTARSE
        String Host = "192.168.114.103";
        int Puerto = 6666;// puerto remoto
        Socket Cliente = new Socket(Host, Puerto);


        //AQUI SE PONE QUE QUIERES ENVIAR
        System.out.println("INTRODUCE LA IP");
        String ip = teclado.next();


        //CON ESTO SE ENVIA
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeUTF(ip);
        System.out.println("IP ENVIADO: "+ip);


        //CON ESTO SE RECIBE
        DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());
        String resultado = flujoEntrada.readUTF();
        if(resultado.startsWith("-")){
            System.out.println("DIRECCION IP INVALIDA : "+ ip);
        }
        else{
            System.out.println("DIRRECCION IP VALIDA , he recibido " +resultado);

        }


        //SE CIERRA LAS COSAS
        flujoSalida.close();
        flujoEntrada.close();
        Cliente.close();

    }
}
