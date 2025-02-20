package EJERCICIO4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TPCSERVER {
    public static void main(String[] args) throws IOException {
        //CON ESTO SE CONECTA EL CLIENTE, SI QUIERES MAS COPIAS Y PEGAS
        int port = 6666;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Cliente conectado.");


        //CON ESTO RECIBO LOS BYTES ENVIADOS
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String recibo = inputStream.readUTF();
        boolean ipvalida = true;
        if(recibo.length()<=7 || recibo.length()>=19){
            ipvalida = false;
        }
        try{
            InetAddress.getByName(recibo);
        }catch (Exception e){
            ipvalida = false;
        }




        //convertir
        String resultadofinal = convertToBinary(recibo);



        //CON ESTO ENVIO EL RESULTADO
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        String resultado = resultadofinal;


        if(ipvalida == true){
            outputStream.writeUTF(resultado);
            System.out.println("Resultados enviados al cliente: " + resultado);
        }
        else{
            resultado = "-"+resultado;
            outputStream.writeUTF(resultado);
        }

        //CON ESTO CIERRO
        socket.close();

    }
    public static String convertToBinary(String text) {
        StringBuilder binary = new StringBuilder();
        for (char c : text.toCharArray()) {
            String binaryChar = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binary.append(binaryChar).append(" "); // Agregar un espacio entre cada byte
        }
        return binary.toString().trim(); // Eliminar espacio extra al final
    }
}
