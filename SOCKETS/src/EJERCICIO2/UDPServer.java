package EJERCICIO2;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.IOException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        int port = 6666;
        DatagramSocket serverSocket = new DatagramSocket(port);
        
            while (true) {
                // Recibir el array de bytes
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);





                // Convertir los bytes a un array de enteros
                int[] receivedArray = bytesToIntArray(receivePacket.getData(), receivePacket.getLength());

                System.out.println("Array recibido del cliente:");
                for (int num : receivedArray) {
                    System.out.print(num + " ");
                }
                System.out.println();

                // Calcular la suma, el mayor y el menor
                int suma = 0, mayor = receivedArray[0], menor = receivedArray[0];
                for (int num : receivedArray) {
                    suma += num;
                    if (num > mayor) mayor = num;
                    if (num < menor) menor = num;
                }

                // Preparar la respuesta
                int respuesta = suma + mayor + menor;
                byte b = (byte) respuesta;
                byte[] conversor = new byte[8];
                conversor[0] = b;


                // Enviar la respuesta al cliente
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(conversor, conversor.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Resultados enviados al cliente: " + respuesta);
            }
    }


    private static int[] bytesToIntArray(byte[] bytes, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, 0, length);
        int[] intArray = new int[length / 4]; // Cada entero ocupa 4 bytes
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = buffer.getInt();
        }
        return intArray;
    }
}
