package NORMAL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PlantillaTCPServer {
    public static void main(String[] args) throws IOException {
        //CON ESTO SE CONECTA EL CLIENTE, SI QUIERES MAS COPIAS Y PEGAS
        int port = 6666;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Cliente conectado.");

        //CON ESTO RECIBO LOS BYTES ENVIADOS
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        int length = inputStream.readInt();

        byte[] byteArray = new byte[length];
        inputStream.readFully(byteArray);

        //LO CONVIERTO DE BYTES A ENTERO
        int suma = 1;
        int mayor = 2;
        int menor = 3;


        //CON ESTO ENVIO EL RESULTADO
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        int resultado = suma + mayor + menor;
        outputStream.writeInt(resultado);
        System.out.println("Resultados enviados al cliente: " + resultado);

        //CON ESTO CIERRO
        socket.close();

    }
}
