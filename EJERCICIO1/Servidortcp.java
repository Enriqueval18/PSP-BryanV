package EJERCICIO1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidortcp {
    public static void main(String[] args) throws IOException {
        int port = 6666;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        System.out.println("Cliente conectado 1.");

        //CON ESTO RECIBO DEL CLIENTE1
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        int numeroleido = inputStream.readInt();

        //ACEPTO EL CLIENTE 2
        Socket socket2 = serverSocket.accept();
        System.out.println("Cliente conectado 2.");

        //ENVIO AL CLIENTE2
        DataOutputStream outputStream = new DataOutputStream(socket2.getOutputStream());
        int resultado = numeroleido;
        outputStream.writeInt(resultado);
        System.out.println("Resultados enviados al cliente2: " + resultado);

        //RECIBO DEL CLIENTE2
        DataInputStream inputStream2 = new DataInputStream(socket2.getInputStream());
        int numeroleido2 = inputStream2.readInt();


        //ENVIO AL CLIENTE1
        DataOutputStream outputStream2 = new DataOutputStream(socket.getOutputStream());
        int resultado2 = numeroleido2;
        outputStream2.writeInt(resultado2);
        System.out.println("Resultados enviados al cliente1: " + resultado2);





        socket.close();
        socket2.close();


    }


}
