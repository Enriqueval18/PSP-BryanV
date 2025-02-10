package Entendido;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class TCP2 {
	public static void main(String[] args) throws IOException {
		int port = 6666;
		ServerSocket serverSocket = new ServerSocket(port);

		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado.");

			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

			int length = inputStream.readInt();
			byte[] byteArray = new byte[length];
			inputStream.readFully(byteArray);

			// Esto convierte de bytes a int
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
			int resultado = suma + mayor + menor;
			outputStream.writeInt(resultado);
			System.out.println("Resultados enviados al cliente: " + resultado);

			socket.close();
		}

	}

}
