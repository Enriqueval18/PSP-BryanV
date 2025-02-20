package EJERCICIO2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class TCPserver {
	public static void main(String[] args) throws IOException {

		int port = 6666;
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = null;


		while (true) {
			 socket = serverSocket.accept();
			System.out.println("Cliente conectado.");

			//CON ESTO LEO
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			int length = inputStream.readInt();
			byte[] byteArray = new byte[length];
			inputStream.readFully(byteArray);

			// Esto convierte array
			ByteBuffer buffer = ByteBuffer.wrap(byteArray);
			int[] intArray = new int[byteArray.length / 4];
			for (int i = 0; i < intArray.length; i++) {
				intArray[i] = buffer.getInt();
			}

			// array de int ya convertidor
			int[] receivedArray = intArray;

			// recibo la array
			System.out.println("Array recibido:");
			for (int num : receivedArray) {
				System.out.print(num + " ");
			}
			System.out.println();

			// Calcular
			int suma = 0, mayor = receivedArray[0], menor = receivedArray[0];
			for (int num : receivedArray) {
				suma += num;
				if (num > mayor)
					mayor = num;
				if (num < menor)
					menor = num;
			}



			// Envio resultado
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			int resultado = suma + mayor + menor;
			outputStream.writeInt(resultado);
			System.out.println("Resultados enviados al cliente: " + resultado);

			socket.close();
		}

	}

}
