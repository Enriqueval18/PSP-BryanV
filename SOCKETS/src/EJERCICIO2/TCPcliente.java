package EJERCICIO2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

public class TCPcliente {
    public static void main(String[] args) throws IOException {
        //String servidor = "192.168.114.119";
        String servidor = "localhost";
        int puerto = 6666;
        Random random = new Random();
        int[] numeros = new int [10];
        for (int i = 0;i<10;i++){
            numeros[i]= random.nextInt(10);
        }
        ByteBuffer buffer = ByteBuffer.allocate(numeros.length * 4);
        for (int num : numeros) {
            buffer.putInt(num);
        }
        byte[] array = buffer.array();

        Socket socket = new Socket(servidor, puerto);
        DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());


        flujoSalida.write(array);

        System.out.println("Array enviado al servidor.");
        DataInputStream flujoEntrada = new  DataInputStream(socket.getInputStream());

        //
        System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readInt());

        socket.close();


    }
}
